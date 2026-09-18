package nro;

/**
 * Bridge from the new horizontal menu back into the original v4.0
 * command dispatcher. This preserves existing feature behavior.
 */
public final class V4MenuDispatcher implements ModMenuHandler {

   private final N owner;

   public V4MenuDispatcher(N owner) {
      this.owner = owner;
   }

   public void onModMenuAction(String actionKey) {
      int commandId = V4MenuActionMap.getCommandId(actionKey);
      if (commandId >= 0) {
         this.owner.a(commandId, null);
      }
   }
}
