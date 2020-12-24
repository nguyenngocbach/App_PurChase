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

import org.w3c.dom.Text;

import java.util.List;

public class Fragment2Adapter extends RecyclerView.Adapter<Fragment2Adapter.Fragment2> {

    private Context mContext;
    private List<Item> mItems;
    private ItemListener itemListener;


    public Fragment2Adapter(Context mContext, List<Item> mItems, ItemListener itemListener) {
        this.mContext = mContext;
        this.mItems = mItems;
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public Fragment2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_fragment_2,parent,false);
        return new Fragment2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Fragment2 holder, final int position) {
        holder.onBind(mItems.get(position));
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemListener.setOnClickItemFragment2All(mItems.get(position), holder);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class Fragment2 extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView name;
        TextView sale;
        public Fragment2(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.image_item);
            name = itemView.findViewById(R.id.name_item);
            sale = itemView.findViewById(R.id.item_sale);
        }

        public void onBind(Item item) {
            Glide.with(mContext).load(item.getmImage()).placeholder(R.drawable.ngoc_em).into(img);
            name.setText(item.getmName());
            if (item.ismIsSale()){
                sale.setText(item.getmSale());
            }else sale.setVisibility(View.GONE);
        }
    }
}
