package com.example.finalappliproject.Utilitis;

import com.example.finalappliproject.Models.Recipe;

import java.util.ArrayList;

public class DataManager {

    public static ArrayList<Recipe> getRecipes() {
        ArrayList<Recipe> recipes = new ArrayList<>();

        recipes.add(new Recipe("Tomato Soup","https://www.acouplecooks.com/wp-content/uploads/2021/09/Tomato-Soup-002.jpg",
                "medium",100));

        return recipes;
    }


}

