package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {//此为登录activity
    private MyOpenHelper oh;
    private SQLiteDatabase db;
    private ImageButton imagebt;
    private EditText editText;
    private EditText editText2;
    private boolean judge1 = false;
    private boolean judge2 = false;
    private SharedPreferences sp = null;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AlertDialog.Builder dialog1 = new AlertDialog.Builder(this);
        imagebt = this.findViewById(R.id.imageButton);
        editText = this.findViewById(R.id.editTextnum);
        editText2 = this.findViewById(R.id.editTextpassword);
        radioButton = this.findViewById(R.id.radioButton);
        oh = new MyOpenHelper(this);//数据库的调用
        db = oh.getReadableDatabase();





        sp = this.getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        editText.setText(sp.getString("editText",null));//设置存储
        editText2.setText(sp.getString("editText2",null));
        imagebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = db.rawQuery("select id,password from student",null);
                while(cursor.moveToNext()){
                    String Id = cursor.getString(cursor.getColumnIndex("id"));

                    if(editText.getText().toString().equals(Id)) {
                        judge1 =true;
                        String Password = cursor.getString(cursor.getColumnIndex("password"));
                        if ((editText2.getText().toString().equals(Password))) judge2 = true;

                    }
                    //判断密码

                }


                if(judge1==true){//账号改成数据库
                    if(judge2==true){//密码改成数据库

                                boolean CheckUse = radioButton.isChecked();
                                if(CheckUse){
                                    Editor editor = sp.edit();
                                    editor.putString("editText",editText.getText().toString());
                                    editor.putString("editText2",editText2.getText().toString());
                                    editor.commit();
                                }
                                else{
                                    Editor editor = sp.edit();
                                    editor.putString("editText",null);
                                    editor.putString("editText2",null);
                                    editor.commit();
                                }
                                Intent intent = new Intent(MainActivity.this,Main2Activity.class);//等滚动页面做完了还得还回来
                                intent.putExtra("useid",editText.getText().toString());
                                startActivity(intent);
                                finish();

                            }
                    else {
                        dialog1.setTitle("提示！");
                        dialog1.setMessage("密码输入错误或并未注册");
                        dialog1.setNegativeButton("返回", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {


                            }
                        }).show();

                    }

                }
                else{
                    dialog1.setTitle("提示！");
                    dialog1.setMessage("账号输入有误");
                    dialog1.setNegativeButton("返回", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();

                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==1){
            editText.setText("111");//项目没有完成测试密码的
        }
    }

    public void insert(View view){
        Intent intent = new Intent(MainActivity.this,register.class);
        startActivityForResult(intent,1);
        finish();


    }





}
