package com.bachnn.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bachnn.myapplication.model.Customer;
import com.bachnn.myapplication.model.Item;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    public static String TABLE_LAPTOP ="laptopTable";

    public static String ID ="id_laptop";
    public static String NAME_LAPTOP ="name_laptop";
    public static String DESCRIPTION ="description";
    public static String IMAGE ="image";
    public static String PRICE ="price";
    public static String SALE ="sale";
    public static String TYPE_LAPTOP ="type_laptop";

    public static String CREATE_TABLE_LAPTOP =" create table "+TABLE_LAPTOP+" ( "+ID+" TEXT ," +
            NAME_LAPTOP+" TEXT ,"
            +DESCRIPTION+ " TEXT,"
            +IMAGE+" TEXT,"
            +PRICE+" TEXT,"
            +SALE+ " TEXT,"
            +TYPE_LAPTOP+ " TEXT)";

    public static String TABLE_CUSTOMER ="customerTable";
    public static String ID_CUSTOMER ="id_customer";
    public static String NAME_CUSTOMER ="name_customer";
    public static String ADDRESS_CUSTOMER ="address_customer";
    public static String SDT_CUSTOMER ="sdt_customer";
    public static String EMAIL_CUSTOMER ="email_customer";
    public static final String CREATE_TABLE_CUSTOMER ="create table "+TABLE_CUSTOMER+" ("+ID_CUSTOMER+" TEXT,"
            +NAME_CUSTOMER+" TEXT,"
            +ADDRESS_CUSTOMER+" TEXT,"
            +SDT_CUSTOMER+" TEXT,"
            +EMAIL_CUSTOMER+" TEXT)";

    private Context mContext;
    private DatabaseHelper helper;
    private SQLiteDatabase mDatabase;
    private static DatabaseManager databaseManager;
    public static DatabaseManager getInstance(Context context){
        if (databaseManager==null){
            databaseManager= new DatabaseManager(context);
        }
        return databaseManager;
    }

    private DatabaseManager(Context mContext) {
        this.mContext = mContext;
        helper= new DatabaseHelper(mContext);
        mDatabase = helper.getWritableDatabase();
    }

    //String mID, String mName, String mDescription, String mImage, String mPrice, String mSale, boolean mIsSale, int mType
    public List<Item> getAllItem(){
        List<Item> allItem = new ArrayList<>();
        Cursor cursor = mDatabase.query(TABLE_LAPTOP, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            String description = cursor.getString(2);
            String image = cursor.getString(3);
            String price = cursor.getString(4);
            String sale = cursor.getString(5);
            String type = cursor.getString(6);
            int mType = Integer.parseInt(type);
            allItem.add(new Item(id, name,description,image,price,sale,false,mType));
            cursor.moveToNext();
        }
        //BachNN : đóng con trỏ lại
        cursor.close();
        return allItem;
    }

    public void addItem(Item item){
        ContentValues cv = new ContentValues();
        cv.put(ID,item.getmID());
        cv.put(NAME_LAPTOP,item.getmName());
        cv.put(DESCRIPTION,item.getmDescription());
        cv.put(IMAGE,item.getmImage());
        cv.put(PRICE,item.getmPrice());
        cv.put(SALE,item.getmSale());
        cv.put(TYPE_LAPTOP,item.getmType());
        mDatabase.insert(TABLE_LAPTOP,null,cv);
    }

    public void saveItem(Item item){

    }

    public void deleteItem(int id){

    }

    public List<Customer> getListCustomer(){
        List<Customer> allCustomers = new ArrayList<>();
        Cursor cursor = mDatabase.query(TABLE_CUSTOMER, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            String description = cursor.getString(2);
            String image = cursor.getString(3);
            String price = cursor.getString(4);
            allCustomers.add(new Customer(id, name,description,image,price));
            cursor.moveToNext();
        }
        //BachNN : đóng con trỏ lại
        cursor.close();
        return allCustomers;
    }

    public long addCustomer(Customer customer){
        ContentValues cv = new ContentValues();
        cv.put(ID_CUSTOMER,customer.getID());
        cv.put(NAME_CUSTOMER,customer.getmNameCustomer());
        cv.put(ADDRESS_CUSTOMER,customer.getmAddressCustomer());
        cv.put(SDT_CUSTOMER,customer.getmSDTCustomer());
        cv.put(EMAIL_CUSTOMER,customer.getmEmailCustomer());
        return  mDatabase.insert(TABLE_CUSTOMER,null,cv);
    }
}
