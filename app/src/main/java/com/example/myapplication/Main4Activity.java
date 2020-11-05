package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main4Activity extends AppCompatActivity {
    private Intent intent;
    private String useid;
    private TextView tx1;
    private Call calluse;
    private OkHttpClient okHttpClient = new OkHttpClient();
    private Request requestuse;
    private String usehttp3 = "http://192.168.1.5:80/violated";
    private int no;
    private int no2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        tx1 = (TextView)findViewById(R.id.textView5);
        intent = getIntent();
        useid = intent.getStringExtra("useid");
        Request.Builder builder3 = new Request.Builder();
        requestuse = builder3.get().url(usehttp3+"?IDcard="+useid).build();
        calluse = okHttpClient.newCall(requestuse);
        calluse.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                final String res = response.body().string();//这里需要把得到的字符串转化为数字然后比较

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        no = Integer.parseInt(res);
                        no2 = 10 - no;
                        tx1.setText("违反情况如下：已经违反预约"+no+"天，再违反预约"+no2+"天本月就无法预约");

                    }
                });

            }
        });

    }

    public void setit(View view) {
        intent = new Intent(Main4Activity.this,Main2Activity.class);
        intent.putExtra("useid",useid);
        startActivity(intent);
    }
}
