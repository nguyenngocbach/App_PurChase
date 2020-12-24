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
        mAllItem.add(new Item("123","Áo Đông","Quần áo ok",
                "http://4.bp.blogspot.com/-2L-Os1Bz4AQ/USnVfFCU-FI/AAAAAAAAGUE/UneC1iu257A/s1600/Ngoc+Trinh1-1.jpg","100000","20%",false,0));
        mAllItem.add(new Item("124","Áo Đông","Quần áo ok",
                "https://1.bp.blogspot.com/-hMy1dxmbeCk/UTQG9Gbx1EI/AAAAAAAAHsY/vApdBWaPaYo/s1600/Ngoc+Trinh1-1.jpg","100000","20%",true,1));
        mAllItem.add(new Item("125","Áo Đông","Quần áo ok",
                "https://tse1.mm.bing.net/th?id=OIP.MVs_p_pgwOCZ2ywLduqxjAHaGe&pid=Api&P=0&w=198&h=174","100000","20%",false,1));
        mAllItem.add(new Item("126","Áo Đông","Quần áo ok",
                "https://1.bp.blogspot.com/-Ge5jflpbh4A/XfYzpRcDI0I/AAAAAAAAKO0/StHJH8RgJYAFkTyCxqNyxOD8NYyHuaQ5ACNcBGAsYHQ/s1600/ngoctrinh89_72234377_582568925815762_2478121002501163242_n.jpg","100000","20%",false,0));
        mAllItem.add(new Item("127","Áo Đông","Quần áo ok",
                "https://s-media-cache-ak0.pinimg.com/736x/a5/b9/6a/a5b96a54412532d1cbb79bcf4670f37b.jpg","100000","20%",true,1));
        mAllItem.add(new Item("128","Áo Đông","Quần áo ok",
                "https://eceleb-gossip.com/wp-content/uploads/2019/06/Ngoc-Trinh-net-worth.jpg","100000","20%",false,1));
        mAllItem.add(new Item("129","Áo Đông","Quần áo ok",
                "https://hotgirlvietdepnhat.files.wordpress.com/2013/07/hinh-anh-ngoc-trinh20.jpg?w=604","100000","20%",true,1));
        mAllItem.add(new Item("130","Áo Đông","Quần áo ok",
                "https://1.bp.blogspot.com/-bUpPqdtKQpo/UTQQs5gwvdI/AAAAAAAAHyY/pB8pzg12RTg/s1600/Ngoc+Trinh4-10.jpg","100000","20%",false,0));
        mAllItem.add(new Item("131","Áo Đông","Quần áo ok",
                "https://ilarge.lisimg.com/image/4777223/740full-ngoc-trinh.jpg","100000","20%",false,0));
        mAllItem.add(new Item("132","Áo Đông","Quần áo ok",
                "https://3.bp.blogspot.com/-Wy70krMpmgo/US2kgr5P_0I/AAAAAAAAG-U/qweNyIqmiiY/s1600/Ngoc+Trinh1-1.jpg","100000","20%",true,1));
        mAllItem.add(new Item("133","Áo Đông","Quần áo ok",
                "https://wakeupboy.com/photos/03/Ngoc-Trinh-01.jpg","100000","20%",false,0));
        mAllItem.add(new Item("134","Áo Đông","Quần áo ok",
                "https://2.bp.blogspot.com/-zwRFdNTTgIA/UTQHsZs8UsI/AAAAAAAAHtQ/4MANWvTtNQQ/s1600/Ngoc+Trinh2-3.jpg","100000","20%",false,1));
        mAllItem.add(new Item("135","Áo Đông","Quần áo ok",
                "http://4.bp.blogspot.com/-_FwF_YFT8AM/Ubfo8bMKrSI/AAAAAAAAKjo/mp4GzlolBvk/s1600/Ngoc+Trinh1-8.jpg","100000","20%",true,0));
        mAllItem.add(new Item("136","Áo Đông","Quần áo ok",
                "http://iv1.lisimg.com/image/6656173/500full-ngoc-trinh.jpg","100000","20%",false,1));
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
