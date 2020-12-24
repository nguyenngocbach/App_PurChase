package com.bachnn.myapplication.listener;

import com.bachnn.myapplication.adapter.ClothesAdapter;
import com.bachnn.myapplication.adapter.FinalAdapter;
import com.bachnn.myapplication.adapter.Fragment2Adapter;
import com.bachnn.myapplication.model.Item;

public interface ItemListener {
    void setOnClickItem(Item item , ClothesAdapter.ClothesViewHolder holder);
    void setOnClickItemAll(Item item , FinalAdapter.ViewHolderFinal holder);
    void setOnClickItemFragment2All(Item item , Fragment2Adapter.Fragment2 holder);
}
