package com.example.finalappliproject;

import android.app.ActionBar;
import android.app.Application;
import java.util.Objects;
import com.example.finalappliproject.Utilitis.ImageLoader;


public class App extends Application{
    public void onCreate() {
        super.onCreate();
        ImageLoader.initImageLoader(this);
    }
}