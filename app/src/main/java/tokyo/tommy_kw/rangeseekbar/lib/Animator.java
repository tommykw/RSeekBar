package tokyo.tommy_kw.rangeseekbar.lib;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;

/**
 * This implementation of {@link RecyclerView} provides basic animations
 */
public class Animator extends DefaultItemAnimator {
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

    private void startAnimation(RecyclerView.ViewHolder holder) {}

    private void stopAnimation(RecyclerView.ViewHolder holder) {}
}
