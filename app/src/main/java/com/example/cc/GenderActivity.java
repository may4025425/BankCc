package com.example.cc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
    }

    public void next(View view){
        EditText edgender = findViewById(R.id.gender);
        String gender = edgender.getText().toString();
        if(gender.isEmpty()){
            new AlertDialog.Builder(this)
                    .setTitle("atm")
                    .setMessage("性別欄位不可為空白")
                    .setPositiveButton("ok",null)
                    .show();
        }else {
            getSharedPreferences("atm",MODE_PRIVATE)
                    .edit()
                    .putString("gender",gender)
                    .apply();
            Intent intent = new Intent(this,MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        }
    }
    public void back(View view){
            finish();
    }
}
