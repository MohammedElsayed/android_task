package com.example.mohamed.task2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    ImageView cuurent;
Bitmap bitmap;
EditText name;
EditText city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      cuurent=(ImageView)findViewById(R.id.image);
      name=(EditText) findViewById(R.id.name);
      city=(EditText)findViewById(R.id.City);
    }

    public  void  takeimage(View view){

        Intent intent=new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");


    startActivityForResult(intent,2);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        InputStream stream = null;
        if (resultCode == RESULT_OK) {
            if (requestCode == 2) {
                try {
                    // We need to recyle unused bitmaps
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                    stream = getContentResolver().openInputStream(data.getData());
                    bitmap = BitmapFactory.decodeStream(stream);

                    cuurent.setImageBitmap(bitmap);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (stream != null)
                        try {
                            stream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                }
                super.onActivityResult(requestCode, resultCode, data);
            }

        }
    }

    public  void back(View view){
        Intent intent=new Intent();

        Toast.makeText(getApplicationContext(),"welcome",Toast.LENGTH_SHORT).show();
         intent.putExtra("name",name.getText().toString());
         intent.putExtra("lastname",city.getText().toString());

        ByteArrayOutputStream bstream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,10,bstream);
        byte[] bytearray=bstream.toByteArray();
        intent.putExtra("image",bytearray);


         //intent.putExtra("image",bitmap);
        setResult(5,intent);
        finish();

    }
}
