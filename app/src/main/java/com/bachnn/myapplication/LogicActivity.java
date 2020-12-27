package com.bachnn.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bachnn.myapplication.database.DatabaseManager;
import com.bachnn.myapplication.model.USERNAME;

import java.util.List;

public class LogicActivity extends AppCompatActivity {

    public static USERNAME mUSER;
    private DatabaseManager manager;
    private EditText edtUserName;
    private EditText edtPassWord;
    private Button btnLogin;
    private List<USERNAME> mUSERNAMES;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logic);
        manager = DatabaseManager.getInstance(this);
        mUSERNAMES = manager.getListUser();
        edtUserName = findViewById(R.id.username);
        edtPassWord = findViewById(R.id.password);
        btnLogin = findViewById(R.id.login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName , passWord;
                userName = edtUserName.getText().toString();
                passWord = edtPassWord.getText().toString();
                Log.d("bachdz", mUSERNAMES.size()+""+ userName +"    "+ passWord);
                if (userName.equals("") || passWord.equals("")){
                    Toast.makeText(LogicActivity.this, "Đăng Nhập Thất Bại", Toast.LENGTH_SHORT).show();

                }
                for (int i = 0; i< mUSERNAMES.size(); i++){
                    if (userName.equals(mUSERNAMES.get(i).getmUsername()) && passWord.equals(mUSERNAMES.get(i).getmPassword())){
                        Intent intent= new Intent(LogicActivity.this, MainActivity.class);
                        mUSER = mUSERNAMES.get(i);
                        startActivity(intent);
                        return;
                    }
                }
                Toast.makeText(LogicActivity.this, "Đăng Nhập Thất Bại", Toast.LENGTH_SHORT).show();
            }
        });

    }
}