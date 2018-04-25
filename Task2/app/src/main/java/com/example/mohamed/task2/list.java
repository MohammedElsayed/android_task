package com.example.mohamed.task2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class list extends AppCompatActivity {
ImageView image;
TextView textView,test;

    ArrayList<String> fn=new ArrayList<String>();
    ArrayList<String> ln=new ArrayList<String>();
     ArrayList<Bitmap> images=new ArrayList<Bitmap>();
  ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
  listView=(ListView)findViewById(R.id.list);
  test=(TextView)findViewById(R.id.test);
        Toast.makeText(getApplicationContext(),"create",Toast.LENGTH_SHORT).show();


    }

    public  void add(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivityForResult(intent,5);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult  (requestCode, resultCode, data);
        if (requestCode==5){



            fn.add(data.getStringExtra("lastname"));
             ln.add(data.getStringExtra("name"));

            Custom_Adapter custom_adapter=new Custom_Adapter(this,fn,ln,images);
            listView.setAdapter(custom_adapter);

            Toast.makeText(getApplicationContext(),"result",Toast.LENGTH_SHORT).show();
          byte[] bytearr=data.getByteArrayExtra("image");
            Bitmap img= BitmapFactory.decodeByteArray(bytearr,0,bytearr.length);
            images.add(img);
        }

    }
}
