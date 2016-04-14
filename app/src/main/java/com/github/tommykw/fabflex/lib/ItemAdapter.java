package com.github.tommykw.fabflex.lib;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.tommykw.fabflex.R;
import com.github.tommykw.fabflex.lib.view_holder.FloatingViewHolder;
import com.github.tommykw.fabflex.lib.view_holder.GeneralViewHolder;

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

    public void setFabFlexClickListener(OnFabClickListener listener) {
        onFabClickListener = listener;
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
        switch (viewType) {
            case FabActionType.CIRCLE:
                return new GeneralViewHolder(getInflatedView(0, parent), onFabClickListener, fabFlexes);
            case FabActionType.DOUBLE_CIRCLE:
                return new GeneralViewHolder(getInflatedView(0, parent), onFabClickListener, fabFlexes);
            case FabActionType.HORIZONTAL:
                return new GeneralViewHolder(getInflatedView(0, parent), onFabClickListener, fabFlexes);
            case FabActionType.VERTICAL:
                return new GeneralViewHolder(getInflatedView(0, parent), onFabClickListener, fabFlexes);
            case FabActionType.HORIZONTAL_AND_VERTICAL:
                return new GeneralViewHolder(getInflatedView(0, parent), onFabClickListener, fabFlexes);
            default:
                return new GeneralViewHolder(getInflatedView(0, parent), onFabClickListener, fabFlexes);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FloatingViewHolder) {
            bindViewHolder(holder, position);
        }
    }

    @Override
    public int getItemCount() {
        return fabFlexes.size();
    }

    private View getInflatedView(@LayoutRes int id, ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(id, parent, false);
    }

    private void bindViewHolder(FloatingViewHolder holder, int position) {
        FabFlex fb = (FabFlex) fabFlexes.get(position);
        // TODO setup view
    }
}
