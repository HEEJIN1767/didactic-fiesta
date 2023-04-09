package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Pwch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwch);

        Button Pwchok;

        Pwchok = (Button)findViewById(R.id.pwchok);

        Pwchok.setOnClickListener(new View.OnClickListener() { //버튼 클릭 시, 화면 전환
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(getApplicationContext(),Newpw.class);
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