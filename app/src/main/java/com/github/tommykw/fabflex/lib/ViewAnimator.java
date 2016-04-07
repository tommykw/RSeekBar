package com.github.tommykw.fabflex.lib;

import android.animation.Animator;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;

import com.github.tommykw.fabflex.R;

/**
 * This implementation of {@link RecyclerView} provides basic animations
 */
public class ViewAnimator extends DefaultItemAnimator {
    @Override
    public boolean animateAdd(RecyclerView.ViewHolder holder) {
        dispatchAddFinished(holder);
        return false;
    }

    @Override
    public boolean animateRemove(RecyclerView.ViewHolder holder) {
        dispatchRemoveFinished(holder);
        return false;
    }

    private void startAnimation(final RecyclerView.ViewHolder holder) {
        holder.itemView.setTranslationY(
                holder.itemView.getContext().getResources().getDimensionPixelOffset(0)
        );

        holder.itemView.setAlpha(0);
        holder.itemView.
                animate().
                translationY(0).
                alpha(0).
                setInterpolator(null).
                setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
    }

    private void stopAnimation(final RecyclerView.ViewHolder holder) {}
}
