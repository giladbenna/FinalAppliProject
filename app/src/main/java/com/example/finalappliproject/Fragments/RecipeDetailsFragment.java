package com.example.finalappliproject.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.finalappliproject.Models.Recipe;
import com.example.finalappliproject.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RecipeDetailsFragment extends Fragment {

    TextView userInfo;
    Recipe selectedRecipe;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.recipe_details,container,false);
        findViews(root);

        Bundle args = getArguments();
        if (args != null) {
            selectedRecipe = args.getParcelable("selectedRecipe");
        }

        userInfo.setText(selectedRecipe.getRecipeFeatures());

        return root;
    }

    private void findViews(ViewGroup root) {
        userInfo = root.findViewById(R.id.RecipeDetails);
    }

}


