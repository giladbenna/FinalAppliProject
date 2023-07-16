package com.example.finalappliproject.Utilitis;

import static android.content.ContentValues.TAG;

import android.util.Log;

import com.example.finalappliproject.Interfaces.DataRetrievedListener;
import com.example.finalappliproject.Models.Recipe;
import com.example.finalappliproject.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DataManager {

    private static DataManager INSTANCE;
    private FirebaseFirestore db;
    FirebaseUser user;

    public static DataManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataManager();
        }
        return INSTANCE;
    }

    private DataManager() {
        this.db = FirebaseFirestore.getInstance();
    }

    public static ArrayList<Recipe> getAllRecipes() {
        ArrayList<Recipe> recipes = new ArrayList<>();
        recipes.addAll(getDinnerRecipes());
        recipes.addAll(getLunchRecipes());
        recipes.addAll(getBreakFastRecipes());
        recipes.addAll(getFridayDinnerRecipes());

        recipes.add(new Recipe("Tomato Soup", "https://www.acouplecooks.com/wp-content/uploads/2021/09/Tomato-Soup-002.jpg",
                "medium", 100, "\"1. Saute Aromatics – heat a non-reactive pot over medium heat. Melt in 4 Tbsp butter then sautee onions until softened and golden (10-12 min). Add minced garlic and saute another minute.\\n\\n\" +\n" +
                "        \"2. Make the tomato soup base – stir in two 28 oz cans of crushed tomatoes with their juice, your chicken stock, chopped basil, sugar and black pepper. Bring to a boil then reduce heat, partially cover and simmer 10 minutes.\\n\\n\" +\n" +
                "        \"3. Blend if desired – use an immersion blender in the pot or blend in batches using a blender (be careful not to overfill the blender with hot liquid) and return soup to the pot.\\n\\n\" +\n" +
                "        \"4. Add cream and parmesan – stir in the heavy cream and shredded parmesan. Return to a simmer and season to taste if needed.\\n\\n\" +\n" +
                "        \"5. Serve – ladle into warm bowls and garnish with more parmesan and basil.\";\n"
        ));

        recipes.add(new Recipe("Pasta Carbonara", "https://www.allrecipes.com/thmb/Vg2cRidr2zcYhWGvPD8M18xM_WY=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/11973-spaghetti-carbonara-ii-DDMFS-4x3-6edea51e421e4457ac0c3269f3be5157.jpg",
                "hard", 130, "put pasta in the bucket, then wash some onions..."));

        recipes.add(new Recipe("Chocolate Cake", "https://www.mybakingaddiction.com/wp-content/uploads/2011/10/lr-0938-700x1050.jpg",
                "easy", 50, "put flower in the bucket, then wash some chocolate..."));

        recipes.add(new Recipe("Meatball Spaghetti", "https://www.onceuponachef.com/images/2019/09/Spaghetti-and-Meatballs.jpg",
                "medium", 70, "put pasta in the bucket, then wash some meat..."));

        recipes.add(new Recipe("Pizza Peperoni", "https://foodhub.scene7.com/is/image/woolworthsltdprod/2004-easy-pepperoni-pizza:Mobile-1300x1150",
                "medium", 90, "put flower in the bucket, then put some peperoni..."));

        return recipes;
    }

    public static ArrayList<Recipe> getFridayDinnerRecipes() {
        ArrayList<Recipe> recipes = new ArrayList<>();

        recipes.add(new Recipe("Kuba Beetroot", "https://i.ytimg.com/vi/1aRjBmrBpUg/maxresdefault.jpg",
                "hard", 150, "put pasta in the bucket, then wash some onions..."));

        recipes.add(new Recipe("Schnitzel", "https://www.yehudit-aviv.co.il/wp-content/uploads/DSC_0050-%D7%A2%D7%A8%D7%95%D7%9A-7.jpg",
                "medium", 70, "put pasta in the bucket, then wash some meat..."));

        recipes.add(new Recipe("Hrime", "https://www.bishuli.co.il/wp-content/uploads/2021/01/moroccan-salmon01.jpg",
                "medium", 90, "put flower in the bucket, then put some peperoni..."));

        recipes.add(new Recipe("Halat Shabat", "https://yifaty.co.il/wp-content/uploads/2017/05/p-206.jpg",
                "medium", 90, "put flower in the bucket, then put some peperoni..."));

        return recipes;
    }

    //
    public static ArrayList<Recipe> getBreakFastRecipes() {
        ArrayList<Recipe> recipes = new ArrayList<>();

        recipes.add(new Recipe("Crumble Eggs", "https://d3o5sihylz93ps.cloudfront.net/wp-content/uploads/2020/03/11102622/shutterstock_1210000312.jpg",
                "easy", 10, "put pasta in the bucket, then wash some onions..."));

        recipes.add(new Recipe("Greek Salad", "https://i2.wp.com/www.downshiftology.com/wp-content/uploads/2018/08/Greek-Salad-main.jpg",
                "medium", 25, "put pasta in the bucket, then wash some meat..."));

        recipes.add(new Recipe("French Toast", "https://www.allrecipes.com/thmb/VjVrkCVYaalH2JXogJMoFQ_a-zI=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/7016-french-toast-mfs-010-0e1007bf0b47433abe91f2f0c74e5a27.jpg",
                "medium", 15, "put flower in the bucket, then put some peperoni..."));

        return recipes;
    }

    public static ArrayList<Recipe> getDinnerRecipes() {
        ArrayList<Recipe> recipes = new ArrayList<>();

        recipes.add(new Recipe("Fish Grill", "https://images.indianexpress.com/2018/07/fish-sustainanbel-759.jpg",
                "easy", 30, "put pasta in the bucket, then wash some onions..."));

        recipes.add(new Recipe("Spaghetti Tomato", "https://hips.hearstapps.com/hmg-prod/images/one-pot-spaghetti-6408ea3a9a32c.jpg?crop=1.00xw:0.335xh;0,0.262xh&resize=1200:*",
                "medium", 80, "put pasta in the bucket, then wash some meat..."));

        recipes.add(new Recipe("Pizza Peperoni", "https://foodhub.scene7.com/is/image/woolworthsltdprod/2004-easy-pepperoni-pizza:Mobile-1300x1150",
                "medium", 60, "put flower in the bucket, then put some peperoni..."));

        recipes.add(new Recipe("Beef With Veg", "https://myfoodbook.com.au/sites/default/files/collections_image/slow_cooker_beef_chutney_stew_overhead_lands_0.jpg",
                "hard", 120, "put flower in the bucket, then put some peperoni..."));

        return recipes;
    }

    public static ArrayList<Recipe> getLunchRecipes() {
        ArrayList<Recipe> recipes = new ArrayList<>();

        recipes.add(new Recipe("Grilled Chicken", "https://d3o5sihylz93ps.cloudfront.net/wp-content/uploads/2022/07/26140648/2-Medium-1024x733.jpg",
                "medium", 130, "put pasta in the bucket, then wash some onions..."));

        recipes.add(new Recipe("Meatball Spaghetti", "https://www.onceuponachef.com/images/2019/09/Spaghetti-and-Meatballs.jpg",
                "medium", 70, "put pasta in the bucket, then wash some meat..."));

        recipes.add(new Recipe("Grilled Salomon", "https://cdn.babamail.co.il/images/recipes_source/8a305fcb-3a68-4bff-961b-0f2b955da17a.jpg",
                "medium", 90, "put flower in the bucket, then put some peperoni..."));

        recipes.add(new Recipe("Makloba Borgul", "https://d3o5sihylz93ps.cloudfront.net/wp-content/uploads/2023/07/02144450/%D7%94%D7%A0%D7%9E%D7%9C-%D7%99%D7%95%D7%A0%D7%993054-Medium.jpg",
                "medium", 90, "put flower in the bucket, then put some peperoni..."));


        return recipes;
    }

    public static Map<String, Object> getAllRecipesMap() {
        Map<String, Object> recipes = new HashMap<>(getDinnerRecipesMap()); // instead of putAll ( just for start )
        mergeMaps(recipes, getLunchRecipesMap());
        mergeMaps(recipes, getBreakFastRecipesMap());
        mergeMaps(recipes, getFridayDinnerRecipesMap());

//        recipes.add(new Recipe("Tomato Soup", "https://www.acouplecooks.com/wp-content/uploads/2021/09/Tomato-Soup-002.jpg",
//                "medium", 100, "\"1. Saute Aromatics – heat a non-reactive pot over medium heat. Melt in 4 Tbsp butter then sautee onions until softened and golden (10-12 min). Add minced garlic and saute another minute.\\n\\n\" +\n" +
//                "        \"2. Make the tomato soup base – stir in two 28 oz cans of crushed tomatoes with their juice, your chicken stock, chopped basil, sugar and black pepper. Bring to a boil then reduce heat, partially cover and simmer 10 minutes.\\n\\n\" +\n" +
//                "        \"3. Blend if desired – use an immersion blender in the pot or blend in batches using a blender (be careful not to overfill the blender with hot liquid) and return soup to the pot.\\n\\n\" +\n" +
//                "        \"4. Add cream and parmesan – stir in the heavy cream and shredded parmesan. Return to a simmer and season to taste if needed.\\n\\n\" +\n" +
//                "        \"5. Serve – ladle into warm bowls and garnish with more parmesan and basil.\";\n"
//        ));
//
//        recipes.add(new Recipe("Pasta Carbonara", "https://www.allrecipes.com/thmb/Vg2cRidr2zcYhWGvPD8M18xM_WY=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/11973-spaghetti-carbonara-ii-DDMFS-4x3-6edea51e421e4457ac0c3269f3be5157.jpg",
//                "hard", 130, "put pasta in the bucket, then wash some onions..."));
//
//        recipes.add(new Recipe("Chocolate Cake", "https://www.mybakingaddiction.com/wp-content/uploads/2011/10/lr-0938-700x1050.jpg",
//                "easy", 50, "put flower in the bucket, then wash some chocolate..."));
//
//        recipes.add(new Recipe("Meatball Spaghetti", "https://www.onceuponachef.com/images/2019/09/Spaghetti-and-Meatballs.jpg",
//                "medium", 70, "put pasta in the bucket, then wash some meat..."));
//
//        recipes.add(new Recipe("Pizza Peperoni", "https://foodhub.scene7.com/is/image/woolworthsltdprod/2004-easy-pepperoni-pizza:Mobile-1300x1150",
//                "medium", 90, "put flower in the bucket, then put some peperoni..."));

        return recipes;
    }

    public static Map<String, Object> getFridayDinnerRecipesMap() {

        Map<String, Object> recipes = new HashMap<>();
        recipes.put("0", new Recipe("Kuba Beetroot", "https://i.ytimg.com/vi/1aRjBmrBpUg/maxresdefault.jpg",
                "hard", 150, "put pasta in the bucket, then wash some onions..."));

        recipes.put("1", new Recipe("Schnitzel", "https://www.yehudit-aviv.co.il/wp-content/uploads/DSC_0050-%D7%A2%D7%A8%D7%95%D7%9A-7.jpg",
                "medium", 70, "put pasta in the bucket, then wash some meat..."));

        recipes.put("2", new Recipe("Hrime", "https://www.bishuli.co.il/wp-content/uploads/2021/01/moroccan-salmon01.jpg",
                "medium", 90, "put flower in the bucket, then put some peperoni..."));

        recipes.put("3", new Recipe("Halat Shabat", "https://yifaty.co.il/wp-content/uploads/2017/05/p-206.jpg",
                "medium", 90, "put flower in the bucket, then put some peperoni..."));

        return recipes;
    }

    //
    public static Map<String, Object> getBreakFastRecipesMap() {
        Map<String, Object> recipes = new HashMap<>();
        recipes.put("0", new Recipe("Crumble Eggs", "https://d3o5sihylz93ps.cloudfront.net/wp-content/uploads/2020/03/11102622/shutterstock_1210000312.jpg",
                "easy", 10, "put pasta in the bucket, then wash some onions..."));

        recipes.put("1", new Recipe("Greek Salad", "https://i2.wp.com/www.downshiftology.com/wp-content/uploads/2018/08/Greek-Salad-main.jpg",
                "medium", 25, "put pasta in the bucket, then wash some meat..."));

        recipes.put("2", new Recipe("French Toast", "https://www.allrecipes.com/thmb/VjVrkCVYaalH2JXogJMoFQ_a-zI=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/7016-french-toast-mfs-010-0e1007bf0b47433abe91f2f0c74e5a27.jpg",
                "medium", 15, "put flower in the bucket, then put some peperoni..."));

        return recipes;
    }

    public static Map<String, Object> getDinnerRecipesMap() {
        Map<String, Object> recipes = new HashMap<>();
        recipes.put("0", new Recipe("Fish Grill", "https://images.indianexpress.com/2018/07/fish-sustainanbel-759.jpg",
                "easy", 30, "put pasta in the bucket, then wash some onions..."));

        recipes.put("1", new Recipe("Spaghetti Tomato", "https://hips.hearstapps.com/hmg-prod/images/one-pot-spaghetti-6408ea3a9a32c.jpg?crop=1.00xw:0.335xh;0,0.262xh&resize=1200:*",
                "medium", 80, "put pasta in the bucket, then wash some meat..."));

        recipes.put("2", new Recipe("Pizza Peperoni", "https://foodhub.scene7.com/is/image/woolworthsltdprod/2004-easy-pepperoni-pizza:Mobile-1300x1150",
                "medium", 60, "put flower in the bucket, then put some peperoni..."));

        recipes.put("3", new Recipe("Beef With Veg", "https://myfoodbook.com.au/sites/default/files/collections_image/slow_cooker_beef_chutney_stew_overhead_lands_0.jpg",
                "hard", 120, "put flower in the bucket, then put some peperoni..."));

        return recipes;
    }

    public static Map<String, Object> getLunchRecipesMap() {
        Map<String, Object> recipes = new HashMap<>();

        recipes.put("0", new Recipe("Grilled Chicken", "https://d3o5sihylz93ps.cloudfront.net/wp-content/uploads/2022/07/26140648/2-Medium-1024x733.jpg",
                "medium", 130, "put pasta in the bucket, then wash some onions..."));

        recipes.put("1", new Recipe("Meatball Spaghetti", "https://www.onceuponachef.com/images/2019/09/Spaghetti-and-Meatballs.jpg",
                "medium", 70, "put pasta in the bucket, then wash some meat..."));

        recipes.put("2", new Recipe("Meatball Spaghetti", "https://www.onceuponachef.com/images/2019/09/Spaghetti-and-Meatballs.jpg",
                "medium", 70, "put pasta in the bucket, then wash some meat..."));

        recipes.put("3", new Recipe("Meatball Spaghetti", "https://www.onceuponachef.com/images/2019/09/Spaghetti-and-Meatballs.jpg",
                "medium", 70, "put pasta in the bucket, then wash some meat..."));


        return recipes;
    }


    public void setRecipes() {
        Map<String, Object> categoriesMap = new HashMap<>();
        categoriesMap.put("AllRecipes", getAllRecipesMap());
        categoriesMap.put("FridayDinner", getFridayDinnerRecipesMap());
        categoriesMap.put("BreakFast", getBreakFastRecipesMap());
        categoriesMap.put("Lunch", getLunchRecipesMap());
        categoriesMap.put("Dinner", getDinnerRecipesMap());

        // Assume we have a reference to the parent document
//        DocumentReference parentDocumentRef = db.collection(Constants.DBKeys.RECIPES).document("AllRecipes");
        String[] categories = {"AllRecipes", "FridayDinner", "BreakFast", "Lunch", "Dinner"};
        for (String category : categories) {

            // Create a reference to the collection
            CollectionReference collectionRef = db.collection(category);
            Map<String, Object> tempMap = (Map<String, Object>) categoriesMap.get(category);
            // Create a new document in the collection and set data
            collectionRef.document().set(tempMap.get("0"))
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            // Data set to the subcollection successfully
                            Log.d("TAG", "saved to document success : ");
//                                    requireActivity().getSupportFragmentManager().beginTransaction()
//                                            .replace(R.id.frame_layout, new WorksFormFragment())
//                                            .commit();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            // Failed to set data to the subcollection
                            Log.e("TAG", "saved to document failed : ");
                        }
                    });

        }

    }

    private static void mergeMaps(Map<String, Object> destination, Map<String, Object> source) {
        for (Map.Entry<String, Object> entry : source.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (destination.containsKey(key)) {
                Object existingValue = destination.get(key);
                if (existingValue instanceof List<?>) {
                    // If the existing value is a list, add the new value to the list
                    List<Object> mergedList = (List<Object>) existingValue;
                    mergedList.add(value);
                } else {
                    // If the existing value is not a list, create a new list and add both values
                    List<Object> mergedList = new ArrayList<>();
                    mergedList.add(existingValue);
                    mergedList.add(value);
                    destination.put(key, mergedList);
                }
            } else {
                // If the key is not present in the destination map, simply add the value
                destination.put(key, value);
            }
        }
    }

    // if i will want that all the index will be from 0 - Infinity

