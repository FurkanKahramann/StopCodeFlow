package com.furkankahraman.waitcode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final int[] loop = {0};
        scheduler.scheduleAtFixedRate(new Runnable()
        {
            public void run()
            {
                Log.i("Log:","Stop 5 Seconds");
                loop[0]++;
                if (loop[0] == 3){
                    scheduler.shutdown();//Exit Scheduler
                }
            }

        }, 0, 5, TimeUnit.SECONDS);
    }
}
