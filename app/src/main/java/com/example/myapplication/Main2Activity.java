package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static java.lang.Integer.parseInt;

public class Main2Activity extends AppCompatActivity{//此为选择activity
    private TextView tx1;
    private TextView tx2;
    private TextView tx3;
    private TextView tx4;
    private MyOpenHelper oh;
    private SQLiteDatabase db;
    private String useid;
    private String no;
    private Intent intent;
    private String name;
    private OkHttpClient okHttpClient = new OkHttpClient();
    private Request request1;
    private Request request2;
    private Request request3;
    private String usehttp1 = "http://192.168.1.5:80/appointedplace";
    private String usehttp2 = "http://192.168.1.5:80/appointedtime";
    private Call call1;
    private Call call2;
    private Call call3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tx1 = (TextView)this.findViewById(R.id.tx1);
        tx2 = (TextView)this.findViewById(R.id.textView6);//判断是否已预约
        tx3 = (TextView)this.findViewById(R.id.textView8);
        tx4 = (TextView)this.findViewById(R.id.textView7);




        intent = getIntent();
        useid = intent.getStringExtra("useid");


        Request.Builder builder = new Request.Builder();//预约返回
       request1 = builder.get().url(usehttp1+"?useid="+useid).build();
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
                        tx3.setText(res);

                    }
                });
            }
        });

        Request.Builder builder2 = new Request.Builder();//预约返回
        request2 = builder2.get().url(usehttp2+"?useid="+useid).build();
        call2 = okHttpClient.newCall(request2);
        call2.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                final String res = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tx4.setText(res);

                    }
                });
            }
        });




        oh = new MyOpenHelper(this);
        db = oh.getReadableDatabase();
        Cursor cursor = db.rawQuery("select id,password,phonenumber,name from student where id="+"'"+useid+"'",null);
        while(cursor.moveToNext()){
            name = cursor.getString(cursor.getColumnIndex("name"));}

        tx1.setText(name+"先生您好，您的预约情况如下");
    }


    public void stepto(View view) {

        intent = new Intent(Main2Activity.this,TestActivity.class);
        intent.putExtra("useid",useid);
        startActivity(intent);


    }

    public void display(View view) {
        tx2.setText("预约规则如下：1.人数满40则人满无法预约2.一天只有两次预约的机会且一次只能预约一个场地3.预约完了需到健身房处打卡");
    }


    public void usebt3(View view) {
        intent = new Intent(Main2Activity.this,Main4Activity.class);
        intent.putExtra("useid",useid);
        startActivity(intent);

    }

    public void wwwto(View view) {
        intent = new Intent(Main2Activity.this,MainActivity.class);
        startActivity(intent);

    }
}
