package com.luan.myapp.session_4;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    static final String TAG = "MainActivity";
    Button btnNext,btnCallPhone,btnOpenBrowser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"onCreate called");
        btnNext=(Button)findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Khoi tao intent
                Intent intent = new Intent(MainActivity.this,ActivityTwo.class);
                intent.putExtra("name","Nguyen Thanh Luan");
                Bundle bundle = new Bundle();
                bundle.putString("name","Nguyen Thanh Luan 2");
                bundle.putInt("age",26);
                bundle.putString("phone","08681201");

                //intent.putExtras(bundle);
                intent.putExtra("test",bundle);
                //activate activity 2

                //truyen object
                User user = new User();
                user.setId(1);
                user.setName("Luan");
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });

        btnCallPhone=(Button)findViewById(R.id.btnCallPhone);
        btnCallPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+847262767623"));
                startActivity(intent);
            }
        });

        btnOpenBrowser=(Button)findViewById(R.id.btnOpenBrowser);
        btnOpenBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com.vn"));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy called");
    }
}
