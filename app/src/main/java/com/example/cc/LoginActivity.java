package com.example.cc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    boolean isNext = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText prefusername = findViewById(R.id.username);
        SharedPreferences setting = getSharedPreferences("atm",MODE_PRIVATE);
        prefusername.setText(setting.getString("PREF_USERNAME",""));
         final Switch sw = findViewById(R.id.sw);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isNext = isChecked ;
                TextView idenglish = findViewById(R.id.idenglish);
                TextView pwenglish = findViewById(R.id.pwenglish);
                sw.setText(isChecked ? "Chinese" : "英文");
                idenglish.setText(isChecked ? "ID" : "帳號");
                pwenglish.setText(isChecked ? "PASSWORD" : "密碼");
            }
        });

    }
    public void login(View view){
        EditText edusername = findViewById(R.id.username);
        EditText edpassword = findViewById(R.id.password);
        String username = edusername.getText().toString();
        String password = edpassword.getText().toString();
        if("may".equals(username) && "1234".equals(password)) {
            Intent intent = getIntent();
            intent.putExtra("username",username);
            intent.putExtra("password",password);
            setResult(RESULT_OK,intent);

            SharedPreferences setting = getSharedPreferences("atm",MODE_PRIVATE);
            setting.edit()
                    .putString("PREF_USERNAME",username)
                    .apply();
            Toast.makeText(this,"登入成功",Toast.LENGTH_LONG).show();

            Intent intent2 = new Intent(this,CreateUserActivity.class);
            startActivity(intent2);
        }else {
            new AlertDialog.Builder(this)
                    .setTitle("登入訊息")
                    .setMessage("登入失敗")
                    .setPositiveButton("ok",null)
                    .show();
        }
    }
}
////            String user = "may";
////            SharedPreferences pref = getSharedPreferences("test",MODE_PRIVATE);
////            pref.edit()//呼叫edit()方法取得Editor物件
////                    .putString("USER",user)//開始新增三筆資料
////                    .putInt("STAGE",3)
////                    .putFloat("HP",98.3f)
////                    .commit();//最後將三筆資料寫入設定檔
//
//            String userid = getSharedPreferences("test",MODE_PRIVATE).getString("USER","");
////先取得SharedPreferences 物件
////取得標籤"USER"的設定值，