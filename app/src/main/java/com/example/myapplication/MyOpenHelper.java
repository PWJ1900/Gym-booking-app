package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.ObjectStreamException;

public class MyOpenHelper extends SQLiteOpenHelper {
    private static String name = "hello.db";
    public MyOpenHelper(Context context){
        super(context,name,null,1);
    }
//public MyOpenHelper(Context context,String name, SQLiteDatabase.CursorFactory factory, int version){
//    super(context,name,factory,version);
//}

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("MainActivity","数据库创建成功");
        db.execSQL("create table if not exists student(_id integer primary key autoincrement,id integer,password integer,phonenumber varchar(40),name varchar(40))");
        db.execSQL("insert into student (id,password,phonenumber,name)values(?,?,?,?)",new Object[]{12111,12344,"17706273627","王志金"});
        db.execSQL("insert into student (id,password,phonenumber,name)values(?,?,?,?)",new Object[]{12113,12444,"18752886067","张小明"});
        db.execSQL("insert into student (id,password,phonenumber,name)values(?,?,?,?)",new Object[]{12112,12333,"13928382833","吴红"});
        db.execSQL("insert into student (id,password,phonenumber,name)values(?,?,?,?)",new Object[]{12114,12222,"13826372723","邓芳"});

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("MainActivity","数据库升级成功");

    }
}
