package com.example.finalappliproject.Fragments;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalappliproject.Adapters.RecipeListAdapter;
import com.example.finalappliproject.Interfaces.DataRetrievedListener;
import com.example.finalappliproject.Interfaces.RecipeCallback;
import com.example.finalappliproject.Models.Recipe;
import com.example.finalappliproject.R;
import com.example.finalappliproject.Utilitis.Constants;
import com.example.finalappliproject.Utilitis.DataManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class RecipeFragment extends Fragment {
    private RecyclerView main_LST_recipes;

    String valueOfCategory;
    RecipeListAdapter recipeListAdapter;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    ArrayList<Recipe> recipeList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recipe_fragment, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            valueOfCategory = bundle.getString("selectedCategory");
        }
        DataManager.getInstance().uploadRecipesToDB();
        DataManager.getInstance().readFromDB(valueOfCategory, new DataRetrievedListener() {
            @Override
            public void onDataRetrieved(ArrayList<Recipe> recipes) {
                recipeList = recipes;
                initViews();
            }
        });

        // Find and initialize your views here

        findViews(rootView);

        return rootView;
    }

    private void initViews() {


        recipeListAdapter = new RecipeListAdapter(getContext(), recipeList);
        if(Objects.equals(valueOfCategory, "AllRecipes"))
            recipeListAdapter = new RecipeListAdapter(getContext(), DataManager.getAllRecipes());

//        switch (valueOfCategory) {
//            case "AllRecipes":
//                recipeListAdapter = new RecipeListAdapter(getContext(), DataManager.getAllRecipes());
//                break;
//            case "FridayDinner":
//            case "BreakFast":
//            case "Lunch":
//            case "Dinner":
//                recipeListAdapter = new RecipeListAdapter(getContext(), recipeList);
//                break;
//        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        main_LST_recipes.setLayoutManager(linearLayoutManager);
        main_LST_recipes.setAdapter(recipeListAdapter);

        recipeListAdapter.setRecipeCallback(new RecipeCallback() {
            @Override
            public void favoriteClicked(Recipe recipe, int position) {
                recipe.setFavorite((!recipe.isFavorite()));
                DataManager.getInstance().updateRecipe(valueOfCategory,recipe);
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


    private void readFromDB1(String category) {

        DocumentReference docRef = db.collection(Constants.DBKeys.RECIPES).document(category);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();

                    if (document.exists()) {
                        List<Map<String, Object>> recipeDataList = (List<Map<String, Object>>) document.get(category);
                        if (recipeDataList != null) {
                            for (Map<String, Object> recipeData : recipeDataList) {
                                String title = (String) recipeData.get("title");
                                String image = (String) recipeData.get("image");
                                Boolean isFavorite = (Boolean) recipeData.get("isFavorite");
                                String difficulty = (String) recipeData.get("difficulty");
                                Integer preparation_time = (Integer) recipeData.get("preparation_time");
                                String recipeFeatures = (String) recipeData.get("recipeFeatures");


                                // Extract other fields as needed

                                Recipe recipe = new Recipe(title, image, isFavorite, difficulty, preparation_time, recipeFeatures);
                                recipeList.add(recipe);
                            }
                        }
                    } else {
                        Log.d(TAG, "No such document");
                    }

                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }





}

