package com.luan.myapp.session_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityEditUser extends AppCompatActivity {
    public static final int RESUL_OK = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        final int id = getIntent().getIntExtra("id",0);
        final String name = getIntent().getStringExtra("name");

        final EditText edtId = (EditText)  findViewById(R.id.edIdUser);
        final EditText edtName = (EditText)  findViewById(R.id.edName);

        edtId.setText(id+"");
        edtName.setText(name);

        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("id",edtId.getText().toString());
                intent.putExtra("name",edtName.getText().toString());
                setResult(RESUL_OK,intent);
                finish();
            }
        });
    }
}
