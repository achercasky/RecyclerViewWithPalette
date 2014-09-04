package com.example.android.manager;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by achercasky on 06/08/14.
 */
public class ListLayoutManager extends LinearLayoutManager /*RecyclerView.LayoutManager*/{

    public ListLayoutManager(Context context){
        super(context);
    }


    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }




}
