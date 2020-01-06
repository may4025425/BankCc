package com.example.cc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MoneyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);
        EditText edaccount = findViewById(R.id.account);
        Intent back = getIntent();
        String n = back.getStringExtra("money");
        edaccount.setText(n);


    }

    public void ok(View view){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}
