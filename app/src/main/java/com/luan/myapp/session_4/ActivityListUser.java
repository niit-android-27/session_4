package com.luan.myapp.session_4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityListUser extends AppCompatActivity {
    public static final int REQUEST_ADD_NEW_USER = 1;
    public static final int REQUEST_EDIT_USER = 2;
    ArrayList<User> users =new ArrayList<>();
    MyAdapter adapter;
    int index;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);


        ListView lstView = (ListView)findViewById(R.id.lstUser);
         adapter = new MyAdapter(ActivityListUser.this,R.layout.item,users);
        lstView.setAdapter(adapter);
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ActivityListUser.this,ActivityEditUser.class);
                intent.putExtra("id",users.get(i).getId());
                intent.putExtra("name",users.get(i).getName());
                //intent.putExtra("index",users.get)
                index=i;
                startActivityForResult(intent,REQUEST_EDIT_USER);
            }
        });

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
            //xu li lay data va show ra listview
            switch (requestCode){
                case REQUEST_ADD_NEW_USER:
                    if(resultCode==ActivityAddNewUser.RESULT_OK) {
                        String id = data.getStringExtra("id");
                        String name = data.getStringExtra("name");
                        User user = new User();
                        user.setName(name);
                        user.setId(Integer.parseInt(id));
                        users.add(user);
                        adapter.notifyDataSetChanged();
                    }
                    break;

                case REQUEST_EDIT_USER:
                    if(resultCode==ActivityEditUser.RESUL_OK){
                        String id = data.getStringExtra("id");
                        String name = data.getStringExtra("name");
                        //int index = data.getIntExtra("index",0);
                        users.get(index).setId(Integer.parseInt(id));
                        users.get(index).setName(name);
                        Log.e("INDEX",index+"");
                        adapter.notifyDataSetChanged();
                    }
                    break;
            }

    }
}
