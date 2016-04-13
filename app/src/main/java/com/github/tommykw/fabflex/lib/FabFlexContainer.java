package com.github.tommykw.fabflex.lib;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.github.tommykw.fabflex.lib.view_holder.FloatingViewHolder;

import java.util.List;

/**
 * Created by tommy on 2016/04/09.
 */
@CoordinatorLayout.DefaultBehavior(FabFlexContainer.FloatingLayoutBehavior.class)
public class FabFlexContainer extends RecyclerView implements GestureDetector.OnGestureListener {
    private GestureDetectorCompat gestureDetector;
    private boolean isAdded = false;

    public FabFlexContainer(Context context) {
        super(context);
    }

    public FabFlexContainer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FabFlexContainer(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        gestureDetector =new GestureDetectorCompat(context, this);
    }

    public void setFabFlexesAdded(boolean added) {
        isAdded = added;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return isAdded;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    public final static class FloatingLayoutBehavior
            extends  CoordinatorLayout.Behavior<FabFlexContainer> {
        private static final boolean SNACKBAR_ENABLED;
        private float translationY;
        private boolean isAnimation;

        static {
            SNACKBAR_ENABLED = Build.VERSION.SDK_INT >= 11;
        }

        public FloatingLayoutBehavior() {}

        public FloatingLayoutBehavior(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        @Override
        public boolean layoutDependsOn(CoordinatorLayout parent,
                                       FabFlexContainer child,
                                       View dependency) {
            return dependency instanceof Snackbar.SnackbarLayout;
        }

        @Override
        public boolean onDependentViewChanged(CoordinatorLayout parent,
                                              FabFlexContainer child,
                                              View dependency) {
            if (dependency instanceof Snackbar.SnackbarLayout) {
                updateFabTranslationForSnackBar(parent, child, dependency);
            }
            return true;
        }

        private void updateFabTranslationForSnackBar(CoordinatorLayout parent,
                                                     FabFlexContainer child,
                                                     View dependency) {
            float y = translationYForSnackBar(parent, child);
            if (y == -dependency.getHeight()) {
                ViewCompat.animate(child)
                        .translationY(-y)
                        .setInterpolator(new FastOutLinearInInterpolator())
                        .setListener(null);
            } else if (y != translationY) {
                ViewCompat.animate(child).cancel();
                if (Math.abs(y - translationY) == (float) dependency.getHeight()) {
                    ViewCompat.animate(child)
                            .translationY(y)
                            .setInterpolator(new FastOutLinearInInterpolator())
                            .setListener(null);
                } else {
                    ViewCompat.setTranslationY(child, y);
                }
                translationY = y;
            }
        }

        private float translationYForSnackBar(CoordinatorLayout parent,
                                             FabFlexContainer container) {
            float minOffset = 0.0F;
            List dependencies = parent.getDependencies(container);

            for (int i = 0; i < dependencies.size(); i++) {
                View view = (View) dependencies.get(i);
                if (view instanceof Snackbar.SnackbarLayout
                        && parent.doViewsOverlap(container, view)) {
                    minOffset = Math.min(minOffset,
                            ViewCompat.getTranslationY(view) - (float)view.getHeight()
                    );
                }
            }

            return minOffset;
        }
    }
}
