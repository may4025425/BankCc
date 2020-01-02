package com.example.cc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
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

//            String user = "may";
//            SharedPreferences pref = getSharedPreferences("test",MODE_PRIVATE);
//            pref.edit()//呼叫edit()方法取得Editor物件
//                    .putString("USER",user)//開始新增三筆資料
//                    .putInt("STAGE",3)
//                    .putFloat("HP",98.3f)
//                    .commit();//最後將三筆資料寫入設定檔

            String userid = getSharedPreferences("test",MODE_PRIVATE).getString("USER","");
//先取得SharedPreferences 物件
//取得標籤"USER"的設定值，



            SharedPreferences setting = getSharedPreferences("atm", MODE_PRIVATE);
            setting.edit()//寫入資料
                    .putString("PREF_USERID", username).apply();;
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
