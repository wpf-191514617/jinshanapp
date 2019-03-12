package com.minilive.library;

import android.app.Application;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
       // Bmob.initialize(this, "de04d186d0a4507238b81275e1b90ae0");
    }
}
