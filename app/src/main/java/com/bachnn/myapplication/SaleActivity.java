package com.bachnn.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bachnn.myapplication.adapter.ClothesAdapter;
import com.bachnn.myapplication.adapter.FinalAdapter;
import com.bachnn.myapplication.adapter.Fragment2Adapter;
import com.bachnn.myapplication.listener.ItemListener;
import com.bachnn.myapplication.model.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SaleActivity extends AppCompatActivity implements ItemListener {

    private Toolbar toolbar;
    private ImageView imageView;

    private RecyclerView mRecyclerView;
    private FinalAdapter mAdapter;
    private List<Item> itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);
        Intent intent= getIntent();
        String linkImage= intent.getStringExtra("image");
        int title= intent.getIntExtra("position",0);
        itemList = (List<Item>) intent.getSerializableExtra("fullItem");
        toolbar= findViewById(R.id.toolbar_nhe);
        imageView= findViewById(R.id.img_nhe);
        Log.d("bachdz",linkImage);
        Picasso.with(this)
                .load(linkImage)
                .into(imageView);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mRecyclerView= findViewById(R.id.recycler_preview);
        mAdapter= new FinalAdapter(this,itemList,this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void setOnClickItem(Item item, ClothesAdapter.ClothesViewHolder holder) {

    }

    @Override
    public void setOnClickItemAll(Item item, FinalAdapter.ViewHolderFinal holder) {

    }

    @Override
    public void setOnClickItemFragment2All(Item item, Fragment2Adapter.Fragment2 holder) {

    }
}