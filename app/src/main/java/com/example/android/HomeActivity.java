package com.example.android;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.adapter.DataAdapter;
import com.example.android.adapter.DataRecyclerAdapter;
import com.example.android.manager.ListLayoutManager;
import com.example.android.model.ItemData;


public class HomeActivity extends Activity {

//    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private DataAdapter dataAdapter;
    private LinearLayoutManager layoutManager;

    //
    private final String IMAGE_SERVICE = "https://placeimg.com/640/320/";

    private int numItems;
    private RecyclerView mRecyclerView;
    private DataRecyclerAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        ItemData itemDatas[] = { new ItemData("Hola",R.drawable.ic_launcher), new ItemData("Chau",R.drawable.ic_launcher)};

//        setupLayoutManagerHorizontal();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new DataRecyclerAdapter();
        mLayoutManager = new LinearLayoutManager(this);

        createLayout();

    }

    private void createLayout(){
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL) );
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAdapter.addFirst(createDummyItem());
    }

    private ItemData createDummyItem() {
        return new ItemData("Photo " + (++numItems), IMAGE_SERVICE+numItems);
    }


    private void setupLayoutManagerHorizontal() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //Su tamaño se mantiene igual.
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(layoutManager);
        dataAdapter = new DataAdapter();
        recyclerView.setAdapter(dataAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_add) {
            mAdapter.addFirst(createDummyItem());
            mLayoutManager.scrollToPosition(0);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
