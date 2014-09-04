package com.example.android.adapter;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.graphics.Palette;
import android.support.v7.graphics.PaletteItem;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.R;
import com.example.android.model.ItemData;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

/**
 * Created by achercasky on 06/08/14.
 */
public class DataRecyclerAdapter extends RecyclerView.Adapter<DataRecyclerAdapter.ViewHolder>{
    private static final String TAG = "MyAdpater";
    private ArrayList<ItemData> mDataset;

    public DataRecyclerAdapter(ArrayList<ItemData> myDataset) {
        this.mDataset = myDataset;
    }

    public DataRecyclerAdapter(){
        mDataset = new ArrayList<ItemData>();
    }

    /**
     * Crea las nuevas vistas(invocadas por el layout manager)
     *
     * @param viewGroup
     * @param i
     * @return
     */
    @Override
    public DataRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        //Crea la View
        RelativeLayout view = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_adapter, null);

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
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {

        ItemData itemData = mDataset.get(i);
        Log.d(TAG, itemData.getImageUrl());
        Picasso.with(viewHolder.imgViewIcon.getContext())
                .load(itemData.getImageUrl())
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        viewHolder.imgViewIcon.setImageBitmap(bitmap);
                        viewHolder.mLoadingImageView.setVisibility(View.GONE);
                        viewHolder.updatePalette();
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {
                        viewHolder.mLoadingImageView.setVisibility(View.GONE);
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {
                        viewHolder.mLoadingImageView.setVisibility(View.VISIBLE);
                    }
                });
            viewHolder.txtViewTitle.setText(itemData.getTitle());

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void addFirst(ItemData item) {
        mDataset.add(0, item);
        notifyItemInserted(0);
    }

    /**
     * Mantiene la referencia de cada item del RecyclerView
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private static final int PALETTE_SIZE = 24;
        public TextView txtViewTitle;
        public ImageView imgViewIcon;
        private final View mLoadingImageView;
        private final View mLoadingTitleView;

        public ViewHolder(RelativeLayout itemLayoutView) {
            super(itemLayoutView);
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.title);
            imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.imageView);
            mLoadingImageView = itemLayoutView.findViewById(R.id.pbImage);
            mLoadingTitleView = itemLayoutView.findViewById(R.id.pbTitle);
        }

        public void updatePalette() {
            Bitmap bitmap = ((BitmapDrawable)imgViewIcon.getDrawable()).getBitmap();
            Palette.generateAsync(bitmap, PALETTE_SIZE, new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(Palette palette) {
                    PaletteItem item = palette.getLightVibrantColor();
                    if (item != null) {
                        txtViewTitle.setBackgroundColor(adjustAlpha(item.getRgb(), 0.5f));
                    }

                    item = palette.getDarkVibrantColor();
                    if (item != null) {
                        txtViewTitle.setTextColor(item.getRgb());
                    }
                    mLoadingTitleView.setVisibility(View.GONE);
                }

            });
        }

        public int adjustAlpha(int color, float factor) {
            int alpha = Math.round(Color.alpha(color) * factor);
            int red = Color.red(color);
            int green = Color.green(color);
            int blue = Color.blue(color);
            return Color.argb(alpha, red, green, blue);
        }
    }


}
