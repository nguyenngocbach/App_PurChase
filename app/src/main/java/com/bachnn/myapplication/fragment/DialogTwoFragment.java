package com.bachnn.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bachnn.myapplication.R;

public class DialogTwoFragment  extends Fragment {
    private ImageView imgMain;
    private TextView nameItem, priceItem, totalPrice;
    private EditText edtTotal;
    private Button btnDecrease, btnIncrease, btnCancel, btnNextSteps;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.dialog_two,container,false);
        imgMain = view.findViewById(R.id.img_dialog);
        nameItem = view.findViewById(R.id.name_item_pick);
        priceItem = view.findViewById(R.id.item_price);
        totalPrice = view.findViewById(R.id.total_price);
        edtTotal = view.findViewById(R.id.edt_total);
        btnDecrease = view.findViewById(R.id.btn_decrease);
        btnIncrease = view.findViewById(R.id.btn_increase);
        btnCancel = view.findViewById(R.id.btn_cancel);
        btnNextSteps = view.findViewById(R.id.btn_next_steps);

        //Hiep
        int total= Integer.parseInt(totalPrice.getText().toString());
        totalPrice.setText(total*100000);

        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int total= Integer.parseInt(totalPrice.getText().toString());
                total++;
                totalPrice.setText(total*100000);
            }
        });

        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int total= Integer.parseInt(totalPrice.getText().toString());
                if (total!=0) total--;
                totalPrice.setText(total*100000);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnNextSteps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }

    public interface IDialogOneListener{
        void onCancel();
        void onNextFragment(String name , int total , int totalPrice);
    }
}
