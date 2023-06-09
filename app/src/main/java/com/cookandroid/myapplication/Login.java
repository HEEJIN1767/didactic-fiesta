package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Map;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageButton Hb;
        Hb = (ImageButton)findViewById(R.id.hb);
        Hb.setOnClickListener(new View.OnClickListener() { //버튼 클릭 시, 화면 전환
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(getApplicationContext(),Contents.class);
                startActivity(Intent);
            }
        });

        ImageButton Mypg;

        Mypg = (ImageButton)findViewById(R.id.mypg);
        Mypg.setOnClickListener(new View.OnClickListener() { //버튼 클릭 시, 화면 전환
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(getApplicationContext(),Mypage.class);
                startActivity(Intent);
            }
        });

        ImageButton Map;

        Map = (ImageButton)findViewById(R.id.map);
        Map.setOnClickListener(new View.OnClickListener() { //버튼 클릭 시, 화면 전환
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(getApplicationContext(),Myhos.class);
                startActivity(Intent);
            }
        });

        ImageButton Cklist;

        Cklist = (ImageButton)findViewById(R.id.cklist);
        Cklist.setOnClickListener(new View.OnClickListener() { //버튼 클릭 시, 화면 전환
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(getApplicationContext(),Checklist.class);
                startActivity(Intent);
            }
        });

        ImageButton Cm;

        Cm = (ImageButton)findViewById(R.id.cm);
        Cm.setOnClickListener(new View.OnClickListener() { //버튼 클릭 시, 화면 전환
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(getApplicationContext(),Community.class);
                startActivity(Intent);
            }
        });
    }
}