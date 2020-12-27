package com.bachnn.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bachnn.myapplication.R;
import com.bachnn.myapplication.listener.ItemListener;
import com.bachnn.myapplication.model.Item;
import com.bumptech.glide.Glide;

import java.util.List;

public class FinalAdapter extends RecyclerView.Adapter<FinalAdapter.ViewHolderFinal>  {
    private Context mContext;
    private List<Item> mItems;
    private ItemListener listener;

    public FinalAdapter(Context mContext, List<Item> mItems, ItemListener listener) {
        this.mContext = mContext;
        this.mItems = mItems;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        return mItems.get(position).getmType();
    }

    @NonNull
    @Override
    public FinalAdapter.ViewHolderFinal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType==0) {
            view = LayoutInflater.from(mContext).inflate(R.layout.layout_view_sale, parent, false);
        }
        else {
            view = LayoutInflater.from(mContext).inflate(R.layout.layout_view_unsale,parent,false);
        }
        return new ViewHolderFinal(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FinalAdapter.ViewHolderFinal holder, final int position) {
        holder.onBind(mItems.get(position));
        holder.imgItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.setOnClickItemAll(mItems.get(position),holder);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolderFinal extends RecyclerView.ViewHolder {
        public ImageView imgItem;
        public TextView nameItem;
        public TextView txtPrice;
        public TextView txtSale;
        public ViewHolderFinal(@NonNull final View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.img_sale);
            nameItem = itemView.findViewById(R.id.name_item);
            txtPrice= itemView.findViewById(R.id.item_price);
            txtSale= itemView.findViewById(R.id.item_sale);

        }

        public void onBind(Item item) {
            Glide.with(mContext)
                    .load(item.getmImage())
                    .placeholder(R.drawable.yeu_em)
                    .into(imgItem);
            nameItem.setText(item.getmName());
            txtPrice.setText(item.getmPrice());
            if (getItemViewType()!=0){
                txtSale.setVisibility(View.GONE);
            }else nameItem.setText(item.getmName());
        }
    }
}
