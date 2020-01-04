package com.example.cc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CreateUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
    }
    public void next(View view){
        TextView ednickname = findViewById(R.id.nickname);
        String nickname = ednickname.getText().toString();
        if(nickname.isEmpty()){
            new AlertDialog.Builder(this)
                    .setTitle("atm")
                    .setMessage("暱稱不可為空白")
                    .setPositiveButton("ok",null)
                    .show();
        }else {
            getSharedPreferences("atm",MODE_PRIVATE)
                    .edit()
                    .putString("nickname",nickname)
                    .apply();
            Intent intent = new Intent(this,AgeActivity.class);
            startActivity(intent);
        }
    }
}
