package com.example.finalappliproject.ViewModel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalappliproject.Interfaces.DataRetrievedListener;
import com.example.finalappliproject.Models.Recipe;
import com.example.finalappliproject.Utilitis.Constants;
import com.example.finalappliproject.Utilitis.DataManager;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HomeViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private final MutableLiveData<ArrayList<Recipe>> mRecipes;

    public HomeViewModel() {
        mRecipes = new MutableLiveData<>();
        DataManager.getInstance().readFromDBUserFavorites(new DataRetrievedListener() {
            @Override
            public void onDataRetrieved(ArrayList<Recipe> recipes) {
                mRecipes.setValue(recipes);
            }
        });
    }

    public LiveData<ArrayList<Recipe>> getRecipes() {
        return mRecipes;
    }

}