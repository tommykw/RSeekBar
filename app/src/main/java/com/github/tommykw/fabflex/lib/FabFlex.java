package com.github.tommykw.fabflex.lib;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;

/**
 * fab-flex interface
 */
public interface FabFlex {
    void setDrawable(Drawable drawable);
    void setColor(@ColorInt int color);
    Drawable getDrawable();
    @ColorInt int getColor();
}
