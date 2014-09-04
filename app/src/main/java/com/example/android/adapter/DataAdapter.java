package com.example.android.adapter;

import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.R;
import com.example.android.model.ItemData;

/**
 * Created by achercasky on 06/08/14.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{

    private ItemData[] itemDatas;

    public DataAdapter(){

    }

    public DataAdapter(ItemData[] itemDatas) {
        this.itemDatas = itemDatas;
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    /**
     * Crea las nuevas vistas(invocadas por el layout manager)
     *
     * @param viewGroup
     * @param i
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        //Crea la View
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_adapter, null);

        //Crea el ViewHolder
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    /**
     * Reemplaza el contenido de la view (invocada por el layout manager)
     *
     * @param viewHolder
     * @param i
     */
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

//        viewHolder.txtViewTitle.setText(itemDatas[i].getTitle());
//        viewHolder.imgViewIcon.setImageResource(itemDatas[i].getImageUrl());

    }


    /**
     * Mantiene la referencia de cada item del RecyclerView
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtViewTitle;
        public ImageView imgViewIcon;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.item_title);
            imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.item_icon);
        }
    }


}
