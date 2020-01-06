package com.example.cc;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final int RC_LOGIN = 1;
    boolean login = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!login){
            Intent intent = new Intent(this,LoginActivity.class);
            startActivityForResult(intent,RC_LOGIN);
        }else{
            finish();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_LOGIN){
            if(resultCode == RESULT_OK){

                String nickname = getSharedPreferences("atm",MODE_PRIVATE)
                        .getString("nickname",null);
                int age = getSharedPreferences("atm",MODE_PRIVATE)
                        .getInt("age",0);
                String gender = getSharedPreferences("atm",MODE_PRIVATE)
                        .getString("gender",null);
                if(nickname == null && age == 0 && gender == null){
                    Intent intent = new Intent(this,CreateUserActivity.class);
                    startActivity(intent);
            }else{
                    finish();
                }
            }
        }
    }
    public void ok(View view){
       EditText edmoney = findViewById(R.id.money);
       String money = edmoney.getText().toString();
        Intent back = new Intent(this,MoneyActivity.class);
        back.putExtra("money",money);
        startActivity(back);
    }
}
//    String username = data.getStringExtra("username");
//    String password = data.getStringExtra("password");
//                Log.d("main","登入使用者帳號：" + username);
//                Log.d("main","登入使用者密碼：" + password);