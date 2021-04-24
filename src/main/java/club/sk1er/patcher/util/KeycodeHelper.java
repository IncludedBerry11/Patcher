/*
 * Copyright © 2020 by Sk1er LLC
 *
 * All rights reserved.
 *
 * Sk1er LLC
 * 444 S Fulton Ave
 * Mount Vernon, NY
 * sk1er.club
 */

package club.sk1er.patcher.util;

@SuppressWarnings("unused")
public class KeycodeHelper {
    public static final int lessThanKeycode = 0xE0; // 224 seems to be an unassigned keycode, this needs to be < 256 since WindowsKeyboard:146 would otherwise decline the keycode
    public static final String lessThanName = "Foreign key";

    public static int extraVirtualKeysWindows(int originalCode) {
        if (originalCode == 0xE2) return lessThanKeycode; // VK_OEM_102
        return originalCode;
    }

    public static String getKeyName(int key) {
        if (key == lessThanKeycode) return lessThanName;
        return null;
    }
}
