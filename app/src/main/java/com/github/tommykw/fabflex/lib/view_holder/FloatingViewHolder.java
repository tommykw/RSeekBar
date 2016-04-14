package com.github.tommykw.fabflex.lib.view_holder;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.tommykw.fabflex.lib.FabFlex;
import com.github.tommykw.fabflex.lib.ItemAdapter;

import java.util.List;

/**
 * Created by tommy on 2016/04/09.
 */
public abstract class FloatingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
    protected FloatingActionButton fab;
    protected ItemAdapter.OnFabClickListener clickListener;
    protected List<FabFlex> fabFlexes;

    public FloatingViewHolder(View itemView,
                              ItemAdapter.OnFabClickListener listener,
                              List<FabFlex> fbs) {
        super(itemView);
        fab = (FloatingActionButton) itemView.findViewById(0);
        fab.setOnClickListener(this);
        clickListener = listener;
        fabFlexes = fbs;
    }

    @Override
    public void onClick(View v) {
        if (clickListener == null) return;
        clickListener.onClick(fabFlexes.get(0), 0);
    }
}
