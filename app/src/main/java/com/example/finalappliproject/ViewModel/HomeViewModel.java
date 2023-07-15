package com.example.finalappliproject.ViewModel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalappliproject.Models.Recipe;
import com.example.finalappliproject.Utilitis.Constants;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HomeViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private final MutableLiveData<ArrayList<Recipe>> mRecipes;

    public HomeViewModel() {
        mRecipes = new MutableLiveData<>();
        mRecipes.setValue(getRecipesFromFirebase());
    }

    private ArrayList<Recipe> getRecipesFromFirebase() {
        ArrayList<Recipe> recipes = new ArrayList<>();
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

        Recipe recipeNew = new Recipe("Tomato Soup", "https://www.acouplecooks.com/wp-content/uploads/2021/09/Tomato-Soup-002.jpg",
                "medium", 100, "1.Saute Aromatics – heat a non-reactive pot over medium heat. Melt in 4 Tbsp butter then sautee onions until softened and golden (10-12 min). Add minced garlic and saute another minute. \\n\\n2.Make the tomato soup base – stir in two 28 oz cans of crushed tomatoes with their juice, your chicken stock, chopped basil, sugar and black pepper. Bring to a boil then reduce heat, partially cover and simmer 10 minutes. \\n\\n3.Blend if desired – use an immersion blender in the pot or blend in batches using a blender (be careful not to overfill the blender with hot liquid) and return soup to the pot. \\n\\n4.Add cream and parmesan – stir in the heavy cream and shredded parmesan. Return to a simmer and season to taste if needed. \\n\\n5.Serve – ladle into warm bowls and garnish with more parmesan and basil.");
        recipes.add(recipeNew);
        mRecipes.setValue(recipes);

        CollectionReference users = firebaseFirestore.collection(Constants.DBKeys.USERS);
        Map<String, Object> data = new HashMap<>();
        data.put("UID", "BOejpmWOm2VjbonTkAsI6RemFqC2");

        users.document("BOejpmWOm2VjbonTkAsI6RemFqC2").set(data);

//
//        databaseReference.addChildEventListener(
//                new ChildEventListener() {
//                    @Override
//                    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                        Recipe recipe = snapshot.getValue(Recipe.class);
//                        recipes.add(recipe);
//                        mRecipes.setValue(recipes);
//                    }
//
//                    @Override
//                    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                        Recipe recipe = snapshot.getValue(Recipe.class);
//                        Log.d("TAG", "onChildChanged: " + recipe);
//                        for (int i = 0; i < recipes.size(); i++) {
//                            assert recipe != null;
//                            if (recipes.get(i).getTitle().equals(recipe.getTitle())) {
//                                Log.d("TAG3", "onChildChanged: " + i);
//                                recipes.set(i, recipe);
//                            }
//                        }
//                        Log.d("TAG_All", "onChildChanged: " + recipes);
//                        mRecipes.setValue(recipes);
//                    }
//
//                    @Override
//                    public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//                    }
//
//                    @Override
//                    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                }
//        );


        return recipes;
    }

    public LiveData<ArrayList<Recipe>> getRecipes() {
        return mRecipes;
    }

//    public LiveData<String> getGreeting() {
//        return greeting;
//    }
//
//    public void loadGreeting() {
//        // Simulate loading the greeting from a data source
//        String loadedGreeting = "Hello, MVVM!";
//        greeting.setValue(loadedGreeting);
//    }
}