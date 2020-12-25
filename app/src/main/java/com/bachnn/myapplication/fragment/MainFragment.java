package com.bachnn.myapplication.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewAnimator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bachnn.myapplication.MainActivity;
import com.bachnn.myapplication.PreviewActitity;
import com.bachnn.myapplication.R;
import com.bachnn.myapplication.SaleActivity;
import com.bachnn.myapplication.adapter.AllAdapter;
import com.bachnn.myapplication.adapter.ClothesAdapter;
import com.bachnn.myapplication.adapter.FinalAdapter;
import com.bachnn.myapplication.adapter.Fragment2Adapter;
import com.bachnn.myapplication.listener.IAllItemListener;
import com.bachnn.myapplication.listener.ItemListener;
import com.bachnn.myapplication.model.AllItem;
import com.bachnn.myapplication.model.Item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment implements ItemListener, IAllItemListener {

    public static final String INDEX= "INDEX";
    public static final String POSITION= "POSITION";

    private Toolbar mToolbar;
    private ViewAnimator animator;
    private int[] listImage= {R.drawable.mac_book,R.drawable.lenovo
            ,R.drawable.hp_laptop,R.drawable.asus};
    private Handler handler=new Handler();
    private int index =0;
    private ImageView view;
    private MainActivity mainActivity;

    private RecyclerView recyclerViewAllItem;
    private AllAdapter mAllAdapter;
    private List<AllItem> mAllItems;

    private RecyclerView mRecyclerView;
    private ClothesAdapter mClothAdapter;
    List<Item> mItems;

    private RecyclerView mRecyclerFinal;
    private FinalAdapter mFinalAdapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity){
            mainActivity= (MainActivity) context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.main_fragment,container,false);
        animator= view.findViewById(R.id.icon_lable);
        setAnimation();
        mToolbar= view.findViewById(R.id.toolbar);
        mainActivity.setSupportActionBar(mToolbar);
        mItems= new ArrayList<>();
        mRecyclerView= view.findViewById(R.id.id_recycler_view);
        initData();
        mClothAdapter= new ClothesAdapter(getContext(),mItems,this);
        mRecyclerView.setAdapter(mClothAdapter);

        //All Item
        recyclerViewAllItem= view.findViewById(R.id.recyc_view_2);
        mAllItems= new ArrayList<>();
        mAllAdapter= new AllAdapter(getContext(),mAllItems,this);
        recyclerViewAllItem.setAdapter(mAllAdapter);
        initDataAllItem();

        mRecyclerFinal= view.findViewById(R.id.recycler_view_final);
        mFinalAdapter= new FinalAdapter(getContext(),mItems,this);
        mRecyclerFinal.setAdapter(mFinalAdapter);
        return view;
    }

    private void initDataAllItem() {
        mAllItems.add(new AllItem("Laptop Lenovo ->","http://iv1.lisimg.com/image/3773431/600full-ngoc-trinh.jpghttps://maytinhdongbodell.vn/img/p/laptop-lenovo-g480-966.jpg",
                "Laptop Lenovo G480",
                "https://maytinhdongbodell.vn/img/p/hp-pavilion-14-v022tu-965.jpg",
                "HP Pavilion 14 v022TU",
                "https://maytinhdongbodell.vn/img/p/lenovo-x131e-cau-hinh-02-964.jpg",
                "Lenovo X131E ",
                "https://maytinhdongbodell.vn/img/p/lenovo-x131e-963.jpg",
                "Lenovo X131E ",
                "https://maytinhdongbodell.vn/img/p/laptop-lenovo-thinkpad-l460-724.jpg",
                "Laptop Lenovo Thinkpad"));
        mAllItems.add(new AllItem("MacBook ->","https://i.ytimg.com/vi/V7pce4nrR4c/maxresdefault.jpg",
                "Macbook Air 13 inch",
                "https://tse1.mm.bing.net/th?id=OIP.EXx3BvHLhWGt8_ljDmtDDgHaEK&pid=Api&P=0&w=277&h=156",
                "MacBook Pro 16",
                "https://www.technipages.com/wp-content/uploads/2019/04/macbook-air.jpg",
                "MacBook Pro 16",
                "https://i.ytimg.com/vi/LUH7njvhydE/maxresdefault.jpg",
                "MacBook Pro 13",
                "https://tse3.mm.bing.net/th?id=OIP.cLbIVdu0F7WebiCxKbM3KAHaEo&pid=Api&P=0&w=296&h=186",
                "One"));
    }

    private void initData() {
        mItems.clear();
        //String mID, String mName, String mDescription, String mImage, String mPrice, String mSale, boolean mIsSale, String mType
        mItems.add(new Item("123"," Lenovo","Laptop Lenovo G480; cpu b960; ram 4gb; ssd 128; man hinh 14in, K/M Cặp, Sạc, Chuột k dây, bàn di",
                "https://maytinhdongbodell.vn/img/p/laptop-lenovo-g480-966.jpg"," 3320000","20%",false,0));
        mItems.add(new Item("124","HP Pavilion","HP Pavilion 14 v022TU; Core i3-4030U processor - 1.90 GHz (3MB L3 Cache); Ram 4gb/SSD 160GB mới",
                "https://maytinhdongbodell.vn/img/p/hp-pavilion-14-v022tu-965.jpg","4740000","20%",false,0));
        mItems.add(new Item("125","Lenovo X131E","Lenovo X131E, I3--3227U; Ram 4FGB; SSD 128; MÀN 11,6IN",
                "https://maytinhdongbodell.vn/img/p/lenovo-x131e-cau-hinh-02-964.jpg","4130000","20%",false,0));
        mItems.add(new Item("126","Lenovo X131E","Lenovo X131E, I3--3227U; Ram 4FGB; SSD 128; MÀN 11,6IN",
                "https://maytinhdongbodell.vn/img/p/lenovo-x131e-963.jpg","4270000","20%",false,0));

        mItems.add(new Item("127","Lenovo Thinkpad ","Laptop Lenovo Thinkpad L460 core i5-6300U, RAM 8GB, SSD 128GB",
                "https://maytinhdongbodell.vn/img/p/laptop-lenovo-thinkpad-l460-724.jpg","6980000","20%",false,0));
        mItems.add(new Item("128","Dell Precision","Laptop Dell Precision M3800 core i7-4702HQ, RAM 8GB, SSD 256GB",
                "https://maytinhdongbodell.vn/img/p/laptop-dell-precision-m3800-719.jpg","11210000","20%",false,1));
        mItems.add(new Item("129","Dell M3800","Laptop Dell Precision M3800 core i7-4702HQ, RAM 8GB, SSD 256GB",
                "https://maytinhdongbodell.vn/img/p/laptop-dell-precision-m3800-719.jpg","11210000","20%",false,1));
        mItems.add(new Item("130","Dell L5490","Laptop Dell Latitude 5490 cấu hình Intel core i5-7200U, RAM 8GB, SSD 256GB",
                "https://maytinhdongbodell.vn/img/p/laptop-dell-latitude-5490-cau-hinh-1-926.jpg","9920000","20%",false,1));
        mItems.add(new Item("131","HP 242G2","Laptop HP 242G2 core i3, RAM 4GB, HDD 250GB",
                "https://maytinhdongbodell.vn/img/p/laptop-hp-242g2-709.jpg","3990000","20%",false,0));
        mItems.add(new Item("132","HP Probook 6470B","Laptop HP Probook 6470B core i5, RAM 4GB, HDD 320GB",
                "https://maytinhdongbodell.vn/img/p/laptop-hp-probook-6470b-708.jpg","4180000","20%",false,0));
        mItems.add(new Item("133","Hp Zbook 15","Laptop Hp Zbook 15 core i7-4800, RAM 8GB, SSD 256GB",
                "https://maytinhdongbodell.vn/img/p/laptop-hp-zbook-15-554.jpg","10450000","20%",false,0));


        mItems.add(new Item("134","Macbook Air 13","Macbook Air 13 inch 2017 (i7 2.2GHz, RAM 8GB, SSD 256GB, Intel HD Graphics 6000, 13 inch HD+) ",
                "https://laptop88.vn/media/product/5196_macbook_air_13_inch_2017_i7_1.jpg","18400000","20%",false,2));
        mItems.add(new Item("135","MacBook Pro 16","MacBook Pro 16\" 2019 Touch Bar 2.3GHz Core i9 1TB",
                "https://images.fpt.shop/unsafe/fit-in/240x215/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2019/11/18/637096956683492064_MBP-16-touch-dd.png","69990000","20%",false,2));
        mItems.add(new Item("136","MacBook Pro 16","MacBook Pro 16\" 2019 Touch Bar 2.6GHz Core i7 512GB",
                "https://images.fpt.shop/unsafe/fit-in/240x215/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2019/11/18/637096956683492064_MBP-16-touch-dd.png","59990000","20%",false,2));
        mItems.add(new Item("133","MacBook Pro 13","MacBook Pro 13\" 2020 Touch Bar 2.0GHz Core i5 512GB",
                "https://images.fpt.shop/unsafe/fit-in/240x215/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2020/6/5/637269501975415139_mb-pro-13-2020-xam-dd.png","47990000","20%",false,0));

        mItems.add(new Item("133","Laptop Asus Pro","Laptop Asus Pro P1440FA-FA0674T - Intel Core i3 màn Full HD, SIÊU BỀN đạt tiêu chuẩn quân sự Mỹ, có ổ DVD học tiếng Anh, bảo hành 2 năm chính hãng",
                "https://laptop88.vn/media/product/pro_poster_5124.jpg","7990000","20%",false,0));

        mItems.add(new Item("133","Laptop Asus M413IA-EK338T","Laptop Asus M413IA-EK338T - AMD Ryzen 5",
                "https://laptop88.vn/media/product/pro_poster_5443.jpg","14990000","20%",false,0));

        mItems.add(new Item("133","Laptop Asus X509FJ","Laptop Asus X509FJ EJ053T & EJ153T - Intel Core i5",
                "https://laptop88.vn/media/product/pro_poster_4624.jpg","13290000","20%",false,0));

        mItems.add(new Item("133","Laptop Asus TUF A15","Laptop Asus TUF A15 FA506IH-AL018T - AMD Ryzen 5",
                "https://laptop88.vn/media/product/pro_poster_5268.jpg","18990000","20%",false,0));

    }

    @Override
    public void onStart() {
        super.onStart();
        initData();
        mClothAdapter.notifyDataSetChanged();
    }

    private void setAnimation() {
        for (int i=0;i<listImage.length;i++){
            ImageView imageView= new ImageView(getContext());
            imageView.setImageResource(listImage[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            animator.addView(imageView);
        }

        final Animation in = new AnimationUtils().loadAnimation(getContext(),R.anim.in_right);
        Animation out = new AnimationUtils().loadAnimation(getContext(),R.anim.out_left);
        animator.setInAnimation(in);
        animator.setOutAnimation(out);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                animator.showNext();
                handler.postDelayed(this,2000);
                if (index>3) index=0;
                //dotes(index);
                index++;

            }
        },2000);

    }

    @Override
    public void setOnClickItem(Item item, ClothesAdapter.ClothesViewHolder holder) {
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

    }

    @Override
    public void onClickAllItem(String item, int position ) {
        Intent intent= new Intent( getContext(), SaleActivity.class);
        intent.putExtra("image",item);
        intent.putExtra("position",position);
        intent.putExtra("fullItem", (Serializable) mItems);
        startActivity(intent);
    }
}
