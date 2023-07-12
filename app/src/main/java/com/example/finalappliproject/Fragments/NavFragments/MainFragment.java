package com.example.finalappliproject.Fragments.NavFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.example.finalappliproject.Adapters.FragmentsAdapter;
import com.example.finalappliproject.Fragments.HomeFragment;
import com.example.finalappliproject.Fragments.RecipeDetailsFragment;
import com.example.finalappliproject.Fragments.RecipeFragment;
import com.example.finalappliproject.MainActivity;
import com.example.finalappliproject.R;

import java.util.Objects;

public class MainFragment extends Fragment {

    Button BtAllRecipes;
    Button BtFridayDinner;
    Button BtBreakFast;
    Button BtDinner;
    Button BtLunch;
    Button BtFavorites;
    String Cat;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_fragment, container, false);

        // Find and initialize your views here
        findViews(rootView);
        ButtonLogic();

        return rootView;
    }
    
    void findViews(View rootView){
        BtFridayDinner = rootView.findViewById(R.id.FridayDinner);
        BtBreakFast = rootView.findViewById(R.id.BreakFast);
        BtDinner = rootView.findViewById(R.id.Dinner);
        BtLunch = rootView.findViewById(R.id.Lunch);
        BtFavorites = rootView.findViewById(R.id.favoriteButton);
        BtAllRecipes = rootView.findViewById(R.id.allRecipesButton);


    }

    void ButtonLogic(){

        BtAllRecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new instance of the destination fragment
                RecipeFragment fragment = new RecipeFragment();
                Cat = "AllRecipes";
                // Create a bundle and add the recipe object as an argument
                Bundle args = new Bundle();
                args.putString("selectedCategory", Cat);
                fragment.setArguments(args);

                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
            }
        });
        BtFridayDinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new instance of the destination fragment
                RecipeFragment fragment = new RecipeFragment();
                Cat = "FridayDinner";
                // Create a bundle and add the recipe object as an argument
                Bundle args = new Bundle();
                args.putString("selectedCategory", Cat);
                fragment.setArguments(args);

                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
            }
        });

        BtBreakFast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new instance of the destination fragment
                RecipeFragment fragment = new RecipeFragment();
                Cat = "BreakFast";
                // Create a bundle and add the recipe object as an argument
                Bundle args = new Bundle();
                args.putString("selectedCategory", Cat);
                fragment.setArguments(args);

                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
            }
        });

        BtDinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new instance of the destination fragment
                RecipeFragment fragment = new RecipeFragment();
                Cat = "Dinner";
                // Create a bundle and add the recipe object as an argument
                Bundle args = new Bundle();
                args.putString("selectedCategory", Cat);
                fragment.setArguments(args);

                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
            }
        });

        BtLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new instance of the destination fragment
                RecipeFragment fragment = new RecipeFragment();
                Cat = "Lunch";
                // Create a bundle and add the recipe object as an argument
                Bundle args = new Bundle();
                args.putString("selectedCategory", Cat);
                fragment.setArguments(args);

                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
            }
        });
        BtFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
            }
        });


    }


}
