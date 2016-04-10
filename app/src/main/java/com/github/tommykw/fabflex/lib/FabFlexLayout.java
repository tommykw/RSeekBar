package com.github.tommykw.fabflex.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by tommy on 2016/04/09.
 */
public class FabFlexLayout extends CoordinatorLayout implements View.OnTouchListener {
    private FabFlexContainer fabFlexContainer;
    private ItemAdapter.OnFabClickListener listener;

    public FabFlexLayout(Context context) {
        super(context);
    }

    public FabFlexLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FabFlexLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public FabFlexContainer getFabFlexContainer() {
        return fabFlexContainer;
    }

    public interface OnContainerClickListener {
        void onClick();
    }



    @Override
    public boolean onTouch(View v, MotionEvent event) {
        boolean tapped = true;
        //if (tapped) listener.onClick();
        return tapped;
    }
}
