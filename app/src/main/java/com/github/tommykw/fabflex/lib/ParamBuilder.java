package com.github.tommykw.fabflex.lib;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

/**
 * parameter builder interface
 */
public interface ParamBuilder {
    void add();
    FabFlex remove(@IntRange(from = 0) int index);
    void colorChanged(@ColorInt int color);
    void iconChanged(@NonNull Drawable drawable);
    void changedAt(@IntRange(from = 0) int index, @NonNull FabFlex fabFlex);
}
