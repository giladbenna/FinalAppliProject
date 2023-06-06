package com.example.finalappliproject.Interfaces;

import com.example.finalappliproject.Models.Recipe;

public interface RecipeCallback {

    void favoriteClicked(Recipe recipe, int position);

    void itemClicked(Recipe recipe, int position);
}
