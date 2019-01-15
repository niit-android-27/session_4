package com.luan.myapp.session_4;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<User> {
    Context context;
    ArrayList<User> users = new ArrayList<User>();
    int resources;
    LayoutInflater inflater;
    public MyAdapter(@NonNull Context context, int resource,ArrayList<User> users) {
        super(context, resource,users);
        this.context=context;
        this.users = users;
        this.resources=resource;
        this.inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            convertView= inflater.inflate(this.resources, parent, false);
        }
        TextView tvId = (TextView)convertView.findViewById(R.id.tvHi);
        TextView tvName = (TextView)convertView.findViewById(R.id.tvUserName);
        tvId.setText(getItem(position).getId()+"");
        tvName.setText(getItem(position).getName());
        return convertView;
    }
}
