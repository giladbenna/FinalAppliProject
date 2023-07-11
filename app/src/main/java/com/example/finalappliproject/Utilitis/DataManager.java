package com.example.finalappliproject.Utilitis;

import android.util.Log;

import com.example.finalappliproject.Models.Recipe;
import com.example.finalappliproject.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;

public class DataManager {

    private static DataManager INSTANCE;
    private FirebaseFirestore db;
    public static DataManager getInstance() {
        if(INSTANCE == null){
            INSTANCE = new DataManager();
        }
        return INSTANCE;
    }

    private DataManager(){
        this.db = FirebaseFirestore.getInstance();
    }

    public static ArrayList<Recipe> getRecipes() {
        ArrayList<Recipe> recipes = new ArrayList<>();

        recipes.add(new Recipe("Tomato Soup","https://www.acouplecooks.com/wp-content/uploads/2021/09/Tomato-Soup-002.jpg",
                "medium",100,"1.Saute Aromatics – heat a non-reactive pot over medium heat. Melt in 4 Tbsp butter then sautee onions until softened and golden (10-12 min). Add minced garlic and saute another minute. \\n\\n2.Make the tomato soup base – stir in two 28 oz cans of crushed tomatoes with their juice, your chicken stock, chopped basil, sugar and black pepper. Bring to a boil then reduce heat, partially cover and simmer 10 minutes. \\n\\n3.Blend if desired – use an immersion blender in the pot or blend in batches using a blender (be careful not to overfill the blender with hot liquid) and return soup to the pot. \\n\\n4.Add cream and parmesan – stir in the heavy cream and shredded parmesan. Return to a simmer and season to taste if needed. \\n\\n5.Serve – ladle into warm bowls and garnish with more parmesan and basil."
                , new String[]{"tomato,garlic,chicken"}));

        recipes.add(new Recipe("Pasta Carbonara","https://www.allrecipes.com/thmb/Vg2cRidr2zcYhWGvPD8M18xM_WY=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/11973-spaghetti-carbonara-ii-DDMFS-4x3-6edea51e421e4457ac0c3269f3be5157.jpg",
                "hard",130,"put pasta in the bucket, then wash some onions...", new String[]{"pasta,bacon,onion"}));

        recipes.add(new Recipe("Chocolate Cake","https://www.mybakingaddiction.com/wp-content/uploads/2011/10/lr-0938-700x1050.jpg",
                "easy",50,"put flower in the bucket, then wash some chocolate...", new String[]{"chocolate,flower,suger"}));

        recipes.add(new Recipe("Meatball Spaghetti","https://www.onceuponachef.com/images/2019/09/Spaghetti-and-Meatballs.jpg",
                "medium",70,"put pasta in the bucket, then wash some meat...", new String[]{"pasta,meat,garlic"}));

        recipes.add(new Recipe("Pizza Peperoni","https://foodhub.scene7.com/is/image/woolworthsltdprod/2004-easy-pepperoni-pizza:Mobile-1300x1150",
                "medium",90,"put flower in the bucket, then put some peperoni...", new String[]{"flower,tomato,peperoni"}));

        return recipes;
    }


    public void setRecepies() {

        db = FirebaseFirestore.getInstance();

                    // Assume we have a reference to the parent document
                    DocumentReference parentDocumentRef = db.collection(Constants.DBKeys.USERS).document("J2lbk3NKeOMSK6k6RkoT6nXZGC52");

                    // Create a reference to the collection
                    CollectionReference collectionRef = parentDocumentRef.collection(Constants.DBKeys.FAVORITES);

                    // Set data to the collection
                    Recipe recipe = getRecipes().get(1);
                    // Create a new document in the collection and set data
                    collectionRef.document(recipe.getId()+"").set(recipe)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    // Data set to the subcollection successfully
                                    Log.d("TAG", "saved to document success : " + recipe);
//                                    requireActivity().getSupportFragmentManager().beginTransaction()
//                                            .replace(R.id.frame_layout, new WorksFormFragment())
//                                            .commit();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    // Failed to set data to the subcollection
                                    Log.e("TAG", "saved to document failed : " + recipe);
                                }
                            });
            }

}

