package com.example.finalappliproject.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Recipe implements Parcelable {

    private int id;
    private String title = "";
    private String image = "";
    private boolean isFavorite = false;
    private String difficulty = "";
    private int preparation_time = 0;
    private String recipeFeatures = "";


    public int getId() {
        return id;
    }


    public Recipe(String title, String image, String difficulty, int preparation_time, String recipeFeatures) {
        this.title = title;
        this.image = image;
        this.difficulty = difficulty;
        this.preparation_time = preparation_time;
        this.recipeFeatures = recipeFeatures;
    }


    public String getRecipeFeatures() {
        return recipeFeatures;
    }

    public Recipe setRecipeFeatures(String recipeFeatures) {
        this.recipeFeatures = recipeFeatures;
        return this;
    }

    public Recipe(String title, String image, String difficulty, int preparation_time) {
        this.title = title;
        this.image = image;
        this.difficulty = difficulty;
        this.preparation_time = preparation_time;
    }

    public String getTitle() {
        return title;
    }

    public Recipe setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Recipe setImage(String image) {
        this.image = image;
        return this;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public Recipe setFavorite(boolean favorite) {
        isFavorite = favorite;
        return this;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public Recipe setDifficulty(String difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public int getPreparation_time() {
        return preparation_time;
    }

    public Recipe setPreparation_time(int preparation_time) {
        this.preparation_time = preparation_time;
        return this;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", isFavorite=" + isFavorite +
                ", difficulty='" + difficulty + '\'' +
                ", preparation_time=" + preparation_time +
                '}';
    }

    // Parcelable.Creator
    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    protected Recipe(Parcel in) {
        title = in.readString();
        image = in.readString();
        isFavorite = in.readByte() != 0;  // Read a byte and convert it to a boolean
        difficulty = in.readString();
        preparation_time = in.readInt();
        recipeFeatures = in.readString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(image);
        dest.writeByte((byte) (isFavorite ? 1 : 0));  // Write a byte representing the boolean value
        dest.writeString(difficulty);
        dest.writeInt(preparation_time);
        dest.writeString(recipeFeatures);
    }

}
