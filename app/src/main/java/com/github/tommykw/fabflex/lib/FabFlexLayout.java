package com.github.tommykw.fabflex.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;

import com.github.tommykw.fabflex.R;

/**
 * Created by tommy on 2016/04/09.
 */
public class FabFlexLayout extends CoordinatorLayout implements View.OnTouchListener {
    private FabFlexContainer fabFlexContainer;
    private FabFlexContainer.OnContextClickListener listener;

    public FabFlexLayout(Context context) {
        super(context);
    }

    public FabFlexLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.fabFlexLayout);
        final int color = ta.getColor(R.styleable.fabFlexLayout_fabFlexColor, fetchAccentColor(context));
        Drawable drawable = ta.getDrawable(R.styleable.fabFlexLayout_fabFlexIcon);
        if (drawable == null) {
            drawable = ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_check_box_outline
            );
        }
        ta.recycle();

        fabFlexContainer = (FabFlexContainer) LayoutInflater.from(context)
                .inflate(R.layout.fabflex_container, this, false);
        ItemAdapter adapter = new ItemAdapter(color, drawable);
        fabFlexContainer.setLayoutManager(
                new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
        );
        fabFlexContainer.setAdapter(adapter);
        fabFlexContainer.setItemAnimator(new ViewAnimator());
        fabFlexContainer.setOnTouchListener(this);
        addView(fabFlexContainer);
    }

    @Override
    public void addView(View child) {
        super.addView(child);
        if (getChildCount() != 1 && !(child instanceof Snackbar.SnackbarLayout)) addFabFlexOnTop();
    }

    @Override
    public void addView(View child, int index) {
        super.addView(child, index);
        if (getChildCount() != 1 && !(child instanceof Snackbar.SnackbarLayout)) addFabFlexOnTop();
    }

    private void addFabFlexOnTop() {
        detachViewFromParent(fabFlexContainer);
        attachViewToParent(fabFlexContainer, getChildCount(), fabFlexContainer.getLayoutParams());
    }

    public FabFlexContainer getFabFlexContainer() {
        return fabFlexContainer;
    }

    public interface OnContainerClickListener {
        void onClick();
    }

    public void setContainerClickListener(OnContextClickListener listener) {
        this.listener = listener;
    }

    private int fetchAccentColor(Context context) {
        TypedValue tv = new TypedValue();
        TypedArray ta = context.obtainStyledAttributes(tv.data, new int[] {R.attr.colorAccent});
        final int color = ta.getColor(0, 0);
        ta.recycle();
        return color;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        boolean tapped = true;
        //if (tapped) listener.onClick();
        return tapped;
    }
}
