package com.bachnn.myapplication.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bachnn.myapplication.MainActivity;
import com.bachnn.myapplication.PreviewActitity;
import com.bachnn.myapplication.R;
import com.bachnn.myapplication.SaleActivity;
import com.bachnn.myapplication.adapter.ClothesAdapter;
import com.bachnn.myapplication.adapter.FinalAdapter;
import com.bachnn.myapplication.adapter.Fragment2Adapter;
import com.bachnn.myapplication.listener.ItemListener;
import com.bachnn.myapplication.model.Item;
import com.google.android.material.tabs.TabLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DirectoryFragment extends Fragment implements ItemListener {

    private RecyclerView recyclerView;
    private Fragment2Adapter adapter;
    private List<Item> mItems;
    List<Item> mAllItem;

    private MainActivity mainActivity;
    private ImageView mImageHome;
    private ImageView mImageSale;
    private ImageView mImageDell;
    private ImageView mImageMacOS;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity){
            mainActivity= (MainActivity) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.directory_layout,container,false);
        recyclerView = view.findViewById(R.id.recycler_view_fragment2);
        mImageHome = view.findViewById(R.id.image_home);
        mImageSale = view.findViewById(R.id.image_sale);
        mImageDell = view.findViewById(R.id.image_dell);
        mImageMacOS = view.findViewById(R.id.image_mac_os);
        addData();
        mItems= new ArrayList<>();
        adapter = new Fragment2Adapter(getContext(),mItems,this);
        allItem();
        recyclerView.setAdapter(adapter);
        setTabView();
        mImageHome.setBackgroundResource(R.color.color_while);
        mImageHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allItem();
                setTabView();
                mImageHome.setBackgroundResource(R.color.color_while);
            }
        });

        mImageSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTabView();
                mImageSale.setBackgroundResource(R.color.color_while);
                sale();
            }
        });

        mImageDell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTabView();
                mImageDell.setBackgroundResource(R.color.color_while);
                dell();
            }
        });

        mImageMacOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTabView();
                mImageMacOS.setBackgroundResource(R.color.color_while);
                macOS();
            }
        });
        return view;
    }

    private void setTabView() {
        mImageHome.setBackgroundResource(R.color.tab_view);
        mImageSale.setBackgroundResource(R.color.tab_view);
        mImageDell.setBackgroundResource(R.color.tab_view);
        mImageMacOS.setBackgroundResource(R.color.tab_view);
    }

    private void allItem() {
        if (mItems != null){
            mItems.clear();
        }
        mItems.addAll(mAllItem);
    }


    private void macOS() {
        if (mItems != null){
            mItems.clear();
        } else mItems= new ArrayList<>();
        for (Item item : mAllItem) if (item.getmType()==1){
            mItems.add(item);
        }
        adapter.notifyDataSetChanged();
    }

    private void dell() {
        if (mItems != null){
            mItems.clear();
        } else mItems= new ArrayList<>();
        for (Item item : mAllItem) if (item.getmType()==0){
            mItems.add(item);
        }
        adapter.notifyDataSetChanged();
    }

    private void sale() {
        if (mItems != null){
            mItems.clear();
        } else mItems= new ArrayList<>();
        for (Item item : mAllItem) if (item.ismIsSale()){
            mItems.add(item);
        }
        adapter.notifyDataSetChanged();
    }

    private void addData() {
        mAllItem = new ArrayList<>();
        //String mID, String mName, String mDescription, String mImage, String mPrice, String mSale, boolean mIsSale, String mType
        mAllItem.add(new Item("123"," Lenovo","Laptop Lenovo G480; cpu b960; ram 4gb; ssd 128; man hinh 14in, K/M Cặp, Sạc, Chuột k dây, bàn di",
                "https://maytinhdongbodell.vn/img/p/laptop-lenovo-g480-966.jpg"," 3320000","20%",true,3));
        mAllItem.add(new Item("124","HP Pavilion","HP Pavilion 14 v022TU; Core i3-4030U processor - 1.90 GHz (3MB L3 Cache); Ram 4gb/SSD 160GB mới",
                "https://maytinhdongbodell.vn/img/p/hp-pavilion-14-v022tu-965.jpg","4740000","20%",true,3));
        mAllItem.add(new Item("125","Lenovo X131E","Lenovo X131E, I3--3227U; Ram 4FGB; SSD 128; MÀN 11,6IN",
                "https://maytinhdongbodell.vn/img/p/lenovo-x131e-cau-hinh-02-964.jpg","4130000","20%",false,3));
        mAllItem.add(new Item("126","Lenovo X131E","Lenovo X131E, I3--3227U; Ram 4FGB; SSD 128; MÀN 11,6IN",
                "https://maytinhdongbodell.vn/img/p/lenovo-x131e-963.jpg","4270000","20%",false,3));

        mAllItem.add(new Item("127","Lenovo Thinkpad ","Laptop Lenovo Thinkpad L460 core i5-6300U, RAM 8GB, SSD 128GB",
                "https://maytinhdongbodell.vn/img/p/laptop-lenovo-thinkpad-l460-724.jpg","6980000","20%",false,3));
        mAllItem.add(new Item("128","Dell Precision","Laptop Dell Precision M3800 core i7-4702HQ, RAM 8GB, SSD 256GB",
                "https://maytinhdongbodell.vn/img/p/laptop-dell-precision-m3800-719.jpg","11210000","20%",true,0));
        mAllItem.add(new Item("129","Dell M3800","Laptop Dell Precision M3800 core i7-4702HQ, RAM 8GB, SSD 256GB",
                "https://maytinhdongbodell.vn/img/p/laptop-dell-precision-m3800-719.jpg","11210000","20%",false,0));
        mAllItem.add(new Item("130","Dell L5490","Laptop Dell Latitude 5490 cấu hình Intel core i5-7200U, RAM 8GB, SSD 256GB",
                "https://maytinhdongbodell.vn/img/p/laptop-dell-latitude-5490-cau-hinh-1-926.jpg","9920000","20%",false,0));

        mAllItem.add(new Item("130","Dell L5490","Laptop Dell Latitude 5490 cấu hình Intel core i5-7200U, RAM 8GB, SSD 256GB",
                "https://i.ytimg.com/vi/-YHEIXVk9g4/maxresdefault.jpg","9920000","20%",false,0));
        mAllItem.add(new Item("130","Dell L5490","Laptop Dell Latitude 5490 cấu hình Intel core i5-7200U, RAM 8GB, SSD 256GB",
                "https://techaeris.com/wp-content/uploads/2019/01/Dell-G5-15.jpg","9920000","20%",false,0));
        mAllItem.add(new Item("130","Dell L5490","Laptop Dell Latitude 5490 cấu hình Intel core i5-7200U, RAM 8GB, SSD 256GB",
                "https://news-cdn.softpedia.com/images/news2/dell-launches-three-new-dell-precision-laptops-powered-by-ubuntu-linux-526237-3.jpg","9920000","20%",false,0));



        mAllItem.add(new Item("131","HP 242G2","Laptop HP 242G2 core i3, RAM 4GB, HDD 250GB",
                "https://maytinhdongbodell.vn/img/p/laptop-hp-242g2-709.jpg","3990000","20%",true,3));
        mAllItem.add(new Item("132","HP Probook 6470B","Laptop HP Probook 6470B core i5, RAM 4GB, HDD 320GB",
                "https://maytinhdongbodell.vn/img/p/laptop-hp-probook-6470b-708.jpg","4180000","20%",false,3));
        mAllItem.add(new Item("133","Hp Zbook 15","Laptop Hp Zbook 15 core i7-4800, RAM 8GB, SSD 256GB",
                "https://maytinhdongbodell.vn/img/p/laptop-hp-zbook-15-554.jpg","10450000","20%",false,3));


        mAllItem.add(new Item("134","Macbook Air 13","Macbook Air 13 inch 2017 (i7 2.2GHz, RAM 8GB, SSD 256GB, Intel HD Graphics 6000, 13 inch HD+) ",
                "https://laptop88.vn/media/product/5196_macbook_air_13_inch_2017_i7_1.jpg","18400000","20%",false,1));
        mAllItem.add(new Item("135","MacBook Pro 16","MacBook Pro 16\" 2019 Touch Bar 2.3GHz Core i9 1TB",
                "https://images.fpt.shop/unsafe/fit-in/240x215/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2019/11/18/637096956683492064_MBP-16-touch-dd.png","69990000","20%",false,1));
        mAllItem.add(new Item("136","MacBook Pro 16","MacBook Pro 16\" 2019 Touch Bar 2.6GHz Core i7 512GB",
                "https://images.fpt.shop/unsafe/fit-in/240x215/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2019/11/18/637096956683492064_MBP-16-touch-dd.png","59990000","20%",false,1));
        mAllItem.add(new Item("133","MacBook Pro 13","MacBook Pro 13\" 2020 Touch Bar 2.0GHz Core i5 512GB",
                "https://images.fpt.shop/unsafe/fit-in/240x215/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2020/6/5/637269501975415139_mb-pro-13-2020-xam-dd.png","47990000","20%",false,1));
        mAllItem.add(new Item("133","Laptop Asus Pro","Laptop Asus Pro P1440FA-FA0674T - Intel Core i3 màn Full HD, SIÊU BỀN đạt tiêu chuẩn quân sự Mỹ, có ổ DVD học tiếng Anh, bảo hành 2 năm chính hãng",
                "https://laptop88.vn/media/product/pro_poster_5124.jpg","7990000","20%",false,3));

        mAllItem.add(new Item("133","MacBook Pro 19","Laptop Asus Pro P1440FA-FA0674T - Intel Core i3 màn Full HD, SIÊU BỀN đạt tiêu chuẩn quân sự Mỹ, có ổ DVD học tiếng Anh, bảo hành 2 năm chính hãng",
                "https://cdn2.macworld.co.uk/cmsdata/features/3408399/macbook_pro_201711.jpg","7990000","20%",false,1));
        mAllItem.add(new Item("133","MacBook Pro 20","Laptop Asus Pro P1440FA-FA0674T - Intel Core i3 màn Full HD, SIÊU BỀN đạt tiêu chuẩn quân sự Mỹ, có ổ DVD học tiếng Anh, bảo hành 2 năm chính hãng",
                "https://www.extremetech.com/wp-content/uploads/2018/07/598438-macbook-pro-2018.jpg","7990000","20%",false,1));
        mAllItem.add(new Item("133","MacBook Pro S20","Laptop Asus Pro P1440FA-FA0674T - Intel Core i3 màn Full HD, SIÊU BỀN đạt tiêu chuẩn quân sự Mỹ, có ổ DVD học tiếng Anh, bảo hành 2 năm chính hãng",
                "https://tse1.mm.bing.net/th?id=OIP.mAK55h-9MreEEsQ8ojSX7QHaGu&pid=Api&P=0&w=186&h=170","7990000","20%",false,1));
        mAllItem.add(new Item("133","Laptop Asus M413IA-EK338T","Laptop Asus M413IA-EK338T - AMD Ryzen 5",
                "https://laptop88.vn/media/product/pro_poster_5443.jpg","14990000","20%",true,3));

        mAllItem.add(new Item("133","Laptop Asus X509FJ","Laptop Asus X509FJ EJ053T & EJ153T - Intel Core i5",
                "https://laptop88.vn/media/product/pro_poster_4624.jpg","13290000","20%",false,3));

        mAllItem.add(new Item("133","Laptop Asus TUF A15","Laptop Asus TUF A15 FA506IH-AL018T - AMD Ryzen 5",
                "https://laptop88.vn/media/product/pro_poster_5268.jpg","18990000","20%",true,3));
    }

    @Override
    public void setOnClickItem(Item item, ClothesAdapter.ClothesViewHolder holder) {
        Intent intent= new Intent(getContext(), PreviewActitity.class);
        intent.putExtra("ALLITEM",item);
        intent.putExtra("fullItem", (Serializable) mItems);
        ActivityOptionsCompat compat= ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) getContext(),
                new Pair<View, String>(holder.imgItem,"img_nhe"),
                new Pair<View, String>(holder.nameItem,"txt_nhe")
        );

        ActivityCompat.startActivity(getContext(),intent,compat.toBundle());
    }

    @Override
    public void setOnClickItemAll(Item item, FinalAdapter.ViewHolderFinal holder) {
        Intent intent= new Intent(getContext(),PreviewActitity.class);
        intent.putExtra("ALLITEM",item);
        intent.putExtra("fullItem", (Serializable) mItems);
        ActivityOptionsCompat compat= ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) getContext(),
                new Pair<View, String>(holder.imgItem,"img_nhe"),
                new Pair<View, String>(holder.nameItem,"txt_nhe")
        );

        ActivityCompat.startActivity(getContext(),intent,compat.toBundle());
    }

    @Override
    public void setOnClickItemFragment2All(Item item, Fragment2Adapter.Fragment2 holder) {
        Intent intent= new Intent(getContext(), PreviewActitity.class);
        intent.putExtra("ALLITEM",item);
        intent.putExtra("fullItem", (Serializable) mItems);
        ActivityOptionsCompat compat= ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) getContext(),
                new Pair<View, String>(holder.img,"img_nhe"),
                new Pair<View, String>(holder.name,"txt_nhe")
        );

        ActivityCompat.startActivity(getContext(),intent,compat.toBundle());
    }
}
