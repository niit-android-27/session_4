package com.luan.myapp.session_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class ActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*String name=getIntent().getStringExtra("name");
        Bundle bundle =getIntent().getBundleExtra("test");
        int age = bundle.getInt("age");
        String name2 = bundle.getString("name");
        String phone=bundle.getString("phone");
        Log.e("ActivityTwo","Du lieu lay ra la "+name);
        Log.e("ActivityTwo","Du lieu lay ra bang bundle la "+name2+phone+age);

        //get object data
        User user=(User) getIntent().getSerializableExtra("user");
        Log.e("ActivityTwo","Du lieu object lay ra la "+user.getId()+user.getName());

        //get arraylist data
        ArrayList<User> listUser = (ArrayList<User>)getIntent().getSerializableExtra("list");
        Log.e("ActivityTwo",listUser.size()+"");
        setContentView(R.layout.activity_two);*/
        Intent intent = new Intent();
        intent.putExtra("data","1234567");
        setResult(1,intent);
        finish();
    }
}
