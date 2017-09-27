package com.levup.mylibrary;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

/**
 * Created by Kapusta on 10.09.2017.
 */

public class ResViewAdapter extends  RecyclerView.Adapter<ResViewAdapter.ElementViewHolder> {

    public static class ElementViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView tv_name;
        TextView tv_number;
        ImageView iv_symbol;

        ElementViewHolder(View itemView) {
            super(itemView);
            cv =  itemView.findViewById(R.id.cv);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_number = itemView.findViewById(R.id.tv_number);
            iv_symbol = itemView.findViewById(R.id.iv_symbol);
        }
    }

    List<ElementImpl> elementImpls;
    ItemListener listener;

    ResViewAdapter(List<ElementImpl> elementImpls, ItemListener listener){
        this.elementImpls = elementImpls;
        this.listener = listener;
    }

    public List<ElementImpl> getElementImpls() {
        return elementImpls;
    }

    @Override
    public ElementViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        ElementViewHolder pvh = new ElementViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ElementViewHolder holder, final int position) {
        holder.tv_name.setText(elementImpls.get(position).getName());
        holder.tv_number.setText("" + elementImpls.get(position).getInfo());
       // holder.iv_symbol.setImageResource(R.drawable.atom);
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.getElement(elementImpls.get(position));
            }
        });
    }

    public void addElement(ElementImpl elementImpl){
        getElementImpls().add(elementImpl);
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return elementImpls.size();
    }
}