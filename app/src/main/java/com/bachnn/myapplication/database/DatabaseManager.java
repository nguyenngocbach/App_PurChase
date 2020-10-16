package com.bachnn.myapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.bachnn.myapplication.model.Item;

import java.util.List;

public class DatabaseManager {
    private Context mContext;
    private DatabaseHelper helper;
    private SQLiteDatabase mDatabase;
    private static DatabaseManager databaseManager;

    private DatabaseManager(Context mContext) {
        this.mContext = mContext;
//        helper= new DatabaseHelper(mContext);
    }

    public List<Item> getAllItem(){

        return null;
    }

    public void addItem(Item item){

    }

    public void saveItem(Item item){

    }

    public void deleteItem(int id){

    }
}
