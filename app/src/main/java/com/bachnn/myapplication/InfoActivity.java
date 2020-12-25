package com.bachnn.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bachnn.myapplication.adapter.ItemPersonallyAdapter;
import com.bachnn.myapplication.database.DatabaseManager;
import com.bachnn.myapplication.model.Customer;
import com.bachnn.myapplication.model.Item;
import com.bumptech.glide.Glide;

public class InfoActivity extends AppCompatActivity {

    private Item mItem;
    private ImageView imageView;
    private TextView nameItem;
    private TextView description;
    private TextView price;
    private EditText edtTotal;
    private EditText edtNameCustomer;
    private EditText edtAddressCustomer;
    private EditText edtSDTCustomer;
    private EditText edtEmailCustomer;
    private Button btnCancel;
    private Button btnOK;

    private DatabaseManager mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Intent intent = getIntent();
        mItem = (Item) intent.getSerializableExtra("Purchase");
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
        btnOK = findViewById(R.id.btn_order);

        Glide.with(this).load(mItem.getmImage()).placeholder(R.drawable.ngoc_em).into(imageView);
        nameItem.setText(mItem.getmName());
        description.setText(mItem.getmDescription());
        price.setText(mItem.getmPrice());

        mDatabase = DatabaseManager.getInstance(this);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String total = edtTotal.getText().toString();
                if (Integer.parseInt(total)<0) {
                    Toast.makeText(InfoActivity.this, "Vui long nhận lại thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                //String mID, String mName, String mDescription, String mImage, String mPrice, String mSale, boolean mIsSale, int mType
                mDatabase.addItem(mItem);
                String name = edtNameCustomer.getText().toString();
                String address = edtAddressCustomer.getText().toString();
                String sdt = edtSDTCustomer.getText().toString();
                String email = edtEmailCustomer.getText().toString();
                if (name.equals("") | address.equals("") | sdt.equals("") | email.equals("")) {
                    Toast.makeText(InfoActivity.this, "Vui long nhận lại thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                long is = mDatabase.addCustomer(new Customer(mItem.getmID(),edtNameCustomer.getText().toString(),edtAddressCustomer.getText().toString()
                ,edtSDTCustomer.getText().toString(),edtEmailCustomer.getText().toString()));
                if (is>0){
                    Toast.makeText(InfoActivity.this, "Mua Thành Công", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(InfoActivity.this, "Mua Thành Công", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}