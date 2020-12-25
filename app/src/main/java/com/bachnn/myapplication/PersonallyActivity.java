package com.bachnn.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bachnn.myapplication.model.Customer;
import com.bachnn.myapplication.model.Item;
import com.bumptech.glide.Glide;

public class PersonallyActivity extends AppCompatActivity {

    private Item mItem;
    private Customer mCustomer;
    private ImageView imageView;
    private TextView nameItem;
    private TextView description;
    private TextView price;
    private TextView edtTotal;
    private TextView edtNameCustomer;
    private TextView edtAddressCustomer;
    private TextView edtSDTCustomer;
    private TextView edtEmailCustomer;
    private Button btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personally);
        Intent intent = getIntent();
        mItem = (Item) intent.getSerializableExtra("personally");
        mCustomer = (Customer) intent.getSerializableExtra("customer");
        imageView = findViewById(R.id.imageView);
        nameItem = findViewById(R.id.name_item);
        description = findViewById(R.id.txt_description);
        price = findViewById(R.id.item_price);
        edtTotal = findViewById(R.id.edt_total);
        edtNameCustomer = findViewById(R.id.name_customer);
        edtAddressCustomer = findViewById(R.id.address_customer);
        edtSDTCustomer = findViewById(R.id.sdt_customer);
        edtEmailCustomer = findViewById(R.id.email_customer);
        btnCancel = findViewById(R.id.btn_cancel);

        Glide.with(this).load(mItem.getmImage()).placeholder(R.drawable.ngoc_em).into(imageView);
        nameItem.setText(mItem.getmName());
        description.setText(mItem.getmDescription());
        price.setText(mItem.getmPrice());
        edtTotal.setText(1+"");
        edtNameCustomer.setText(mCustomer.getmNameCustomer());
        edtAddressCustomer.setText(mCustomer.getmAddressCustomer());
        edtSDTCustomer.setText(mCustomer.getmSDTCustomer());
        edtEmailCustomer.setText(mCustomer.getmEmailCustomer());
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}