package com.bachnn.myapplication.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bachnn.myapplication.LogicActivity;
import com.bachnn.myapplication.PersonallyActivity;
import com.bachnn.myapplication.R;
import com.bachnn.myapplication.adapter.ItemPersonallyAdapter;
import com.bachnn.myapplication.database.DatabaseManager;
import com.bachnn.myapplication.model.Customer;
import com.bachnn.myapplication.model.Item;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HistoryFragment extends Fragment implements ItemPersonallyAdapter.PersonallyListener{
    private RecyclerView recyclerView;
    private List<Item> mItems;
    private ItemPersonallyAdapter mAdapter;
    private List<Customer> mCustomers;
    private DatabaseManager mDatabase;

    private TextView useName;
    private CircleImageView imageView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.history_fragment, container, false);
        recyclerView = view.findViewById(R.id.recycler_personally);
        useName= view.findViewById(R.id.username);
        imageView= view.findViewById(R.id.circleImageView);
        useName.setText(LogicActivity.mUSER.getmName());
        Glide.with(getContext()).load(LogicActivity.mUSER.getmUserImage()).placeholder(R.drawable.mac_book).into(imageView);
        mItems =new ArrayList<>();
        mCustomers = new ArrayList<>();
        mDatabase = DatabaseManager.getInstance(getContext());
        mAdapter = new ItemPersonallyAdapter(getContext(),mItems,this);
        addData();
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    private void addData() {
        new RunBackGround().execute();
        mItems.addAll(mDatabase.getAllItem());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClickPersonally(Item item) {
        Customer customer = null;
        for (int i=0 ;i<mCustomers.size();i++){
            if (mCustomers.get(i).getID().equals(item.getmID())){
                customer = mCustomers.get(i);
            }
        }
        Intent intent = new Intent(getContext(), PersonallyActivity.class);
        intent.putExtra("personally",item);
        intent.putExtra("customer",customer);
        startActivity(intent);
    }
    class RunBackGround extends AsyncTask<Void,Void,List<Customer>>{

        @Override
        protected List<Customer> doInBackground(Void... voids) {
            return mDatabase.getListCustomer();
        }

        @Override
        protected void onPostExecute(List<Customer> items) {
            super.onPostExecute(items);
            mCustomers.addAll(items);
        }
    }
}
