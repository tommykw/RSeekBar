package com.github.tommykw.fabflex.lib;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;

/**
 * fab-flex interface
 */
public interface FabFlex {
    void setDrawable(Drawable drawable);
    void setColor(@ColorInt int color);
    void setFabKind(@FabSourceKind int fabKind);
    Drawable getDrawable();
    @ColorInt int getColor();
    @FabSourceKind int getFabKind();

}
