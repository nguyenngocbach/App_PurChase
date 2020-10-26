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
import com.bachnn.myapplication.listener.IAllItemListener;
import com.bachnn.myapplication.model.AllItem;
import com.bumptech.glide.Glide;

import java.util.List;

public class AllAdapter extends RecyclerView.Adapter<AllAdapter.ViewHolderAll> {
    private Context mContext;
    private List<AllItem> mAllItems;
    private IAllItemListener mIAllItemListener;

    public AllAdapter(Context mContext, List<AllItem> mAllItems, IAllItemListener mIAllItemListener) {
        this.mContext = mContext;
        this.mAllItems = mAllItems;
        this.mIAllItemListener = mIAllItemListener;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 == 0 ? 1 : 2;
    }

    @NonNull
    @Override
    public ViewHolderAll onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType==1){
            view= LayoutInflater.from(mContext).inflate(R.layout.all_one_type_adapter,parent,false);
        } else {
            view= LayoutInflater.from(mContext).inflate(R.layout.all_two_type_adapter,parent,false);
        }
        return new ViewHolderAll(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAll holder, int position) {
        holder.onBindView(mAllItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mAllItems.size();
    }

    public class ViewHolderAll extends RecyclerView.ViewHolder {
        TextView txtTitle;
        ImageView imgOne;
        ImageView imgTwo;
        ImageView imgThree;
        ImageView imgFour;
        ImageView imgFive;
        public ViewHolderAll(@NonNull View itemView) {
            super(itemView);
            txtTitle= itemView.findViewById(R.id.txt_title_one);
            imgOne= itemView.findViewById(R.id.img_one);
            imgTwo= itemView.findViewById(R.id.img_two);
            imgThree= itemView.findViewById(R.id.img_three);
            imgFour= itemView.findViewById(R.id.img_four);
            imgFive= itemView.findViewById(R.id.img_five);
            txtTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            imgOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            imgTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            imgThree.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            imgFour.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            imgFive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }


        public void onBindView(AllItem allItem) {
            txtTitle.setText(allItem.getmTitle());
            Glide.with(mContext)
                    .load(allItem.getmImageOne())
                    .placeholder(R.drawable.yeu_em2)
                    .into(imgOne);
            Glide.with(mContext)
                    .load(allItem.getmImageTwo())
                    .placeholder(R.drawable.yeu_em)
                    .into(imgTwo);
            Glide.with(mContext)
                    .load(allItem.getmImageThree())
                    .placeholder(R.drawable.yeu_em)
                    .into(imgThree);
            Glide.with(mContext)
                    .load(allItem.getmImageFour())
                    .placeholder(R.drawable.yeu_em)
                    .into(imgFour);
            Glide.with(mContext)
                    .load(allItem.getmImageFive())
                    .placeholder(R.drawable.yeu_em)
                    .into(imgFive);
        }
    }
}
