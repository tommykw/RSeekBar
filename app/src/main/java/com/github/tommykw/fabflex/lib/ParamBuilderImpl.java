package com.github.tommykw.fabflex.lib;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

/**
 * parameter builder class
 */
public class ParamBuilderImpl implements ParamBuilder, ItemAdapter.OnFabClickListener {

    @Override
    public void add() {

    }

    @Override
    public FabFlex remove(@IntRange(from = 0) int index) {
        return null;
    }

    @Override
    public void colorChanged(@ColorInt int color) {

    }

    @Override
    public void iconChanged(@NonNull Drawable drawable) {

    }

    @Override
    public void changedAt(@IntRange(from = 0) int index, @NonNull FabFlex fabFlex) {

    }

    @Override
    public void onClick(FabFlex fabFlex, int position) {

    }

    public interface OnClickListener {
        void onClick(int position);
    }



}
