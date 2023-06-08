package com.example.finalappliproject.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalappliproject.Models.Recipe;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private final MutableLiveData<ArrayList<Recipe>> mRecipe;

    public HomeViewModel() {
        mRecipe = new MutableLiveData<>();
        mRecipe.setValue(getMoviesFromFirebase());
    }

    private ArrayList<Recipe> getMoviesFromFirebase(){
        ArrayList<Recipe> recipes = new ArrayList<>();


        return recipes;
    }

//    public LiveData<String> getGreeting() {
//        return greeting;
//    }
//
//    public void loadGreeting() {
//        // Simulate loading the greeting from a data source
//        String loadedGreeting = "Hello, MVVM!";
//        greeting.setValue(loadedGreeting);
//    }
}