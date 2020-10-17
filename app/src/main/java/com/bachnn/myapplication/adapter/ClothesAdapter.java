package com.bachnn.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bachnn.myapplication.R;
import com.bachnn.myapplication.listener.ItemListener;
import com.bachnn.myapplication.model.Item;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ClothesAdapter extends RecyclerView.Adapter<ClothesAdapter.ClothesViewHolder> {
    private int mChooseItem = 1;
    private int mNormal = 0;
    private Context mContext;
    private List<Item> mItems;
    private ItemListener mItemListener;

    public ClothesAdapter(Context mContext, List<Item> mItems, ItemListener mItemListener) {
        this.mContext = mContext;
        this.mItems = mItems;
        this.mItemListener = mItemListener;
    }

    @Override
    public int getItemViewType(int position) {
        return mItems.get(position).ismIsSale() ? mChooseItem : mNormal;
    }

    @NonNull
    @Override
    public ClothesAdapter.ClothesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == mChooseItem){
            view= LayoutInflater.from(mContext).inflate(R.layout.item_choose,parent,false);
        }else {
            view= LayoutInflater.from(mContext).inflate(R.layout.item_normal,parent,false);
        }
        return new ClothesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClothesAdapter.ClothesViewHolder holder, int position) {
        holder.onBind(mItems.get(position));
        Glide.with(mContext)
                .load(mItems.get(position).getmImage())
                .placeholder(R.drawable.yeu_em)
                .into(holder.imgItem);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ClothesViewHolder extends RecyclerView.ViewHolder {
        FrameLayout frameLayout;
        ImageView imgItem;
        TextView isSaleItem;
        TextView nameItem;
        public ClothesViewHolder(@NonNull View itemView) {
            super(itemView);
            frameLayout= itemView.findViewById(R.id.fram);
            imgItem= itemView.findViewById(R.id.image_item);
            isSaleItem= itemView.findViewById(R.id.is_sale);
            nameItem= itemView.findViewById(R.id.name_item);
            frameLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemListener.setOnClickItem(mItems.get(getAdapterPosition()));
                }
            });

        }

        public void onBind(Item item) {
            nameItem.setText(item.getmName());
            if (item.ismIsSale()){
                isSaleItem.setVisibility(View.VISIBLE);
                isSaleItem.setText(item.getmSale());
            }
        }
    }
}
