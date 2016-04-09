package com.github.tommykw.fabflex.lib.view_holder;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.tommykw.fabflex.lib.FabFlex;
import com.github.tommykw.fabflex.lib.ItemAdapter;

import java.util.List;

/**
 * Created by tommy on 2016/04/09.
 */
public class TextViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView text;
    private FloatingActionButton fab;
    private ItemAdapter.OnFabClickListener clickListener;
    private List<FabFlex> fabFlexes;

    public TextViewHolder(View itemView,
                          ItemAdapter.OnFabClickListener listener,
                          List<FabFlex> fbs) {
        super(itemView);
        text = (TextView) itemView.findViewById(0);
        fab = (FloatingActionButton) itemView.findViewById(0);
        text.setOnClickListener(this);
        fab.setOnClickListener(this);
        clickListener = listener;
        fabFlexes = fbs;
    }

    @Override
    public void onClick(View v) {
        if (clickListener == null) return;
        clickListener.onClick(fabFlexes.get(getAdapterPosition()), getAdapterPosition());
    }
}
