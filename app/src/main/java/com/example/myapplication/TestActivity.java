
package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TestActivity extends AppCompatActivity {
    private ViewPager vager_one;
    private ArrayList<View> aList;
    private MyPagerAdapter myAdapter;
    private String usehttp = "http://192.168.1.5:80/pagereturn/";
    private TextView txuse2;
    private Intent intent;
    private Call call1;
    private Call call2;
    private Call call3;
    private Call call4;
    private TextView txtY;
    private TextView txtS;
    private TextView txtB;
    private TextView txtQ;
    private TextView txtchange;
    private OkHttpClient okHttpClient = new OkHttpClient();
    private Request request1;
    private Request request2;
    private Request request3;
    private Request request4;
    private String no;
    private String useid;//此为注册页面传来的值

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Request.Builder builder = new Request.Builder();
        request1 = builder.get().url(usehttp+"?Name=瑜伽房").build();
        request2 = builder.get().url(usehttp+"?Name=游泳馆").build();
        request3 = builder.get().url(usehttp+"?Name=篮球场").build();
        request4 = builder.get().url(usehttp+"?Name=器材室").build();

        call1 = okHttpClient.newCall(request1);
        call1.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                final String res = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                                        txtchange.setText("瑜伽房的人数："+res);

                    }
                });

            }
        });

        vager_one = (ViewPager)findViewById(R.id.vager_one);
        txuse2 = (TextView)findViewById(R.id.txuse2);
        txtchange = (TextView)findViewById(R.id.txtchange);
        aList = new ArrayList<View>();
        LayoutInflater li = getLayoutInflater();
        aList.add(li.inflate(R.layout.use1,null,false));
        aList.add(li.inflate(R.layout.use2,null,false));
        aList.add(li.inflate(R.layout.use3,null,false));
        aList.add(li.inflate(R.layout.use4,null,false));
        myAdapter = new MyPagerAdapter(aList);
        vager_one.setAdapter(myAdapter);
        vager_one.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0){
                    txtchange.setText("瑜伽房的人数：");
                    call1 = okHttpClient.newCall(request1);
                    call1.enqueue(new Callback() {
                        @Override
                        public void onFailure(@NotNull Call call, @NotNull IOException e) {

                        }

                        @Override
                        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                            final String res = response.body().string();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    txtchange.setText("瑜伽房的人数："+res);

                                }
                            });

                        }
                    });
                }
                if(position==1){
                    txtchange.setText("游泳馆的人数：");
                    call1 = okHttpClient.newCall(request2);
                    call1.enqueue(new Callback() {
                        @Override
                        public void onFailure(@NotNull Call call, @NotNull IOException e) {

                        }

                        @Override
                        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                            final String res = response.body().string();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    txtchange.setText("游泳馆的人数："+res);

                                }
                            });

                        }
                    });

                }
                if(position==2){
                    txtchange.setText("篮球场的人数：");
                    call1 = okHttpClient.newCall(request3);
                    call1.enqueue(new Callback() {
                        @Override
                        public void onFailure(@NotNull Call call, @NotNull IOException e) {

                        }

                        @Override
                        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                            final String res = response.body().string();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    txtchange.setText("篮球场的人数："+res);

                                }
                            });

                        }
                    });

                }
                if(position==3){
                    txtchange.setText("器材室的人数：");
                    call1 = okHttpClient.newCall(request4);
                    call1.enqueue(new Callback() {
                        @Override
                        public void onFailure(@NotNull Call call, @NotNull IOException e) {

                        }

                        @Override
                        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                            final String res = response.body().string();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    txtchange.setText("器材室的人数："+res);

                                }
                            });

                        }
                    });

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    public void appoint(View view) {
//        intent = new Intent(TestActivity.this,Main3Activity.class);
        intent = getIntent();
        useid = intent.getStringExtra("useid");
        intent = new Intent(TestActivity.this,Main3Activity.class);
        intent.putExtra("useid",useid);
        startActivity(intent);


    }

    public void exit(View view) {
//        android.os.Process.killProcess(android.os.Process.myPid());
        intent = getIntent();
        useid = intent.getStringExtra("useid");
        intent = new Intent(TestActivity.this,Main2Activity.class);
        intent.putExtra("useid",useid);
        startActivity(intent);
    }
}
