package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void arriveto(View view) {
        Intent intent = new Intent(register.this,Main5Activity.class);
        startActivityForResult(intent,1);


    }

    public void getto(View view) {
        Intent intent = new Intent(register.this,nomember.class);
        startActivityForResult(intent,1);
    }
}
