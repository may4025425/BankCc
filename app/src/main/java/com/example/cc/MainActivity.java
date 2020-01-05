package com.example.cc;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final int RC_LOGIN = 1;
    boolean login = false;
    private EditText edmoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edmoney = findViewById(R.id.money);
        if(!login){
            Intent intent = new Intent(this,LoginActivity.class);
            startActivityForResult(intent,RC_LOGIN);
            edmoney.getText().toString();
        }else{
            finish();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_LOGIN){
            if(resultCode == RESULT_OK){
//                String username = data.getStringExtra("LOGIN_USERNAME");
//                String password = data.getStringExtra("LOGIN_PASSWD");
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
        Intent back = new Intent(this,MoneyActivity.class);
        startActivity(back);
    }
}
