package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getAppKeyHash();

        Button Join,Login;

        Join = (Button)findViewById(R.id.join);

        Join.setOnClickListener(new View.OnClickListener() { //버튼 클릭 시, 화면 전환
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(getApplicationContext(),JoinActivity.class);
                startActivity(Intent);
            }
        });
        Login = (Button)findViewById(R.id.login);

        Login.setOnClickListener(new View.OnClickListener() { //버튼 클릭 시, 화면 전환
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(getApplicationContext(),Login.class);
                startActivity(Intent);
            }
        });

    }

   /* private void getAppKeyHash() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(),PackageManager.GET_SIGNATURES);

            for (Signature signature : info.signatures) {

                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = new String(Base64.encode(md.digest(), 0));
                Log.e("Hash Key", something);
            }

                } catch (Exception e) {
                    Log.e("name not found",e.toString());
                }
            }
            */
        }
