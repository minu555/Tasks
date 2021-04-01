package com.example.async;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.image);
        button=findViewById(R.id.button);


    }
    public void downloadImage(View view) throws ExecutionException,InterruptedException {
         Imagedownload imagedownload=new Imagedownload();
         Bitmap bitmap=imagedownload.execute("https://tse4.mm.bing.net/th?id=OIP.v_4dpZJFv133uQmWXcY-lwHaNL&pid=Api&P=0&w=300&h=300").get();
        imageView.setImageBitmap(bitmap);
    }
    public class Imagedownload extends AsyncTask<String,Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... strings) {

            try {
                URL url=new URL(strings[0]);
                HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                connection.connect();
                InputStream inputStream=connection.getInputStream();
                return BitmapFactory.decodeStream(inputStream);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}