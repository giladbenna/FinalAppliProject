package com.example.finalappliproject.Utilitis;

import com.example.finalappliproject.Models.Recipe;

import java.util.ArrayList;

public class DataManager {

    public static ArrayList<Recipe> getRecipes() {
        ArrayList<Recipe> recipes = new ArrayList<>();

        recipes.add(new Recipe("Tomato Soup","https://www.acouplecooks.com/wp-content/uploads/2021/09/Tomato-Soup-002.jpg",
                "medium",100,"put 5 tomatoes in the bucket, then wash some garlic..."));

        recipes.add(new Recipe("Pasta Carbonara","https://www.allrecipes.com/thmb/Vg2cRidr2zcYhWGvPD8M18xM_WY=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/11973-spaghetti-carbonara-ii-DDMFS-4x3-6edea51e421e4457ac0c3269f3be5157.jpg",
                "hard",130));

        recipes.add(new Recipe("Chocolate Cake","https://www.mybakingaddiction.com/wp-content/uploads/2011/10/lr-0938-700x1050.jpg",
                "easy",50));

        recipes.add(new Recipe("Meatball Spaghetti","https://www.onceuponachef.com/images/2019/09/Spaghetti-and-Meatballs.jpg",
                "medium",70));

        recipes.add(new Recipe("Pizza Peperoni","https://foodhub.scene7.com/is/image/woolworthsltdprod/2004-easy-pepperoni-pizza:Mobile-1300x1150",
                "medium",90));

        return recipes;
    }


}

