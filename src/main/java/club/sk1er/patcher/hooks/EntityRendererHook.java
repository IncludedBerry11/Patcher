package club.sk1er.patcher.hooks;

import club.sk1er.patcher.config.PatcherConfig;
import net.minecraft.client.Minecraft;

public class EntityRendererHook {
    private static final Minecraft mc = Minecraft.getMinecraft();
    private static boolean zoomToggled = false;
    private static boolean isBeingHeld = false;
    private static float oldSensitivity;

    public static void fixMissingChunks() {
        mc.renderGlobal.setDisplayListEntitiesDirty();
    }

    public static boolean getZoomState(boolean zoomKeyDown) {
        if (zoomKeyDown) {
            if (isBeingHeld) return zoomToggled;
            isBeingHeld = true;
            zoomToggled = !zoomToggled;
        } else {
            isBeingHeld = false;
        }
        return zoomToggled;
    }

    public static void reduceSensitivity() {
        oldSensitivity = mc.gameSettings.mouseSensitivity;
        mc.gameSettings.mouseSensitivity = oldSensitivity / 100 * PatcherConfig.customZoomSensitivity;
    }

    public static void resetSensitivity() {
        mc.gameSettings.mouseSensitivity = oldSensitivity;
    }
}