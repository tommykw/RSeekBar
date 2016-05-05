package com.github.tommykw.fabflex;

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

    public static ParamBuilderImpl newInstance(
            FabFlexLayout layout,
            boolean onTapped) {
        return new ParamBuilderImpl(layout, onTapped);
    }

    public ParamBuilderImpl(FabFlexLayout layout, boolean onTapped) {
        this.onTapped = onTapped;
        this.itemAdapter = layout.getItemAdapter();
        this.itemAdapter.setFabFlexClickListener(this);
        this.fabFlexContainer = layout.getFabFlexContainer();
        layout.setContainerClickListener(this);
        fabFlexes = new ArrayList<>();
    }

    @Override
    public void add(@NonNull FabFlex fabFlex) {
        fabFlexes.add(fabFlex);
    }

    @Override
    public FabFlex remove(@IntRange(from = 0) int index) {
        return itemAdapter.remove(index + 1);
    }

    @Override
    public void colorChanged(@ColorInt int color) {
        itemAdapter.changeColor(color);
    }

    @Override
    public void iconChanged(@NonNull Drawable drawable) {
        itemAdapter.changeIcon(drawable);
    }

    @Override
    public void changedAt(@IntRange(from = 0) int index, @NonNull FabFlex fabFlex) {
        itemAdapter.changeAt(index + 1, fabFlex);
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
        if (fabFlexesAdded) onMainFabFlexClick();
    }

    private void onMainFabFlexClick() {
        if (!fabFlexesAdded) {
            itemAdapter.addAll(fabFlexes);
        } else {
            itemAdapter.removeAll(fabFlexes);
        }
        fabFlexesAdded = !fabFlexesAdded;
        fabFlexContainer.setFabFlexesAdded(onTapped && fabFlexesAdded);
        if (onClickListener != null) onClickListener.onMainFabFlexClick();
    }

    public void setOnClickListener(OnClickListener listener) {
        onClickListener = listener;
    }

    public interface OnClickListener {
        void onFabFlexClick(FabFlex fabFlex, int position);
        void onMainFabFlexClick();
    }
}
