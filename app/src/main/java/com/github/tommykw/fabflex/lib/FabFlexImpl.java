package com.github.tommykw.fabflex.lib;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;

import com.github.tommykw.fabflex.lib.FabFlex;

/**
 * fab-flex implement class
 */
public class FabFlexImpl implements FabFlex {
    private @ColorInt int color;
    private Drawable drawable;

    public FabFlexImpl(@ColorInt int color, Drawable drawable) {
        this.color = color;
        this.drawable = drawable;
    }

    @Override
    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    @Override
    public void setColor(@ColorInt int color) {
        this.color = color;
    }

    @Override
    public Drawable getDrawable() {
        return drawable;
    }

    @Override
    public int getColor() {
        return color;
    }
}
