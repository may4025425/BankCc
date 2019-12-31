package com.example.cc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void login(View view){
        EditText edusername = findViewById(R.id.username);
        EditText edpassword = findViewById(R.id.password);
        String username = edusername.getText().toString();
        String password = edpassword.getText().toString();
        //省成兩行

        if("may".equals(username) && "1234".equals(password)) {
            Toast.makeText(this,"登入成功",Toast.LENGTH_LONG).show();
            finish();
        }else {
            new AlertDialog.Builder(this)
                    .setTitle("登入訊息")
                    .setMessage("登入失敗")
                    .setPositiveButton("ok",null)
                    .show();
        }
    }
}
