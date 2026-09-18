package nro;

import main.GameCanvas;

/**
 * Horizontal, scrollable grouped menu for Dragonboy250 v4.0.
 *
 * Design goals:
 * - top category bar scrolls left/right;
 * - selected category opens a 2-column action grid;
 * - works with keypad and pointer/touch;
 * - no collections/generics so it stays friendly to old J2ME toolchains.
 */
public final class HorizontalModMenu {

   private static final int COLOR_TAB = 0xE9B83F;
   private static final int COLOR_TAB_FOCUS = 0xFFF2A8;
   private static final int COLOR_TAB_BORDER = 0x77510A;
   private static final int COLOR_PANEL = 0xE5D3B5;
   private static final int COLOR_CELL = 0xF2E4CC;
   private static final int COLOR_CELL_FOCUS = 0xFFF4B8;
   private static final int COLOR_CELL_BORDER = 0x8A6B3E;

   private final ModMenuHandler handler;
   private final String[] groups;
   private final String[][] items;
   private final String[][] actionKeys;

   private int x;
   private int y;
   private int width;
   private int tabHeight = 30;
   private int cellHeight = 28;
   private int minTabWidth = 78;
   private int padding = 10;

   private int selectedGroup;
   private int selectedItem;
   private int tabScrollX;
   private int itemScrollRow;
   private boolean visible;

   public HorizontalModMenu(ModMenuHandler handler) {
      this(handler, ModMenuCatalog.GROUP_TITLES, ModMenuCatalog.ITEM_TITLES, ModMenuCatalog.ACTION_KEYS);
   }

   public HorizontalModMenu(ModMenuHandler handler, String[] groups, String[][] items, String[][] actionKeys) {
      this.handler = handler;
      this.groups = groups;
      this.items = items;
      this.actionKeys = actionKeys;
      this.width = GameCanvas.z;
   }

   public void setBounds(int x, int y, int width) {
      this.x = x;
      this.y = y;
      this.width = width;
      this.ensureSelectedGroupVisible();
      this.ensureSelectedItemVisible();
   }

   public void show() {
      this.visible = true;
      this.ensureSelectedGroupVisible();
      this.ensureSelectedItemVisible();
   }

   public void hide() {
      this.visible = false;
   }

   public boolean isVisible() {
      return this.visible;
   }

   public int getSelectedGroup() {
      return this.selectedGroup;
   }

   public int getSelectedItem() {
      return this.selectedItem;
   }

   public void paint(mGraphics g) {
      if (!this.visible) {
         return;
      }

      int oldX = g.setColor();
      int oldY = g.b();
      int oldClipX = g.drawRect();
      int oldClipY = g.fillRect();
      int oldClipW = g.e();
      int oldClipH = g.f();

      this.paintTabs(g);
      this.paintGrid(g);

      g.e(oldClipX, oldClipY, oldClipW, oldClipH);
      g.setColor(oldX - g.setColor(), oldY - g.b());
   }

   private void paintTabs(mGraphics g) {
      g.e(this.x, this.y, this.width, this.tabHeight);

      int drawX = this.x - this.tabScrollX;
      int i;
      for (i = 0; i < this.groups.length; ++i) {
         int tabWidth = this.getTabWidth(i);
         boolean focus = i == this.selectedGroup;

         g.setColor(focus ? COLOR_TAB_FOCUS : COLOR_TAB);
         g.fillRect(drawX, this.y, tabWidth, this.tabHeight - 1);
         g.setColor(COLOR_TAB_BORDER);
         g.drawRect(drawX, this.y, tabWidth - 1, this.tabHeight - 2);

         mFont.tahoma_7b_dark.drawStringBd(
            g,
            this.groups[i],
            drawX + tabWidth / 2,
            this.y + (this.tabHeight - mFont.tahoma_7b_dark.getWidth()) / 2 - 1,
            2
         );

         drawX += tabWidth;
      }
   }

   private void paintGrid(mGraphics g) {
      String[] current = this.items[this.selectedGroup];
      int gridY = this.y + this.tabHeight;
      int maxHeight = GameCanvas.A - gridY - 4;
      if (maxHeight < this.cellHeight) {
         return;
      }

      int visibleRows = maxHeight / this.cellHeight;
      int totalRows = (current.length + 1) / 2;
      if (visibleRows > totalRows) {
         visibleRows = totalRows;
      }

      int gridHeight = visibleRows * this.cellHeight;
      int cellWidth = this.width / 2;

      g.e(this.x, gridY, this.width, gridHeight);
      g.setColor(COLOR_PANEL);
      g.fillRect(this.x, gridY, this.width, gridHeight);

      int start = this.itemScrollRow * 2;
      int end = start + visibleRows * 2;
      if (end > current.length) {
         end = current.length;
      }

      int i;
      for (i = start; i < end; ++i) {
         int local = i - start;
         int col = local & 1;
         int row = local >> 1;
         int cellX = this.x + col * cellWidth;
         int cellY = gridY + row * this.cellHeight;
         boolean focus = i == this.selectedItem;

         g.setColor(focus ? COLOR_CELL_FOCUS : COLOR_CELL);
         g.fillRect(cellX, cellY, cellWidth, this.cellHeight);
         g.setColor(COLOR_CELL_BORDER);
         g.drawRect(cellX, cellY, cellWidth - 1, this.cellHeight - 1);

         mFont.tahoma_7b_dark.drawStringBd(
            g,
            current[i],
            cellX + cellWidth / 2,
            cellY + (this.cellHeight - mFont.tahoma_7b_dark.getWidth()) / 2 - 1,
            2
         );
      }
   }

