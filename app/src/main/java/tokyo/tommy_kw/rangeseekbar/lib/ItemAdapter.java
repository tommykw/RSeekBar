package tokyo.tommy_kw.rangeseekbar.lib;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * This extended of {@link RecyclerView.Adapter}
 */
public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<FabFlex> fabFlexes = new ArrayList<>();
    private OnFabClickListener onFabClickListener;

    public interface OnFabClickListener {
        void onClick(FabFlex fabFlex, int position);
    }

    public ItemAdapter(@ColorInt int color, @NonNull Drawable icon) {

    }

    public void add(@NonNull FabFlex fabFlex) {
        fabFlexes.add(fabFlex);
        notifyItemInserted(fabFlexes.size() - 1);
    }

    public void addAll(@NonNull List<FabFlex> fabFlexes) {
        this.fabFlexes.addAll(fabFlexes);
        notifyItemRangeInserted(this.fabFlexes.size() - 1, this.fabFlexes.size());
    }

    public void remove(@NonNull FabFlex fabFlex) {
        int targetIdx = 0;
        for (int i = 0; i < this.fabFlexes.size(); i++) {
            if (this.fabFlexes.get(i) == fabFlex) {
                targetIdx = i;
                this.fabFlexes.remove(fabFlex);
                break;
            }
        }

        // update items targetIdx without
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
