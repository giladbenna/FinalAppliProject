package com.example.finalappliproject.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private MutableLiveData<String> greeting = new MutableLiveData<>();

    public LiveData<String> getGreeting() {
        return greeting;
    }

    public void loadGreeting() {
        // Simulate loading the greeting from a data source
        String loadedGreeting = "Hello, MVVM!";
        greeting.setValue(loadedGreeting);
    }
}