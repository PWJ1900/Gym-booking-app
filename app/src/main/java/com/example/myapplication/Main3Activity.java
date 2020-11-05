package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main3Activity extends AppCompatActivity {//此为场地选择activity
    private Button btthis;
    private RadioButton radio1;
    private RadioButton radio2;
    private RadioButton radio3;
    private RadioButton radio4;
    private Spinner sp1;
    private Spinner sp2;
    private String str1;
    private String str2;
    private String usehttp = "http://192.168.1.5:80/demo/";
    private String usehttp2 = "http://192.168.1.5:80/returnvtnumber";
    private Request request;
    private Request request2;
    private boolean pd = false;
    private TextView retext;
    private int num = 0;
    private String useid;
    private String no;
    private int nouse;
    private Integer abc2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btthis = (Button)findViewById(R.id.btthis);//提交按钮
        radio1 = (RadioButton)findViewById(R.id.radio1);
        radio2 = (RadioButton)findViewById(R.id.radio2);
        radio3 = (RadioButton)findViewById(R.id.radio3);
        radio4 = (RadioButton)findViewById(R.id.radio4);
        sp1 = (Spinner)findViewById(R.id.sp1);
        sp2 = (Spinner)findViewById(R.id.sp2);
        retext = (TextView)findViewById(R.id.retext);
        final AlertDialog.Builder dialog1 = new AlertDialog.Builder(this);
        Intent intent = getIntent();
        useid = intent.getStringExtra("useid");
        Log.d("Main3Activity",useid);//此处更改用来判断是否为用户传值
        btthis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean Pradio1 = radio1.isChecked();
                boolean Pradio2 = radio2.isChecked();
                boolean Pradio3 = radio3.isChecked();
                boolean Pradio4 = radio4.isChecked();
                str1 = (String) sp1.getSelectedItem();
                str2 = (String) sp2.getSelectedItem();
                OkHttpClient okHttpClient = new OkHttpClient();//使用Okhttp需注意得线gradle在在mainfest文件里改网络配置
                Request.Builder builder = new Request.Builder();
                if(Pradio1){//pd用来判断是否提交
                    request = builder.get().url(usehttp+"?IDcard="+useid+"&&username="+radio1.getText().toString()+"&&arrivetime="+str1+"&&leavetime="+str2).build();//str1+为时间
                    num++;
                    pd = true;}
                else if(Pradio2){
                    request = builder.get().url(usehttp+"?IDcard="+useid+"&&username="+radio2.getText().toString()+"&&arrivetime="+str1+"&&leavetime="+str2).build();
                    num++;
                    pd = true;}
                else if(Pradio3){
                    request = builder.get().url(usehttp+"?IDcard="+useid+"&&username="+radio3.getText().toString()+"&&arrivetime="+str1+"&&leavetime="+str2).build();
                    num++;
                    pd = true;}
                else if(Pradio4){
                    request = builder.get().url(usehttp+"?IDcard="+useid+"&&username="+radio4.getText().toString()+"&&arrivetime="+str1+"&&leavetime="+str2).build();
                    num++;
                    pd = true;}
                if (num>2){
                    dialog1.setTitle("提示！");
                    dialog1.setMessage("抱歉！您的选择次数已经大于两次！不能再预约");
                    dialog1.setNegativeButton("返回", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();
                    pd = false;


                }






//                if(nouse>10){
//                    retext.setText("本月已经违规无法预约！");
//                    pd = false;
//                }
//                else if((!Pradio1)&&(!Pradio2)&&(!Pradio3)&&(!Pradio4)){
//                    request = builder.get().url("").build();
//                    dialog1.setTitle("提示！");
//                    dialog1.setMessage("请先选择场地");
//                    dialog1.setNegativeButton("返回", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//
//                        }
//                    }).show();
//
//                }
            if(pd){
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {

                    }

                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                        final String res = response.body().string();
                        final Integer abc = Integer.parseInt(res);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(abc>40){//人数四十人封顶
                                    retext.setText("抱歉！场地人数已满。");//
                                }
                                else{
                                    retext.setText("可以预约");
                                }

                            }
                        });
                    }
                });
            }else if(num<2){
                    dialog1.setTitle("提示！");
                    dialog1.setMessage("请先选择场地");
                    dialog1.setNegativeButton("返回", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();


            }

            }





        });
    }


    public void wato(View view) {
        Intent intent = new Intent(Main3Activity.this,TestActivity.class);
        intent.putExtra("useid",useid);
        startActivity(intent);
    }
}
