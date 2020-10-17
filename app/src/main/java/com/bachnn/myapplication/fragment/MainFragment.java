package com.bachnn.myapplication.fragment;

import android.content.Context;
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
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bachnn.myapplication.MainActivity;
import com.bachnn.myapplication.R;
import com.bachnn.myapplication.adapter.ClothesAdapter;
import com.bachnn.myapplication.listener.ItemListener;
import com.bachnn.myapplication.model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment implements ItemListener {
    private Toolbar mToolbar;
    private ViewAnimator animator;
    private int[] listImage= {R.drawable.ngoc_em,R.drawable.ngoctrinh1,
            R.drawable.ngoc_trinh_2,R.drawable.ngoc_trinh_3,R.drawable.ngoc_em_4};
    private Handler handler=new Handler();
    private int index =0;
    private ImageView view;
    private MainActivity mainActivity;

    private RecyclerView mRecyclerView;
    private ClothesAdapter mClothAdapter;
    List<Item> mItems;

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
        return view;
    }

    private void initData() {
        mItems.clear();
        //String mID, String mName, String mDescription, String mImage, String mPrice, String mSale, boolean mIsSale, String mType
        mItems.add(new Item("123","Áo Đông","Quần áo ok",
                "http://4.bp.blogspot.com/-2L-Os1Bz4AQ/USnVfFCU-FI/AAAAAAAAGUE/UneC1iu257A/s1600/Ngoc+Trinh1-1.jpg","100000","20%",false,"1"));
        mItems.add(new Item("124","Áo Đông","Quần áo ok",
                "https://1.bp.blogspot.com/-hMy1dxmbeCk/UTQG9Gbx1EI/AAAAAAAAHsY/vApdBWaPaYo/s1600/Ngoc+Trinh1-1.jpg","100000","20%",false,"1"));
        mItems.add(new Item("125","Áo Đông","Quần áo ok",
                "https://tse1.mm.bing.net/th?id=OIP.MVs_p_pgwOCZ2ywLduqxjAHaGe&pid=Api&P=0&w=198&h=174","100000","20%",false,"1"));
        mItems.add(new Item("126","Áo Đông","Quần áo ok",
                "https://1.bp.blogspot.com/-Ge5jflpbh4A/XfYzpRcDI0I/AAAAAAAAKO0/StHJH8RgJYAFkTyCxqNyxOD8NYyHuaQ5ACNcBGAsYHQ/s1600/ngoctrinh89_72234377_582568925815762_2478121002501163242_n.jpg","100000","20%",false,"1"));
        mItems.add(new Item("127","Áo Đông","Quần áo ok",
                "https://s-media-cache-ak0.pinimg.com/736x/a5/b9/6a/a5b96a54412532d1cbb79bcf4670f37b.jpg","100000","20%",false,"1"));
        mItems.add(new Item("128","Áo Đông","Quần áo ok",
                "https://eceleb-gossip.com/wp-content/uploads/2019/06/Ngoc-Trinh-net-worth.jpg","100000","20%",false,"1"));
        mItems.add(new Item("129","Áo Đông","Quần áo ok",
                "https://hotgirlvietdepnhat.files.wordpress.com/2013/07/hinh-anh-ngoc-trinh20.jpg?w=604","100000","20%",false,"1"));
        mItems.add(new Item("130","Áo Đông","Quần áo ok",
                "https://1.bp.blogspot.com/-bUpPqdtKQpo/UTQQs5gwvdI/AAAAAAAAHyY/pB8pzg12RTg/s1600/Ngoc+Trinh4-10.jpg","100000","20%",false,"1"));
        mItems.add(new Item("131","Áo Đông","Quần áo ok",
                "https://ilarge.lisimg.com/image/4777223/740full-ngoc-trinh.jpg","100000","20%",false,"1"));
        mItems.add(new Item("132","Áo Đông","Quần áo ok",
                "https://3.bp.blogspot.com/-Wy70krMpmgo/US2kgr5P_0I/AAAAAAAAG-U/qweNyIqmiiY/s1600/Ngoc+Trinh1-1.jpg","100000","20%",false,"1"));
        mItems.add(new Item("133","Áo Đông","Quần áo ok",
                "https://wakeupboy.com/photos/03/Ngoc-Trinh-01.jpg","100000","20%",false,"1"));
        mItems.add(new Item("134","Áo Đông","Quần áo ok",
                "https://2.bp.blogspot.com/-zwRFdNTTgIA/UTQHsZs8UsI/AAAAAAAAHtQ/4MANWvTtNQQ/s1600/Ngoc+Trinh2-3.jpg","100000","20%",false,"1"));
        mItems.add(new Item("135","Áo Đông","Quần áo ok",
                "http://4.bp.blogspot.com/-_FwF_YFT8AM/Ubfo8bMKrSI/AAAAAAAAKjo/mp4GzlolBvk/s1600/Ngoc+Trinh1-8.jpg","100000","20%",false,"1"));
        mItems.add(new Item("136","Áo Đông","Quần áo ok",
                "http://iv1.lisimg.com/image/6656173/500full-ngoc-trinh.jpg","100000","20%",false,"1"));
        mItems.add(new Item("137","Áo Đông","Quần áo ok",
                "https://ilarge.lisimg.com/image/11600386/740full-ngoc-trinh.jpg","100000","20%",false,"1"));

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
    public void setOnClickItem(Item item) {

    }
}
