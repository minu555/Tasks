package com.example.networkstatus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class Networkstatus extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            if(isOnline(context)){
                Toast.makeText(context,"NETWORK CONNECTED",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context," NO NETWORK CONNECTION",Toast.LENGTH_SHORT).show();
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }

    }
    public boolean isOnline(Context context){
        try {
            ConnectivityManager connectivityManager=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
            return (networkInfo!=null&&networkInfo.isConnected());


        }catch (NullPointerException e){
            e.printStackTrace();
            return false;

        }
    }
}