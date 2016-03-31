package com.github.tommykw.fabflex.lib;

import android.support.annotation.ColorInt;

/**
 * fab-flex interface
 */
public interface FabFlex {
    void setColor(@ColorInt int color);
    @ColorInt int getColor();
}
