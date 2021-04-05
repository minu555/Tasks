package com.example.runonuithread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.message);
        // request to server
        //creating a new thread to send request
        new Thread(){
            @Override
            public void run() {
                // creating a delay to update the UI

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                UpdateUi();


            }
        }.start();


    }
    public void UpdateUi(){
        //update ui after getting response
       runOnUiThread(new Runnable() {
           @Override
           public void run() {

        textView.setText("hey it's minu");

           }
       });



    }
}

