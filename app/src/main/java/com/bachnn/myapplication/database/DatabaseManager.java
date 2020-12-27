package com.bachnn.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bachnn.myapplication.model.Customer;
import com.bachnn.myapplication.model.Item;
import com.bachnn.myapplication.model.USERNAME;

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

    public static final String TABLE_USER = "table_user";
    public static final String ID_USER = "id_user";
    public static final String USER_NAME = "user_name";
    public static final String PASS_WORD = "pass_word";
    public static final String USER_IMAGE = "user_image";
    public static final String NAME = "name";

    public static final String CREATE_TABLE_USER = "create table "+TABLE_USER +" ("+ID_USER+" TEXT primary key,"
            +USER_NAME+" TEXT,"
            +PASS_WORD+" TEXT,"
            +USER_IMAGE+" TEXT,"
            +NAME+" TEXT)";


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
        addUSER(new USERNAME("User1","HiepNT","hiep","https://scontent.fhan2-5.fna.fbcdn.net/v/t1.0-9/123139664_195609765394005_2325231913911482083_n.jpg?_nc_cat=109&ccb=2&_nc_sid=09cbfe&_nc_ohc=dCDKMMpwHoEAX-zJZsr&_nc_ht=scontent.fhan2-5.fna&oh=29f41eb6ce4fd4e3e528c1cf8f737a33&oe=600D2973","Nguyễn Tuấn Hiệp"));
        addUSER(new USERNAME("User2","HaiNN","hai","https://scontent.fhan2-3.fna.fbcdn.net/v/t1.0-9/37007105_111555916431829_1048766146792128512_n.jpg?_nc_cat=108&ccb=2&_nc_sid=09cbfe&_nc_ohc=qw8tYId2nswAX_aHULI&_nc_ht=scontent.fhan2-3.fna&oh=e89e66ba8f615950602eb03b2134e036&oe=600DF7D3","Ngô Như Hải"));
        addUSER(new USERNAME("User3","DucNM","duc","https://scontent.fhan2-4.fna.fbcdn.net/v/t1.0-9/23316667_1955412981395302_6276464657419595541_n.jpg?_nc_cat=105&ccb=2&_nc_sid=09cbfe&_nc_ohc=n56CYao8aUgAX_sXupW&_nc_ht=scontent.fhan2-4.fna&oh=a61c84d98ced4f19d2ef453fd34d7f61&oe=600CCEF0","Nguyễn Minh Đức"));
        addUSER(new USERNAME("User4","BachNN","bach","https://scontent.fhan2-5.fna.fbcdn.net/v/t1.0-1/p160x160/84290063_174759260499337_4056752939291639808_o.jpg?_nc_cat=107&ccb=2&_nc_sid=7206a8&_nc_ohc=w5tVi_98xBIAX_DnRGo&_nc_ht=scontent.fhan2-5.fna&tp=6&oh=5817a0979a4d00fff590a1b94d73538a&oe=600D79BA","Nguyễn Ngọc Bách"));
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

    public List<USERNAME> getListUser(){
        List<USERNAME> allCustomers = new ArrayList<>();
        Cursor cursor = mDatabase.query(TABLE_USER, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            String description = cursor.getString(2);
            String image = cursor.getString(3);
            String price = cursor.getString(4);
            allCustomers.add(new USERNAME(id, name,description,image,price));
            cursor.moveToNext();
        }
        //BachNN : đóng con trỏ lại
        cursor.close();
        return allCustomers;
    }

    public long addUSER(USERNAME USERNAME){
        ContentValues cv = new ContentValues();
        cv.put(ID_USER, USERNAME.getID());
        cv.put(USER_NAME, USERNAME.getmUsername());
        cv.put(PASS_WORD, USERNAME.getmPassword());
        cv.put(USER_IMAGE, USERNAME.getmUserImage());
        cv.put(NAME, USERNAME.getmName());
        return  mDatabase.insert(TABLE_USER,null,cv);
    }
}
