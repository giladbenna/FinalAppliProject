package com.example.finalappliproject.Fragments;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalappliproject.Adapters.RecipeListAdapter;
import com.example.finalappliproject.Interfaces.RecipeCallback;
import com.example.finalappliproject.Models.Recipe;
import com.example.finalappliproject.R;
import com.example.finalappliproject.Utilitis.DataManager;

import java.util.Objects;

public class RecipeFragment extends Fragment {
    private RecyclerView main_LST_recipes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recipe_fragment, container, false);

        // Find and initialize your views here
        findViews(rootView);
        initViews();
        return rootView;
    }

    private void initViews() {
        RecipeListAdapter recipeListAdapter = new RecipeListAdapter(getContext(), DataManager.getRecipes());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        main_LST_recipes.setLayoutManager(linearLayoutManager);
        main_LST_recipes.setAdapter(recipeListAdapter);

        recipeListAdapter.setRecipeCallback(new RecipeCallback() {
            @Override
            public void favoriteClicked(Recipe recipe, int position) {
                recipe.setFavorite((!recipe.isFavorite()));
                Objects.requireNonNull(main_LST_recipes.getAdapter()).notifyItemChanged(position);
            }

            @Override
            public void itemClicked(Recipe recipe, int position) {
                // here i can change things per click on each item in the recycle
                Toast.makeText(getContext(), "" + recipe.getTitle(), Toast.LENGTH_SHORT).show();
                // Create a new instance of the destination fragment
                RecipeDetailsFragment fragment = new RecipeDetailsFragment();

                // Create a bundle and add the recipe object as an argument
                Bundle args = new Bundle();
                args.putParcelable("selectedRecipe", recipe);
                fragment.setArguments(args);

                    requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();



            }
        });
    }

    private void findViews(View rootView) {
        main_LST_recipes = rootView.findViewById(R.id.main_LST_recipes);
    }

}
