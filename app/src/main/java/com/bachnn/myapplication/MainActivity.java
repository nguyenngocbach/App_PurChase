package com.bachnn.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.bachnn.myapplication.adapter.ItemPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager vpItem;
    private ItemPagerAdapter mItemPagerAdapter;
    private TabLayout tabItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vpItem = findViewById(R.id.id_view_pager_abc);
        mItemPagerAdapter= new ItemPagerAdapter(getSupportFragmentManager());
        vpItem.setAdapter(mItemPagerAdapter);
        tabItem = findViewById(R.id.id_tablayout);
        tabItem.setupWithViewPager(vpItem);
    }
}