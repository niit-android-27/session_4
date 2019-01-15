package com.luan.myapp.session_4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityListUser extends AppCompatActivity {
    public static final int REQUEST_ADD_NEW_USER = 1;
    ArrayList<User> users =new ArrayList<>();
    MyAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        ListView lstView = (ListView)findViewById(R.id.lstUser);
         adapter = new MyAdapter(ActivityListUser.this,R.layout.item,users);
        lstView.setAdapter(adapter);

        Button btnAddNewUser = (Button)findViewById(R.id.btnAddNewUser);
        btnAddNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityListUser.this,ActivityAddNewUser.class);
                startActivityForResult(intent,REQUEST_ADD_NEW_USER);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_ADD_NEW_USER){
            //xu li lay data va show ra listview
            if(resultCode==ActivityAddNewUser.RESULT_OK){
                String id = data.getStringExtra("id");
                String name = data.getStringExtra("name");
                User user = new User();
                user.setName(name);
                user.setId(Integer.parseInt(id));
                users.add(user);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