   public void updateKey() {
      if (!this.visible) {
         return;
      }

      if (GameCanvas.keyPressed[4]) {
         GameCanvas.keyPressed[4] = false;
         this.moveGroup(-1);
         return;
      }

      if (GameCanvas.keyPressed[6]) {
         GameCanvas.keyPressed[6] = false;
         this.moveGroup(1);
         return;
      }

      if (GameCanvas.keyPressed[2]) {
         GameCanvas.keyPressed[2] = false;
         this.moveItem(-2);
         return;
      }

      if (GameCanvas.keyPressed[8]) {
         GameCanvas.keyPressed[8] = false;
         this.moveItem(2);
         return;
      }

      if (GameCanvas.keyPressed[5]) {
         GameCanvas.keyPressed[5] = false;
         this.activateSelected();
         return;
      }

      this.updatePointer();
   }

   private void updatePointer() {
      if (!GameCanvas.isTouch) {
         return;
      }

      int pointerX = GameCanvas.s;
      int pointerY = GameCanvas.t;

      if (pointerY >= this.y && pointerY < this.y + this.tabHeight) {
         int drawX = this.x - this.tabScrollX;
         int i;
         for (i = 0; i < this.groups.length; ++i) {
            int tabWidth = this.getTabWidth(i);
            if (pointerX >= drawX && pointerX < drawX + tabWidth) {
               if (GameCanvas.l && GameCanvas.m) {
                  this.selectedGroup = i;
                  this.selectedItem = 0;
                  this.itemScrollRow = 0;
                  this.ensureSelectedGroupVisible();
                  GameCanvas.m = false;
                  GameCanvas.l = false;
               }
               return;
            }
            drawX += tabWidth;
         }
      }

      int gridY = this.y + this.tabHeight;
      if (pointerY < gridY || pointerX < this.x || pointerX >= this.x + this.width) {
         return;
      }

      int maxHeight = GameCanvas.A - gridY - 4;
      int visibleRows = maxHeight / this.cellHeight;
      if (visibleRows <= 0) {
         return;
      }

      int row = (pointerY - gridY) / this.cellHeight;
      if (row >= visibleRows) {
         return;
      }

      int col = pointerX < this.x + this.width / 2 ? 0 : 1;
      int item = this.itemScrollRow * 2 + row * 2 + col;
      if (item >= this.items[this.selectedGroup].length) {
         return;
      }

      this.selectedItem = item;
      if (GameCanvas.l && GameCanvas.m) {
         this.activateSelected();
         GameCanvas.m = false;
         GameCanvas.l = false;
      }
   }

   private void moveGroup(int delta) {
      int next = this.selectedGroup + delta;
      if (next < 0) {
         next = this.groups.length - 1;
      } else if (next >= this.groups.length) {
         next = 0;
      }

      this.selectedGroup = next;
      this.selectedItem = 0;
      this.itemScrollRow = 0;
      this.ensureSelectedGroupVisible();
   }

   private void moveItem(int delta) {
      int count = this.items[this.selectedGroup].length;
      if (count == 0) {
         return;
      }

      int next = this.selectedItem + delta;
      if (next < 0) {
         next = this.selectedItem & 1;
         if (next >= count) {
            next = 0;
         }
      } else if (next >= count) {
         next = count - 1;
      }

      this.selectedItem = next;
      this.ensureSelectedItemVisible();
   }

   public void moveItemHorizontal(int delta) {
      int count = this.items[this.selectedGroup].length;
      int next = this.selectedItem + delta;
      if (next >= 0 && next < count) {
         this.selectedItem = next;
         this.ensureSelectedItemVisible();
      }
   }

   private void activateSelected() {
      if (this.handler == null) {
         return;
      }

      String[] keys = this.actionKeys[this.selectedGroup];
      if (this.selectedItem < 0 || this.selectedItem >= keys.length) {
         return;
      }

      this.handler.onModMenuAction(keys[this.selectedItem]);
   }

   private int getTabWidth(int index) {
      int textWidth = mFont.tahoma_7b_dark.getWidth(this.groups[index]) + this.padding * 2;
      return textWidth < this.minTabWidth ? this.minTabWidth : textWidth;
   }

   private void ensureSelectedGroupVisible() {
      int left = 0;
      int i;
      for (i = 0; i < this.selectedGroup; ++i) {
         left += this.getTabWidth(i);
      }

      int right = left + this.getTabWidth(this.selectedGroup);
      if (left < this.tabScrollX) {
         this.tabScrollX = left;
      } else if (right > this.tabScrollX + this.width) {
         this.tabScrollX = right - this.width;
      }

      if (this.tabScrollX < 0) {
         this.tabScrollX = 0;
      }
   }

   private void ensureSelectedItemVisible() {
      int gridY = this.y + this.tabHeight;
      int visibleRows = (GameCanvas.A - gridY - 4) / this.cellHeight;
      if (visibleRows <= 0) {
         this.itemScrollRow = 0;
         return;
      }

      int row = this.selectedItem / 2;
      if (row < this.itemScrollRow) {
         this.itemScrollRow = row;
      } else if (row >= this.itemScrollRow + visibleRows) {
         this.itemScrollRow = row - visibleRows + 1;
      }

      if (this.itemScrollRow < 0) {
         this.itemScrollRow = 0;
      }
   }
}