//    public static Map<Integer, Object> getAllRecipesMapWithIndex() {
//        Map<Integer, Object> recipes = new HashMap<>();
//        int keyIndex = 0;
//
//        keyIndex = mergeMap(recipes, keyIndex, getDinnerRecipesMap());
//        keyIndex = mergeMap(recipes, keyIndex, getLunchRecipesMap());
//        keyIndex = mergeMap(recipes, keyIndex, getBreakFastRecipesMap());
//        keyIndex = mergeMap(recipes, keyIndex, getFridayDinnerRecipesMap());
//
//        return recipes;
//    }
//
//    private static int mergeMap(Map<Integer, Object> destination, int startIndex, Map<String, Object> source) {
//        for (Map.Entry<String, Object> entry : source.entrySet()) {
//            destination.put(startIndex, entry.getValue());
//            startIndex++;
//        }
//        return startIndex;
//    }


    public void uploadRecipesToDB() {
        uploadFridayDinnerRecipesDB();
        uploadBreakFastRecipesDB();
        uploadLunchRecipesDB();
        uploadDinnerRecipesDB();
    }

    public void uploadFridayDinnerRecipesDB() {
        CollectionReference FridayDinner = db.collection("FridayDinner");
        Map<String, Object> recipe_1 = new HashMap<>();
        recipe_1.put("title", "Kuba Beetroot");
        recipe_1.put("image", "https://i.ytimg.com/vi/1aRjBmrBpUg/maxresdefault.jpg");
        recipe_1.put("isFavorite", false);
        recipe_1.put("difficulty", "hard");
        recipe_1.put("preparation_time", 150);
        recipe_1.put("recipeFeatures", "put pasta in the bucket, then wash some onions...");
        FridayDinner.document("Kuba Beetroot").set(recipe_1);

        Map<String, Object> recipe_2 = new HashMap<>();
        recipe_2.put("title", "Schnitzel");
        recipe_2.put("image", "https://www.yehudit-aviv.co.il/wp-content/uploads/DSC_0050-%D7%A2%D7%A8%D7%95%D7%9A-7.jpg");
        recipe_2.put("isFavorite", false);
        recipe_2.put("difficulty", "medium");
        recipe_2.put("preparation_time", 70);
        recipe_2.put("recipeFeatures", "put pasta in the bucket, then wash some onions...");
        FridayDinner.document("Schnitzel").set(recipe_2);

        Map<String, Object> recipe_3 = new HashMap<>();
        recipe_3.put("title", "Hrime");
        recipe_3.put("image", "https://www.bishuli.co.il/wp-content/uploads/2021/01/moroccan-salmon01.jpg");
        recipe_3.put("isFavorite", false);
        recipe_3.put("difficulty", "medium");
        recipe_3.put("preparation_time", 90);
        recipe_3.put("recipeFeatures", "put pasta in the bucket, then wash some onions...");
        FridayDinner.document("Hrime").set(recipe_3);

        Map<String, Object> recipe_4 = new HashMap<>();
        recipe_4.put("title", "Halat Shabat");
        recipe_4.put("image", "https://yifaty.co.il/wp-content/uploads/2017/05/p-206.jpg");
        recipe_4.put("isFavorite", false);
        recipe_4.put("difficulty", "medium");
        recipe_4.put("preparation_time", 90);
        recipe_4.put("recipeFeatures", "put pasta in the bucket, then wash some onions...");
        FridayDinner.document("Halat Shabat").set(recipe_4);
    }

    public void uploadBreakFastRecipesDB() {
        CollectionReference breakFast = db.collection("BreakFast");
        Map<String, Object> recipe_1 = new HashMap<>();
        recipe_1.put("title", "Crumble Eggs");
        recipe_1.put("image", "https://d3o5sihylz93ps.cloudfront.net/wp-content/uploads/2020/03/11102622/shutterstock_1210000312.jpg");
        recipe_1.put("isFavorite", false);
        recipe_1.put("difficulty", "easy");
        recipe_1.put("preparation_time", 10);
        recipe_1.put("recipeFeatures", "take eggs, put in the stove...");
        breakFast.document("Crumble Eggs").set(recipe_1);

        Map<String, Object> recipe_2 = new HashMap<>();
        recipe_2.put("title", "Greek Salad");
        recipe_2.put("image", "https://i2.wp.com/www.downshiftology.com/wp-content/uploads/2018/08/Greek-Salad-main.jpg");
        recipe_2.put("isFavorite", false);
        recipe_2.put("difficulty", "medium");
        recipe_2.put("preparation_time", 25);
        recipe_2.put("recipeFeatures", "put pasta in the bucket, then wash some onions...");
        breakFast.document("Greek Salad").set(recipe_2);

        Map<String, Object> recipe_3 = new HashMap<>();
        recipe_3.put("title", "French Toast");
        recipe_3.put("image", "https://www.allrecipes.com/thmb/VjVrkCVYaalH2JXogJMoFQ_a-zI=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/7016-french-toast-mfs-010-0e1007bf0b47433abe91f2f0c74e5a27.jpg");
        recipe_3.put("isFavorite", false);
        recipe_3.put("difficulty", "medium");
        recipe_3.put("preparation_time", 15);
        recipe_3.put("recipeFeatures", "put pasta in the bucket, then wash some onions...");
        breakFast.document("French Toast").set(recipe_3);
    }

    public void uploadLunchRecipesDB() {
        CollectionReference lunch = db.collection("Lunch");
        Map<String, Object> recipe_1 = new HashMap<>();
        recipe_1.put("title", "Grilled Chicken");
        recipe_1.put("image", "https://d3o5sihylz93ps.cloudfront.net/wp-content/uploads/2022/07/26140648/2-Medium-1024x733.jpg");
        recipe_1.put("isFavorite", false);
        recipe_1.put("difficulty", "medium");
        recipe_1.put("preparation_time", 130);
        recipe_1.put("recipeFeatures", "put pasta in the bucket, then wash some onions...");
        lunch.document("Grilled Chicken").set(recipe_1);

        Map<String, Object> recipe_2 = new HashMap<>();
        recipe_2.put("title", "Meatball Spaghetti");
        recipe_2.put("image", "https://www.onceuponachef.com/images/2019/09/Spaghetti-and-Meatballs.jpg");
        recipe_2.put("isFavorite", false);
        recipe_2.put("difficulty", "medium");
        recipe_2.put("preparation_time", 70);
        recipe_2.put("recipeFeatures", "put pasta in the bucket, then wash some onions...");
        lunch.document("Meatball Spaghetti").set(recipe_2);

        Map<String, Object> recipe_3 = new HashMap<>();
        recipe_3.put("title", "Hrime");
        recipe_3.put("image", "https://www.bishuli.co.il/wp-content/uploads/2021/01/moroccan-salmon01.jpg");
        recipe_3.put("isFavorite", false);
        recipe_3.put("difficulty", "medium");
        recipe_3.put("preparation_time", 90);
        recipe_3.put("recipeFeatures", "put pasta in the bucket, then wash some onions...");
        lunch.document("Hrime").set(recipe_3);

        Map<String, Object> recipe_4 = new HashMap<>();
        recipe_4.put("title", "Halat Shabat");
        recipe_4.put("image", "https://yifaty.co.il/wp-content/uploads/2017/05/p-206.jpg");
        recipe_4.put("isFavorite", false);
        recipe_4.put("difficulty", "medium");
        recipe_4.put("preparation_time", 90);
        recipe_4.put("recipeFeatures", "put pasta in the bucket, then wash some onions...");
        lunch.document("Halat Shabat").set(recipe_4);
    }

    public void uploadDinnerRecipesDB() {
        CollectionReference dinner = db.collection("Dinner");
        Map<String, Object> recipe_1 = new HashMap<>();
        recipe_1.put("title", "Fish Grill");
        recipe_1.put("image", "https://images.indianexpress.com/2018/07/fish-sustainanbel-759.jpg");
        recipe_1.put("isFavorite", false);
        recipe_1.put("difficulty", "hard");
        recipe_1.put("preparation_time", 150);
        recipe_1.put("recipeFeatures", "put pasta in the bucket, then wash some onions...");
        dinner.document("Fish Grill").set(recipe_1);

        Map<String, Object> recipe_2 = new HashMap<>();
        recipe_2.put("title", "Spaghetti Tomato");
        recipe_2.put("image", "https://hips.hearstapps.com/hmg-prod/images/one-pot-spaghetti-6408ea3a9a32c.jpg?crop=1.00xw:0.335xh;0,0.262xh&resize=1200:*");
        recipe_2.put("isFavorite", false);
        recipe_2.put("difficulty", "medium");
        recipe_2.put("preparation_time", 70);
        recipe_2.put("recipeFeatures", "put pasta in the bucket, then wash some onions...");
        dinner.document("Spaghetti Tomato").set(recipe_2);

        Map<String, Object> recipe_3 = new HashMap<>();
        recipe_3.put("title", "Pizza Peperoni");
        recipe_3.put("image", "https://foodhub.scene7.com/is/image/woolworthsltdprod/2004-easy-pepperoni-pizza:Mobile-1300x1150");
        recipe_3.put("isFavorite", false);
        recipe_3.put("difficulty", "medium");
        recipe_3.put("preparation_time", 60);
        recipe_3.put("recipeFeatures", "put pasta in the bucket, then wash some onions...");
        dinner.document("Pizza Peperoni").set(recipe_3);

        Map<String, Object> recipe_4 = new HashMap<>();
        recipe_4.put("title", "Beef With Veg");
        recipe_4.put("image", "https://myfoodbook.com.au/sites/default/files/collections_image/slow_cooker_beef_chutney_stew_overhead_lands_0.jpg");
        recipe_4.put("isFavorite", false);
        recipe_4.put("difficulty", "medium");
        recipe_4.put("preparation_time", 120);
        recipe_4.put("recipeFeatures", "put pasta in the bucket, then wash some onions...");
        dinner.document("Beef With Veg").set(recipe_4);

    }

    public void updateRecipe(String category, Recipe recipe) {
        CollectionReference collectionRef = db.collection(category);
        if (recipe != null) {
            String documentId = recipe.getTitle();
            Log.d(TAG, "updateRecipe: " + recipe);
            collectionRef.document(documentId).set(recipe)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            // Update successful
                            Log.d("TAG", "updateWorkOrder onSuccess: ");
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            // Update failed
                            Log.d("TAG", "updateWorkOrder onFailure: ");
                        }
                    });
        }
    }


    public void readFromDB(String category, DataRetrievedListener listener) {

        CollectionReference collectionRef = db.collection(category);

        collectionRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot querySnapshot) {
                ArrayList<Recipe> recipeList = new ArrayList<>();

                for (QueryDocumentSnapshot documentSnapshot : querySnapshot) {
                    Recipe recipe = documentSnapshot.toObject(Recipe.class);
                    recipeList.add(recipe);
                }
                listener.onDataRetrieved(recipeList);

                // Do something with the recipes ArrayList here
                // For example, you can pass it to another method or update your UI
            }
        });

    }

    public void readFromDBUserFavorites(DataRetrievedListener listener) {
        ArrayList<Recipe> recipeList = new ArrayList<>();

        DocumentReference userDocumentRef = db.collection(Constants.DBKeys.USERS).document(user.getUid());
        CollectionReference collectionRef = userDocumentRef.collection("favorites");
        collectionRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    Recipe recipe = documentSnapshot.toObject(Recipe.class);
                    recipeList.add(recipe);
                }
                listener.onDataRetrieved(recipeList);
            }
        });

    }

    public void setUser(FirebaseUser currentUser) {
        this.user = currentUser;
    }

    public String addNewDocument(Recipe recipe) {
        DocumentReference userDocumentRef = db.collection(Constants.DBKeys.USERS).document(user.getUid());
        CollectionReference collectionRef = userDocumentRef.collection("favorites");
        DocumentReference newDocumentRef = collectionRef.document();
        String documentId = newDocumentRef.getId(); // Get the auto-generated document ID
//        recipe.setFavorite(true);
        newDocumentRef.set(recipe)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
        return documentId;
    }

    public void deleteDocuments(Recipe recipe) {
        DocumentReference userDocumentRef = db.collection(Constants.DBKeys.USERS).document(user.getUid());
        CollectionReference collectionRef = userDocumentRef.collection("favorites");
        Query query = collectionRef.whereEqualTo("title", recipe.getTitle());
        query.get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot querySnapshot) {
                        // Iterate through the documents returned by the query
                        for (DocumentSnapshot documentSnapshot : querySnapshot.getDocuments()) {
                            // Delete each document
                            documentSnapshot.getReference().delete();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Handle the error
                    }
                });
    }
}

