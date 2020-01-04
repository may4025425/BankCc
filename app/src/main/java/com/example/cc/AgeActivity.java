package com.example.cc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AgeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
    }
    public void next(View view){
        TextView edage = findViewById(R.id.gender);
        String age = edage.getText().toString();
        if(age.isEmpty()){
            new AlertDialog.Builder(this)
                    .setTitle("atm")
                    .setMessage("年齡欄位不可為空白")
                    .setPositiveButton("ok",null)
                    .show();
        }else {
            getSharedPreferences("atm",MODE_PRIVATE)
                    .edit()
                    .putString("age",age)
                    .apply();
            Intent intent = new Intent(this,GenderActivity.class);
            startActivity(intent);
        }
    }
    public void back(View view){
        finish();
    }
}
