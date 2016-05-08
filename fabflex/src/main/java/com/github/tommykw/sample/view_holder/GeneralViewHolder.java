package com.github.tommykw.sample.view_holder;

import android.view.View;

import com.github.tommykw.sample.FabFlex;
import com.github.tommykw.sample.ItemAdapter;

import java.util.List;

/**
 * Created by tommy on 2016/04/09.
 */
public class GeneralViewHolder extends FloatingViewHolder implements View.OnClickListener {
    public GeneralViewHolder(View itemView,
                              ItemAdapter.OnFabClickListener listener,
                              List<FabFlex> fbs) {
        super(itemView, listener, fbs);
        itemView.findViewById(0).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (clickListener == null) return;
        clickListener.onClick(fabFlexes.get(0), 0);
    }
}
