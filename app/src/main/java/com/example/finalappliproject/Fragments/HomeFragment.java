package com.example.finalappliproject.Fragments;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.finalappliproject.Adapters.RecipeListAdapter;
import com.example.finalappliproject.Interfaces.RecipeCallback;
import com.example.finalappliproject.Models.Recipe;
import com.example.finalappliproject.R;
import com.example.finalappliproject.Utilitis.DataManager;
import com.example.finalappliproject.ViewModel.HomeViewModel;

import java.util.ArrayList;
import java.util.Objects;

public class HomeFragment extends Fragment {

    private RecyclerView main_LST_recipes;

    private RecipeListAdapter recipeListAdapter;
    private HomeViewModel homeViewModel;

    private Observer<ArrayList<Recipe>> observer = new Observer<ArrayList<Recipe>>() {
        @Override
        public void onChanged(ArrayList<Recipe> recipes) {
            recipeListAdapter.updateRecipes(recipes);
        }
    };


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        findViews(root);
        initViews();

        return root;
    }

    private void initViews() {
        recipeListAdapter = new RecipeListAdapter(getContext(),homeViewModel.getRecipes().getValue()); // ממלא את הריסיקל
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        main_LST_recipes.setLayoutManager(linearLayoutManager);
        main_LST_recipes.setAdapter(recipeListAdapter);
        homeViewModel.getRecipes().observe(getViewLifecycleOwner(), observer);

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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}