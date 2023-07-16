package com.example.finalappliproject;

import android.app.ActionBar;
import android.app.Application;
import java.util.Objects;

import com.example.finalappliproject.Fragments.RecipeFragment;
import com.example.finalappliproject.Models.Recipe;
import com.example.finalappliproject.Utilitis.ImageLoader;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


public class App extends Application{
    public void onCreate() {
        super.onCreate();
        ImageLoader.initImageLoader(this);
    }
}