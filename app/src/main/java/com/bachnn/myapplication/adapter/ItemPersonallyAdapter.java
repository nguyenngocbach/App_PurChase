package com.bachnn.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bachnn.myapplication.R;
import com.bachnn.myapplication.model.Item;

import java.util.List;

public class ItemPersonallyAdapter extends RecyclerView.Adapter<ItemPersonallyAdapter.ViewHolder> {

    private Context mContext;
    private List<Item> mItems;
    private PersonallyListener mPersonallyListener;

    public ItemPersonallyAdapter(Context mContext, List<Item> mItems, PersonallyListener mPersonallyListener) {
        this.mContext = mContext;
        this.mItems = mItems;
        this.mPersonallyListener = mPersonallyListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.personal_line,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtPersonally;
        ImageView iconNext;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPersonally = itemView.findViewById(R.id.txt_personally);
            iconNext = itemView.findViewById(R.id.icon_next);
        }

        public void onBind(final Item item) {
            txtPersonally.setText(item.getmName());
            iconNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mPersonallyListener.onClickPersonally(item);
                }
            });
        }
    }

    public interface PersonallyListener{
        void onClickPersonally(Item item);
    }
}
