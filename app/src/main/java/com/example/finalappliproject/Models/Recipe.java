package com.example.finalappliproject.Models;

public class Recipe {

    private String title = "";
    private String image = "";
    private boolean isFavorite = false;
    private String difficulty = "";
    private int preparation_time = 0;




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
}
