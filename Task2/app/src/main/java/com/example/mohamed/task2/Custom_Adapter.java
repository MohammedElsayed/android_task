package com.example.mohamed.task2;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import java.util.ArrayList;

public class Custom_Adapter  extends ArrayAdapter<String> {
   Context context;
   ArrayList<String>F_N;
    ArrayList<String>L_N;
    ArrayList<Bitmap>images;



    public Custom_Adapter( Context context,ArrayList<String>F_N
            ,    ArrayList<String>L_N,    ArrayList<Bitmap>images


    ) {
        super(context, R.layout.custom_layout,F_N);

        this.context=context;
        this.F_N=F_N;
        this.L_N=L_N;
        this.images=images;

    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.custom_layout,parent,false);
        TextView f_n=(view).findViewById(R.id.first_name);
        TextView l_n=(view).findViewById(R.id.last_name);
        ImageView im=(view).findViewById(R.id.imageinlist);
        Button btn=(view).findViewById(R.id.edit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             list t=new list();

            }
        });

       f_n.setText(F_N.get(position));
       l_n.setText(L_N.get(position));
       im.setImageBitmap(images.get(position));
     return  view;
    }









}
