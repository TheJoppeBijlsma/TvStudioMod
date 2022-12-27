/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package io.github.joppebijlsma.tvstudio.util;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Util;

public final class Colors {
    public static final int GENERIC_DEFAULT_COLOR = 0xFFFFFF;
    public static final int TV_STUDIO_BLOCK_DEFAULT_COLOR = 0x4F4E6D;

    public static final Object2IntMap<DyeColor> DYE_COLOR_RGB_VALUES = Util.make(new Object2IntOpenHashMap<>(), map -> {
        for (DyeColor color : DyeColor.values()) {
            map.put(color, toIntRgb(color.getColorComponents()));
        }
    });

    public static int toIntRgb(float[] rgb) {
        int r = (int) (rgb[0] * 255f);
        int g = (int) (rgb[1] * 255f);
        int b = (int) (rgb[2] * 255f);
        return (r << 16) | (g << 8) | b;
    }
}
