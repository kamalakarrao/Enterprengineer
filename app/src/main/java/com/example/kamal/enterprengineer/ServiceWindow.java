package com.example.kamal.enterprengineer;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by kamal on 22-11-2016.
 */

public class ServiceWindow extends Service {

    private WindowManager window;
    private LayoutInflater layout;
    View myview;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();


        window = (WindowManager) getSystemService(WINDOW_SERVICE);
layout = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.CENTER | Gravity.BOTTOM;
        params.x = 0;
        params.y = 100;
         myview = layout.inflate(R.layout.service_layout,null);

        window.addView(myview , params);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
      //  if (layout.inflate(R.layout.service_layout,null) != null) window.removeView(layout.inflate(R.layout.service_layout,null));
myview.setVisibility(View.GONE);
//window.removeView(layout.inflate(R.layout.service_layout,null));
    }
}