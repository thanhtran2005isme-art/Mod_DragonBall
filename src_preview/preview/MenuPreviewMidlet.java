package preview;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.midlet.MIDlet;

/**
 * Standalone J2ME preview for the new Dragonboy250 horizontal grouped menu.
 *
 * This is intentionally independent from the obfuscated game classes so the
 * layout can be tested immediately while the real v4.0 bytecode hook is being
 * reconstructed.
 */
public final class MenuPreviewMidlet extends MIDlet {

   private MenuCanvas canvas;

   protected void startApp() {
      if (this.canvas == null) {
         this.canvas = new MenuCanvas();
      }
      Display.getDisplay(this).setCurrent(this.canvas);
   }

   protected void pauseApp() {
   }

   protected void destroyApp(boolean unconditional) {
   }

   private static final class MenuCanvas extends Canvas {

      private static final String[] GROUPS = new String[] {
         "Tàn Sát",
         "Auto Skill",
         "Nhặt Đồ",
         "Xmap",
         "Boss",
         "TĐLT / NV",
         "Đậu",
         "Hỗ Trợ",
         "Vật Phẩm",
         "Hiển Thị",
         "Cài Đặt"
      };

      private static final String[][] ITEMS = new String[][] {
         {
            "Bật/Tắt Tàn Sát",
            "Chọn quái / vị trí",
            "KC Tàn Sát",
            "Né siêu quái",
            "Đổi khu khi hết quái",
            "Đổi khu khi lag"
         },
         {
            "Bật/Tắt Auto Skill",
            "Thêm Skill",
            "Xóa Skill",
            "Danh sách Skill"
         },
         {
            "Auto Nhặt",
            "KC Nhặt",
            "Thêm Item",
            "Xóa Item",
            "Danh sách Item",
            "Lọc Đồ",
            "ItemConfig"
         },
         {
            "Bật/Dừng Xmap",
            "Chọn Bản Đồ",
            "Chọn Hành Tinh",
            "Delay Xmap",
            "Xmap tới Boss",
            "Auto vào khu"
         },
         {
            "Săn Boss",
            "Attack Boss",
            "Focus Boss",
            "Né Boss",
            "Paint Boss",
            "Cài Attack Boss"
         },
         {
            "Auto TDLT",
            "Cài TDLT",
            "Auto Nhiệm Vụ"
         },
         {
            "Xin Đậu",
            "Cho Đậu",
            "Thu Đậu",
            "Buff Đậu Sư Phụ",
            "Buff Đậu Đệ Tử",
            "Delay Buff Đậu"
         },
         {
            "Auto Login",
            "Delay Login",
            "Auto On-Off",
            "Auto Chat",
            "Auto Kaioken",
            "Auto Hồi Sinh",
            "Auto HS Namek"
         },
         {
            "Cuồng Nộ",
            "Bổ Huyết",
            "Bổ Khí",
            "Giáp Xên",
            "Ẩn Danh",
            "Khẩu Trang",
            "Máy Dò",
            "Capsule"
         },
         {
            "Ẩn Người",
            "Ẩn Quái",
            "Ẩn Item",
            "Xóa Hiệu Ứng",
            "Ảnh Nền",
            "Thông Tin Boss"
         },
         {
            "Setup AutoPlay",
            "Setup Auto Skill",
            "Setup Filter Item",
            "Setup Attack Boss",
            "Setup Xmap",
            "Tùy Chỉnh"
         }
      };

