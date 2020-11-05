package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class nomember extends AppCompatActivity {
    private OkHttpClient okHttpClient;
    private String usehttp = "http://192.168.1.5:80/getphonenumber/";
    private EditText editget;
    private EditText yzmdt;
    private Intent intent;
    private TextView usetext;
    private String res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nomember);
        editget = (EditText) findViewById(R.id.editget);
        yzmdt = (EditText) findViewById(R.id.yzmedt);
        usetext = (TextView)findViewById(R.id.usetext);
    }

    public void send(View view) {
        okHttpClient = new OkHttpClient();
        Request.Builder builder = new Request.Builder();
        Request request = builder.get().url(usehttp+"?phonenumber="+editget.getText()).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                res = response.body().string();



            }
        });



    }

    public void test(View view) {
        if(res.equals(yzmdt.getText().toString())){
            intent = new Intent(nomember.this,TestActivity.class);
//            startActivityForResult(intent,1);//此处需传送判别是否为用户的值
            intent.putExtra("useid",editget.getText().toString());
            startActivity(intent);

        }else{
            usetext.setText("抱歉验证码输入错误");
        }
    }
}
