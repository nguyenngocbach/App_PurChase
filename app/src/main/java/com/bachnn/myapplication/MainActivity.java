package com.bachnn.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewAnimator;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ViewAnimator animator;
    private int[] listImage= {R.drawable.ngoc_em,R.drawable.ngoctrinh1,
            R.drawable.ngoc_trinh_2,R.drawable.ngoc_trinh_3,R.drawable.ngoc_em_4};
    private Handler handler=new Handler();
    private int index =0;
    private ImageView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animator= findViewById(R.id.icon_lable);
        setAnimation();
        mToolbar= findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
    }

    
    private void setAnimation() {
        for (int i=0;i<listImage.length;i++){
            ImageView imageView= new ImageView(this);
            imageView.setImageResource(listImage[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            animator.addView(imageView);
        }

        final Animation in = new AnimationUtils().loadAnimation(this,R.anim.in_right);
        Animation out = new AnimationUtils().loadAnimation(this,R.anim.out_left);
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
}