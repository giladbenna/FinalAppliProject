package com.example.finalappliproject.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.finalappliproject.Models.Recipe;
import com.example.finalappliproject.R;
import com.example.finalappliproject.Utilitis.ImageLoader;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RecipeDetailsFragment extends Fragment {

    TextView recipeDetails;
    ShapeableImageView recipePicture;
    Recipe selectedRecipe;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.recipe_details,container,false);
        findViews(root);

        Bundle args = getArguments();
        if (args != null) {
            selectedRecipe = args.getParcelable("selectedRecipe");
        }

        recipeDetails.setText(selectedRecipe.getRecipeFeatures());
        ImageLoader.getInstance().loadImage(selectedRecipe.getImage(), recipePicture);


        return root;
    }

    private void findViews(ViewGroup root) {
        recipeDetails = root.findViewById(R.id.RecipeDetails);
        recipePicture = root.findViewById(R.id.RecipeImage);
    }

}


