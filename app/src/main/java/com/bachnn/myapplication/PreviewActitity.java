package com.bachnn.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.transition.Transition;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bachnn.myapplication.adapter.ClothesAdapter;
import com.bachnn.myapplication.adapter.FinalAdapter;
import com.bachnn.myapplication.adapter.Fragment2Adapter;
import com.bachnn.myapplication.fragment.DialogTwoFragment;
import com.bachnn.myapplication.listener.ItemListener;
import com.bachnn.myapplication.model.Item;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

public class PreviewActitity extends AppCompatActivity implements ItemListener {

    private Item item;
    private Toolbar toolbar;
    private ImageView imageView;

    private RecyclerView mRecyclerView;
    private FinalAdapter mAdapter;
    private List<Item> itemList;
    private TextView txtDescription;

    private Dialog dialogPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_actitity);
        Intent intent= getIntent();
        item = (Item) intent.getSerializableExtra("ALLITEM");
        itemList = (List<Item>) intent.getSerializableExtra("fullItem");
        toolbar= findViewById(R.id.toolbar_nhe);
        txtDescription = findViewById(R.id.txt_description);
        txtDescription.setText(item.getmDescription());
        toolbar.setTitle(item.getmName());
        imageView= findViewById(R.id.img_nhe);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {
                finishAfterTransition();
            }
        });
        load();

        mRecyclerView= findViewById(R.id.recycler_preview);
        mAdapter= new FinalAdapter(this,itemList,this);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void load() {
        if (checkStatu()){
            loadFullScreen();
        }else {
            loadThumbnail();
        }
    }
    private void loadFullScreen(){
        Picasso.with(this)
                .load(item.getmImage())
                .noFade()
                .into(imageView);
    }

    private void loadThumbnail() {
        Picasso.with(this)
                .load(item.getmImage())
                .noFade()
                .into(imageView);
    }

    private boolean checkStatu() {
        Transition transition= null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            transition= getWindow().getSharedElementEnterTransition();
            if (transition!=null){
                transition.addListener(new Transition.TransitionListener() {
                    @Override
                    public void onTransitionStart(Transition transition) {

                    }

                    @Override
                    public void onTransitionEnd(Transition transition) {
                        loadFullScreen();
                        transition.removeListener(this);
                    }

                    @Override
                    public void onTransitionCancel(Transition transition) {
                        transition.removeListener(this);
                    }

                    @Override
                    public void onTransitionPause(Transition transition) {

                    }

                    @Override
                    public void onTransitionResume(Transition transition) {

                    }
                });
                return true;
            }
        }
        return false;
    }

    @Override
    public void setOnClickItem(Item item, ClothesAdapter.ClothesViewHolder holder) {
        Intent intent= new Intent(this,PreviewActitity.class);
        intent.putExtra("ALLITEM",item);
        intent.putExtra("fullItem", (Serializable) itemList);
        ActivityOptionsCompat compat= ActivityOptionsCompat.makeSceneTransitionAnimation( this,
                new Pair<View, String>(holder.imgItem,"img_nhe"),
                new Pair<View, String>(holder.nameItem,"txt_nhe")
        );

        ActivityCompat.startActivity(this,intent,compat.toBundle());
    }

    @Override
    public void setOnClickItemAll(Item item, FinalAdapter.ViewHolderFinal holder) {
        Intent intent= new Intent(this,PreviewActitity.class);
        intent.putExtra("ALLITEM",item);
        intent.putExtra("fullItem", (Serializable) itemList);
        ActivityOptionsCompat compat= ActivityOptionsCompat.makeSceneTransitionAnimation( this,
                new Pair<View, String>(holder.imgItem,"img_nhe"),
                new Pair<View, String>(holder.nameItem,"txt_nhe")
        );

        ActivityCompat.startActivity(this,intent,compat.toBundle());
    }

    @Override
    public void setOnClickItemFragment2All(Item item, Fragment2Adapter.Fragment2 holder) {

    }

    public void onPurchase(View view) {
        Intent intent = new Intent(this,InfoActivity.class);
        intent.putExtra("Purchase",item);
        startActivity(intent);
    }

    public void onCheckItem(View view) {
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (dialogPreview != null) {
            dialogPreview.dismiss();
            dialogPreview = null;
        }
    }
}