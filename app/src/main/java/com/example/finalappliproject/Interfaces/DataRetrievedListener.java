package com.example.finalappliproject.Interfaces;

import com.example.finalappliproject.Models.Recipe;
import java.util.ArrayList;


public interface DataRetrievedListener {

    void onDataRetrieved(ArrayList<Recipe> recipes);

}