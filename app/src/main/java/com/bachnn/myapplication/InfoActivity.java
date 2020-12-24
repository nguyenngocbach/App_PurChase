package com.bachnn.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.bachnn.myapplication.model.Item;

public class InfoActivity extends AppCompatActivity {

    private Item mItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Intent intent = getIntent();
        mItem = (Item) intent.getSerializableExtra("Purchase");
    }
}