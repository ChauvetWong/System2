package com.example.system2;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class HqApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
