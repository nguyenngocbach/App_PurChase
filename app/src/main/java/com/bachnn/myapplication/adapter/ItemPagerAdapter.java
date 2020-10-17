package com.bachnn.myapplication.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.bachnn.myapplication.fragment.DirectoryFragment;
import com.bachnn.myapplication.fragment.HistoryFragment;
import com.bachnn.myapplication.fragment.MainFragment;

public class ItemPagerAdapter  extends FragmentPagerAdapter {
    private String[] titles = new String[]{"Home", "Directory", "History"};

    public ItemPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new MainFragment();
            case 1:
                return new DirectoryFragment();
            case 2:
                return new HistoryFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return  titles.length;
    }
}
