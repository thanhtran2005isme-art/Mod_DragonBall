import os,re,struct,csv,json
WORK='/mnt/data/dragonboy_v4_work'
with open(WORK+'/cX_o.bin','rb') as f:
    data=f.read()
O=list(struct.unpack('>%dh'%(len(data)//2),data))

def j32(x):
    x &= 0xffffffff
    return x-0x100000000 if x>=0x80000000 else x

def decode(off,n,key):
    if off<0 or n<0 or off+n>len(O): return None
    chars=[]
    for i in range(n):
        v = (O[off+i] ^ ((off+i)&63) ^ key ^ (i*31)) & 0xffff
        chars.append(chr(v))
    return ''.join(chars)

inst_re=re.compile(r'^\s*(\d+):\s+([a-zA-Z0-9_]+)(?:\s+([^/]+?))?\s*(?://\s*(.*))?$')
const_comment_re=re.compile(r'\bint\s+(-?\d+)')

def parse_const(op,arg,comment):
    if op=='iconst_m1': return -1
    m=re.fullmatch(r'iconst_([0-5])',op)
    if m:return int(m.group(1))
    if op in ('bipush','sipush'):
        try:return int((arg or '').strip().split()[0])
        except:return None
    if op in ('ldc','ldc_w'):
        if comment:
            m=const_comment_re.search(comment)
            if m:return int(m.group(1))
        # javap may put integer directly before comment-less
        s=(arg or '').strip()
        m=re.search(r'(-?\d+)$',s)
        if m:return int(m.group(1))
    return None

def eval_segment(lines):
    st=['O']
    for line in lines[1:]: # after getstatic O
        m=inst_re.match(line)
        if not m: continue
        pc,op,arg,comment=m.groups()
        if op=='invokestatic' and comment and 'Method nro/cX.a:([SIII)Ljava/lang/String;' in comment:
            if len(st)>=4 and st[-4]=='O' and all(isinstance(x,int) for x in st[-3:]):
                return st[-3],st[-2],st[-1]
            return None
        c=parse_const(op,arg,comment)
        if c is not None:
            st.append(j32(c)); continue
        if op in ('ixor','iand','ior','iadd','isub','imul','idiv','irem','ishl','ishr','iushr'):
            if len(st)<2 or not isinstance(st[-1],int) or not isinstance(st[-2],int): return None
            b=st.pop(); a=st.pop()
            try:
                if op=='ixor':v=a^b
                elif op=='iand':v=a&b
                elif op=='ior':v=a|b
                elif op=='iadd':v=a+b
                elif op=='isub':v=a-b
                elif op=='imul':v=a*b
                elif op=='idiv':v=int(a/b) # trunc toward zero
                elif op=='irem':v=a-int(a/b)*b
                elif op=='ishl':v=a << (b&31)
                elif op=='ishr':v=a >> (b&31)
                elif op=='iushr':v=(a & 0xffffffff) >> (b&31)
            except Exception:return None
            st.append(j32(v));continue
        if op=='ineg':
            if not st or not isinstance(st[-1],int):return None
            st[-1]=j32(-st[-1]);continue
        if op in ('i2b','i2c','i2s'):
            if not st or not isinstance(st[-1],int):return None
            v=st.pop()
            if op=='i2b': v=((v&0xff)-256 if (v&0x80) else (v&0xff))
            elif op=='i2s': v=((v&0xffff)-65536 if (v&0x8000) else (v&0xffff))
            else:v=v&0xffff
            st.append(j32(v)); continue
        if op=='dup':
            if not st:return None
            st.append(st[-1]);continue
        # all expected operations between O and call should be pure int construction.
        # Ignore nop/checkcast only; reject everything else.
        if op in ('nop',): continue
        return None
    return None

rows=[];fail=0;calls=0
for fn in sorted(os.listdir(WORK+'/javap_all')):
    if not fn.endswith('.txt'):continue
    cls=fn[:-4]
    path=WORK+'/javap_all/'+fn
    with open(path,encoding='utf-8',errors='replace') as f: lines=f.readlines()
    current_method=''
    for i,line in enumerate(lines):
        s=line.strip()
        if s and not re.match(r'^\d+:',s) and not s.startswith(('descriptor:','Code:','Exception','Compiled from')):
            # Method context. javap prints class initializers as `public static {};`.
            if ('(' in s and s.endswith(';')) or s == 'public static {};':
                current_method=s
        if 'Method nro/cX.a:([SIII)Ljava/lang/String;' in line and 'invokestatic' in line:
            calls+=1
            # nearest previous getstatic cX.o, bounded to 80 lines
            j=i-1
            while j>=max(0,i-120) and 'Field nro/cX.o:[S' not in lines[j]: j-=1
            if j<max(0,i-120):
                fail+=1;continue
            ev=eval_segment(lines[j:i+1])
            if not ev:
                fail+=1;continue
            off,n,key=ev
            text=decode(off,n,key)
            if text is None:
                fail+=1;continue
            pc_match=re.match(r'^\s*(\d+):',line)
            rows.append({'class':cls,'method':current_method,'pc':int(pc_match.group(1)) if pc_match else -1,'offset':off,'length':n,'key':key,'text':text})

with open(WORK+'/decoded_strings.csv','w',newline='',encoding='utf-8-sig') as f:
    w=csv.DictWriter(f,fieldnames=['class','method','pc','offset','length','key','text']);w.writeheader();w.writerows(rows)
with open(WORK+'/decoded_strings.txt','w',encoding='utf-8') as f:
    for r in rows:
        t=r['text'].replace('\n','\\n').replace('\r','\\r')
        f.write(f"{r['class']}\t{r['pc']}\t{r['method']}\t{r['offset']}\t{r['length']}\t{r['key']}\t{t}\n")
uniq=[];seen=set()
for r in rows:
    if r['text'] not in seen: seen.add(r['text']);uniq.append(r['text'])
with open(WORK+'/decoded_strings_unique.txt','w',encoding='utf-8') as f:
    for x in uniq:f.write(x.replace('\n','\\n').replace('\r','\\r')+'\n')
print(json.dumps({'calls':calls,'decoded':len(rows),'failed':fail,'unique':len(uniq)},ensure_ascii=False))
