package com.luan.myapp.session_4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityAddNewUser extends AppCompatActivity {
    public static final int RESULT_OK = 1;
    EditText edtId,edtName;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);
        edtId=(EditText)findViewById(R.id.edIdUser);
        edtName=(EditText)findViewById(R.id.edName);
        edtName.getText().toString();
        Button btnSave=(Button)findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = edtId.getText().toString();
                String name = edtName.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("id",id);
                intent.putExtra("name",name);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
