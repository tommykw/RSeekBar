package com.github.tommykw.fabflex.lib;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * parameter builder class
 */
public class ParamBuilderImpl implements
        ParamBuilder,
        ItemAdapter.OnFabClickListener,
        FabFlexLayout.OnContainerClickListener {

    private final ItemAdapter itemAdapter;
    private final FabFlexContainer fabFlexContainer;
    private final List<FabFlex> fabFlexes;
    private final boolean onTapped;
    private boolean fabFlexesAdded = false;
    OnClickListener onClickListener;

    public ParamBuilderImpl(FabFlexLayout layout, boolean onTapped) {
        this.onTapped = onTapped;
        this.itemAdapter = null;
        this.fabFlexContainer = layout.getFabFlexContainer();
        fabFlexes = new ArrayList<>();
    }

    @Override
    public void add(@NonNull FabFlex fabFlex) {

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
        if (position == 0) {
            onClick();
        } else {
            onClickListener.onFabFlexClick(fabFlex, position - 1);
        }

    }

    @Override
    public void onClick() {

    }

    public void setOnClickListener(OnClickListener listener) {
        onClickListener = listener;
    }

    public interface OnClickListener {
        void onFabFlexClick(FabFlex fabFlex, int position);
        void onMainFabFlexClick();
    }
}
