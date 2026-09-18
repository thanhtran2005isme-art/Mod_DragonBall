package nro;

/**
 * Callback used by the reconstructed horizontal mod menu.
 * Kept deliberately tiny for CLDC/J2ME compatibility.
 */
public interface ModMenuHandler {
   void onModMenuAction(String actionKey);
}
