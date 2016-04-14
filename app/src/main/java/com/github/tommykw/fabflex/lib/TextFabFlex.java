package com.github.tommykw.fabflex.lib;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;

/**
 * FabFlex class for text
 */
public class TextFabFlex implements FabFlex {
    private String text;
    private @ColorInt int color;
    private Drawable icon;
    private @ColorInt int textBackground;
    private @ColorInt int textColor;

    private TextFabFlex(String text,
                        int color,
                        Drawable drawable,
                        int textBackground) {
        this.text = text;
        this.color = color;
        this.icon = drawable;
        this.textBackground = textBackground;
        this.textColor = textColor;
    }

    @Override
    public void setDrawable(Drawable drawable) {

    }

    @Override
    public void setColor(@ColorInt int color) {

    }

    @Override
    public void setFabKind(@FabSourceKind int fabKind) {

    }

    @Override
    public Drawable getDrawable() {
        return null;
    }

    @Override
    public int getColor() {
        return 0;
    }

    @Override
    public int getFabKind() {
        return FabActionType.CIRCLE;
    }
}
