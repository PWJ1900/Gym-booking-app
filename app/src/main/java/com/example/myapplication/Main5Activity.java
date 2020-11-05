package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main5Activity extends AppCompatActivity {
    private Button btinsert;
    private MyOpenHelper oh;
    private SQLiteDatabase db;
    private EditText insert1;
    private EditText insert2;
    private Intent intent;
    private Boolean define = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        final AlertDialog.Builder dialog2 = new AlertDialog.Builder(this);
        btinsert = (Button)findViewById(R.id.btinsert);
        insert1 = (EditText)findViewById(R.id.insert1);
        insert2 = (EditText)findViewById(R.id.insert2);
        oh = new MyOpenHelper(this);
        db = oh.getWritableDatabase();

        btinsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = db.rawQuery("select id from student",null);
                while(cursor.moveToNext()) {
                    String Id = cursor.getString(cursor.getColumnIndex("id"));
                    if(insert1.getText().toString().equals(Id)){
                        define = true;
                    }


                }
                if(define == true){
                    db.execSQL("update student set password =?where id=?",new Object[]{insert2.getText(),insert1.getText()});
                    intent = new Intent(Main5Activity.this, TestActivity.class);
                    startActivityForResult(intent, 1);
                    finish();}
                   else{ dialog2.setTitle("提示");
                    dialog2.setMessage("抱歉！您还不是会员，无法注册！");
                    dialog2.setPositiveButton("返回", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            intent = new Intent(Main5Activity.this, MainActivity.class);
                            startActivityForResult(intent, 1);
                            finish();

                        }
                    }).show();}

            }
        });



    }

    public void back(View view) {
        intent = new Intent(Main5Activity.this, MainActivity.class);
        startActivityForResult(intent, 1);
        finish();



    }
}
