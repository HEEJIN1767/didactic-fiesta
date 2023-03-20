package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Newpw extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpw);

        Button Newpwok;

        Newpwok = (Button)findViewById(R.id.newpwok);
        Newpwok.setOnClickListener(new View.OnClickListener() { //버튼 클릭 시, 화면 전환
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "정상적으로 변경되었습니다.", Toast.LENGTH_LONG);
            }
        });

    }


}