package com.wt.srichards.checkin;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.widget.Toast;

public class NotificationService extends Service {

	private static Timer timer = new Timer(); 
    private Context ctx;

    public IBinder onBind(Intent arg0) 
    {
          return null;
    }

    public void onCreate() 
    {
          super.onCreate();
          ctx = this; 
          startService();
    }

    private void startService()
    {           
        timer.scheduleAtFixedRate(new mainTask(), 0, 7200000);
    }

    private class mainTask extends TimerTask
    { 
        public void run() 
        {
        	Intent notifyIntent = new Intent(Intent.ACTION_MAIN);
        	notifyIntent.setClass(getApplicationContext(), MainActivity.class);
        }
    }    

    public void onDestroy() 
    {
          super.onDestroy();
          Toast.makeText(this, "Service Stopped ...", Toast.LENGTH_SHORT).show();
    }

    
}
