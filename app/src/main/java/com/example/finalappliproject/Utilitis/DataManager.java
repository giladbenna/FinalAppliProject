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

//    private static DataManager INSTANCE;
//    private FirebaseFirestore db;
//    public static DataManager getInstance() {
//        if(INSTANCE == null){
//            INSTANCE = new DataManager();
//        }
//        return INSTANCE;
//    }
//
//    private DataManager(){
//        this.db = FirebaseFirestore.getInstance();
//    }

    public static ArrayList<Recipe> getAllRecipes() {
        ArrayList<Recipe> recipes = new ArrayList<>();
        recipes.addAll(getDinnerRecipes());
        recipes.addAll(getLunchRecipes());
        recipes.addAll(getBreakFastRecipes());
        recipes.addAll(getFridayDinnerRecipes());

        recipes.add(new Recipe("Tomato Soup","https://www.acouplecooks.com/wp-content/uploads/2021/09/Tomato-Soup-002.jpg",
                "medium",100,"\"1. Saute Aromatics – heat a non-reactive pot over medium heat. Melt in 4 Tbsp butter then sautee onions until softened and golden (10-12 min). Add minced garlic and saute another minute.\\n\\n\" +\n" +
                "        \"2. Make the tomato soup base – stir in two 28 oz cans of crushed tomatoes with their juice, your chicken stock, chopped basil, sugar and black pepper. Bring to a boil then reduce heat, partially cover and simmer 10 minutes.\\n\\n\" +\n" +
                "        \"3. Blend if desired – use an immersion blender in the pot or blend in batches using a blender (be careful not to overfill the blender with hot liquid) and return soup to the pot.\\n\\n\" +\n" +
                "        \"4. Add cream and parmesan – stir in the heavy cream and shredded parmesan. Return to a simmer and season to taste if needed.\\n\\n\" +\n" +
                "        \"5. Serve – ladle into warm bowls and garnish with more parmesan and basil.\";\n"
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

    public static ArrayList<Recipe> getFridayDinnerRecipes() {
        ArrayList<Recipe> recipes = new ArrayList<>();

        recipes.add(new Recipe("Kuba Beetroot","https://i.ytimg.com/vi/1aRjBmrBpUg/maxresdefault.jpg",
                "hard",150,"put pasta in the bucket, then wash some onions...", new String[]{"pasta,bacon,onion"}));

        recipes.add(new Recipe("Schnitzel","https://www.yehudit-aviv.co.il/wp-content/uploads/DSC_0050-%D7%A2%D7%A8%D7%95%D7%9A-7.jpg",
                "medium",70,"put pasta in the bucket, then wash some meat...", new String[]{"pasta,meat,garlic"}));

        recipes.add(new Recipe("Hrime","https://www.bishuli.co.il/wp-content/uploads/2021/01/moroccan-salmon01.jpg",
                "medium",90,"put flower in the bucket, then put some peperoni...", new String[]{"flower,tomato,peperoni"}));

        recipes.add(new Recipe("Hrime","https://yifaty.co.il/wp-content/uploads/2017/05/p-206.jpg",
                "medium",90,"put flower in the bucket, then put some peperoni...", new String[]{"flower,tomato,peperoni"}));

        return recipes;
    }

    public static ArrayList<Recipe> getBreakFastRecipes() {
        ArrayList<Recipe> recipes = new ArrayList<>();

        recipes.add(new Recipe("Crumble Eggs","https://d3o5sihylz93ps.cloudfront.net/wp-content/uploads/2020/03/11102622/shutterstock_1210000312.jpg",
                "easy",10,"put pasta in the bucket, then wash some onions...", new String[]{"pasta,bacon,onion"}));

        recipes.add(new Recipe("Greek Salad","https://i2.wp.com/www.downshiftology.com/wp-content/uploads/2018/08/Greek-Salad-main.jpg",
                "medium",25,"put pasta in the bucket, then wash some meat...", new String[]{"pasta,meat,garlic"}));

        recipes.add(new Recipe("French Toast","https://www.allrecipes.com/thmb/VjVrkCVYaalH2JXogJMoFQ_a-zI=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/7016-french-toast-mfs-010-0e1007bf0b47433abe91f2f0c74e5a27.jpg",
                "medium",15,"put flower in the bucket, then put some peperoni...", new String[]{"flower,tomato,peperoni"}));

        return recipes;
    }

    public static ArrayList<Recipe> getDinnerRecipes() {
        ArrayList<Recipe> recipes = new ArrayList<>();

        recipes.add(new Recipe("Fish Grill","https://images.indianexpress.com/2018/07/fish-sustainanbel-759.jpg",
                "easy",30,"put pasta in the bucket, then wash some onions...", new String[]{"pasta,bacon,onion"}));

        recipes.add(new Recipe("Spaghetti Tomato","https://hips.hearstapps.com/hmg-prod/images/one-pot-spaghetti-6408ea3a9a32c.jpg?crop=1.00xw:0.335xh;0,0.262xh&resize=1200:*",
                "medium",80,"put pasta in the bucket, then wash some meat...", new String[]{"pasta,meat,garlic"}));

        recipes.add(new Recipe("Pizza Peperoni","https://foodhub.scene7.com/is/image/woolworthsltdprod/2004-easy-pepperoni-pizza:Mobile-1300x1150",
                "medium",60,"put flower in the bucket, then put some peperoni...", new String[]{"flower,tomato,peperoni"}));

        recipes.add(new Recipe("Beef With Veg","https://myfoodbook.com.au/sites/default/files/collections_image/slow_cooker_beef_chutney_stew_overhead_lands_0.jpg",
                "hard",120,"put flower in the bucket, then put some peperoni...", new String[]{"flower,tomato,peperoni"}));

        return recipes;
    }

    public static ArrayList<Recipe> getLunchRecipes() {
        ArrayList<Recipe> recipes = new ArrayList<>();

        recipes.add(new Recipe("Grilled Chicken","https://d3o5sihylz93ps.cloudfront.net/wp-content/uploads/2022/07/26140648/2-Medium-1024x733.jpg",
                "medium",130,"put pasta in the bucket, then wash some onions...", new String[]{"pasta,bacon,onion"}));

        recipes.add(new Recipe("Meatball Spaghetti","https://www.onceuponachef.com/images/2019/09/Spaghetti-and-Meatballs.jpg",
                "medium",70,"put pasta in the bucket, then wash some meat...", new String[]{"pasta,meat,garlic"}));

        recipes.add(new Recipe("Grilled Salomon","https://cdn.babamail.co.il/images/recipes_source/8a305fcb-3a68-4bff-961b-0f2b955da17a.jpg",
                "medium",90,"put flower in the bucket, then put some peperoni...", new String[]{"flower,tomato,peperoni"}));

        recipes.add(new Recipe("Makloba Borgul","https://d3o5sihylz93ps.cloudfront.net/wp-content/uploads/2023/07/02144450/%D7%94%D7%A0%D7%9E%D7%9C-%D7%99%D7%95%D7%A0%D7%993054-Medium.jpg",
                "medium",90,"put flower in the bucket, then put some peperoni...", new String[]{"flower,tomato,peperoni"}));


        return recipes;
    }


//    public void setRecepies() {
//
//        db = FirebaseFirestore.getInstance();
//
//                    // Assume we have a reference to the parent document
//                    DocumentReference parentDocumentRef = db.collection(Constants.DBKeys.USERS).document("J2lbk3NKeOMSK6k6RkoT6nXZGC52");
//
//                    // Create a reference to the collection
//                    CollectionReference collectionRef = parentDocumentRef.collection(Constants.DBKeys.FAVORITES);
//
//                    // Set data to the collection
//                    Recipe recipe = getRecipes().get(1);
//                    // Create a new document in the collection and set data
//                    collectionRef.document(recipe.getId()+"").set(recipe)
//                            .addOnSuccessListener(new OnSuccessListener<Void>() {
//                                @Override
//                                public void onSuccess(Void aVoid) {
//                                    // Data set to the subcollection successfully
//                                    Log.d("TAG", "saved to document success : " + recipe);
////                                    requireActivity().getSupportFragmentManager().beginTransaction()
////                                            .replace(R.id.frame_layout, new WorksFormFragment())
////                                            .commit();
//                                }
//                            })
//                            .addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception e) {
//                                    // Failed to set data to the subcollection
//                                    Log.e("TAG", "saved to document failed : " + recipe);
//                                }
//                            });
//            }
//
}

