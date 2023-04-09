package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Mypage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        Button Re,Mylist,Review,Change;

        Re = (Button)findViewById(R.id.re);

        Re.setOnClickListener(new View.OnClickListener() { //버튼 클릭 시, 화면 전환
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(getApplicationContext(),Checklist.class);
                startActivity(Intent);
            }
        });


        Mylist = (Button)findViewById(R.id.mylist);

        Mylist.setOnClickListener(new View.OnClickListener() { //버튼 클릭 시, 화면 전환
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(getApplicationContext(),Posting.class);
                startActivity(Intent);
            }
        });
        Review = (Button)findViewById(R.id.review);

        Review.setOnClickListener(new View.OnClickListener() { //버튼 클릭 시, 화면 전환
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(getApplicationContext(),Review.class);
                startActivity(Intent);
            }
        });
        Change = (Button)findViewById(R.id.change);

        Change.setOnClickListener(new View.OnClickListener() { //버튼 클릭 시, 화면 전환
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(getApplicationContext(),Change.class);
                startActivity(Intent);
            }
        });
        ImageButton Home;

        Home = (ImageButton)findViewById(R.id.home);
        Home.setOnClickListener(new View.OnClickListener() { //버튼 클릭 시, 화면 전환
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(getApplicationContext(),Login.class);
                startActivity(Intent);
            }
        });
    }
}