      private final Font font = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL);
      private final Font small = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL);

      private int group;
      private int item;
      private int tabScroll;
      private boolean gridFocus;

      protected void paint(Graphics g) {
         int w = this.getWidth();
         int h = this.getHeight();

         g.setColor(0x139CCC);
         g.fillRect(0, 0, w, h);

         this.paintTabs(g, w);
         this.paintGrid(g, w, h);

         g.setFont(this.small);
         g.setColor(0xFFFFFF);
         g.drawString("← → đổi nhóm   ↓ vào nhóm   OK chọn", 3, h - 3, Graphics.LEFT | Graphics.BOTTOM);
      }

      private void paintTabs(Graphics g, int width) {
         int tabY = 4;
         int tabH = 38;
         int x = 4 - this.tabScroll;

         g.setClip(0, 0, width, tabY + tabH + 1);

         for (int i = 0; i < GROUPS.length; ++i) {
            int tw = this.tabWidth(GROUPS[i]);
            boolean selected = i == this.group;

            g.setColor(selected ? 0xFFF1A6 : 0xF3C94F);
            g.fillRect(x, tabY, tw, tabH);

            g.setColor(0x73500D);
            g.drawRect(x, tabY, tw - 1, tabH - 1);

            if (selected) {
               g.setColor(0xFFFFFF);
               g.drawRect(x + 2, tabY + 2, tw - 5, tabH - 5);
            }

            g.setFont(this.font);
            g.setColor(0x3B2607);
            g.drawString(GROUPS[i], x + tw / 2, tabY + tabH / 2, Graphics.HCENTER | Graphics.BASELINE);

            x += tw + 3;
         }

         g.setClip(0, 0, this.getWidth(), this.getHeight());
      }

      private void paintGrid(Graphics g, int width, int height) {
         String[] values = ITEMS[this.group];
         int y0 = 48;
         int bottom = height - 20;
         int cellH = 32;
         int gap = 3;
         int cellW = (width - 11) / 2;

         g.setColor(0xE3D1B3);
         g.fillRect(3, y0, width - 6, bottom - y0);

         for (int i = 0; i < values.length; ++i) {
            int row = i / 2;
            int col = i & 1;
            int x = 5 + col * (cellW + gap);
            int y = y0 + 4 + row * (cellH + gap);

            if (y + cellH > bottom) {
               break;
            }

            boolean selected = this.gridFocus && i == this.item;
            g.setColor(selected ? 0xFFF5B5 : 0xF4E6CE);
            g.fillRect(x, y, cellW, cellH);

            g.setColor(0x8A6B3E);
            g.drawRect(x, y, cellW - 1, cellH - 1);

            g.setFont(this.small);
            g.setColor(0x402B0C);
            this.drawCenteredClipped(g, values[i], x + 3, y, cellW - 6, cellH);
         }
      }

      private void drawCenteredClipped(Graphics g, String text, int x, int y, int width, int height) {
         String draw = text;
         while (draw.length() > 1 && this.small.stringWidth(draw) > width) {
            draw = draw.substring(0, draw.length() - 2) + ".";
         }

         int oldX = g.getClipX();
         int oldY = g.getClipY();
         int oldW = g.getClipWidth();
         int oldH = g.getClipHeight();

         g.setClip(x, y, width, height);
         g.drawString(draw, x + width / 2, y + height / 2 + 4, Graphics.HCENTER | Graphics.BASELINE);
         g.setClip(oldX, oldY, oldW, oldH);
      }

      protected void keyPressed(int keyCode) {
         int action = this.getGameAction(keyCode);

         if (!this.gridFocus) {
            if (action == Canvas.LEFT) {
               this.changeGroup(-1);
            } else if (action == Canvas.RIGHT) {
               this.changeGroup(1);
            } else if (action == Canvas.DOWN || action == Canvas.FIRE) {
               this.gridFocus = true;
               this.item = 0;
            }
         } else {
            if (action == Canvas.UP) {
               if (this.item < 2) {
                  this.gridFocus = false;
               } else {
                  this.item -= 2;
               }
            } else if (action == Canvas.DOWN) {
               if (this.item + 2 < ITEMS[this.group].length) {
                  this.item += 2;
               }
            } else if (action == Canvas.LEFT) {
               if ((this.item & 1) == 1) {
                  --this.item;
               }
            } else if (action == Canvas.RIGHT) {
               if ((this.item & 1) == 0 && this.item + 1 < ITEMS[this.group].length) {
                  ++this.item;
               }
            } else if (action == Canvas.FIRE) {
               // Preview only: flash selection by repainting. Real build dispatches
               // to the existing N.a(int,Object) handler.
            }
         }

         this.ensureTabVisible();
         this.repaint();
      }

      protected void pointerPressed(int x, int y) {
         if (y >= 4 && y <= 42) {
            int pos = 4 - this.tabScroll;
            for (int i = 0; i < GROUPS.length; ++i) {
               int tw = this.tabWidth(GROUPS[i]);
               if (x >= pos && x < pos + tw) {
                  this.group = i;
                  this.item = 0;
                  this.gridFocus = false;
                  this.ensureTabVisible();
                  this.repaint();
                  return;
               }
               pos += tw + 3;
            }
         }

         if (y >= 52) {
            int cellH = 32;
            int gap = 3;
            int cellW = (this.getWidth() - 11) / 2;
            int row = (y - 52) / (cellH + gap);
            int col = x < 5 + cellW ? 0 : 1;
            int index = row * 2 + col;
            if (index >= 0 && index < ITEMS[this.group].length) {
               this.gridFocus = true;
               this.item = index;
               this.repaint();
            }
         }
      }

      private void changeGroup(int delta) {
         this.group += delta;
         if (this.group < 0) {
            this.group = GROUPS.length - 1;
         } else if (this.group >= GROUPS.length) {
            this.group = 0;
         }

         this.item = 0;
         this.gridFocus = false;
      }

      private int tabWidth(String value) {
         int w = this.font.stringWidth(value) + 22;
         return w < 82 ? 82 : w;
      }

      private void ensureTabVisible() {
         int left = 4;
         for (int i = 0; i < this.group; ++i) {
            left += this.tabWidth(GROUPS[i]) + 3;
         }

         int right = left + this.tabWidth(GROUPS[this.group]);
         int screenW = this.getWidth();

         if (left < this.tabScroll + 4) {
            this.tabScroll = left - 4;
         } else if (right > this.tabScroll + screenW - 4) {
            this.tabScroll = right - screenW + 4;
         }

         if (this.tabScroll < 0) {
            this.tabScroll = 0;
         }
      }
   }
}
