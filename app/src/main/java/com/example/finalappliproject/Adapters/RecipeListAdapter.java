package com.example.finalappliproject.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalappliproject.Models.Recipe;
import com.example.finalappliproject.R;
import com.example.finalappliproject.Utilitis.ImageLoader;
import com.example.finalappliproject.Utilitis.TimeFormat;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.ItemViewHolder> {

        private Context context;
        private ArrayList<Recipe> recipeItem;

        private RecipeListAdapter.OnClickListener onClickListener;

        public RecipeListAdapter(Context context, ArrayList<Recipe> recipeItem) {
            this.context = context;
            this.recipeItem = recipeItem;
        }

        @NonNull
        @Override
        public RecipeListAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_item, parent, false);
            ItemViewHolder itemViewHolder = new ItemViewHolder(view);
            return itemViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull RecipeListAdapter.ItemViewHolder holder, int position) {
            Recipe recipe = getItem(position);
            holder.difficulty.setText(recipe.getDifficulty());
            holder.title.setText(recipe.getTitle());
            holder.preparation_time.setText(TimeFormat.getFormattedTime(recipe.getPreparation_time()));
//            ImageLoader.getInstance().loadImage(recipe.getImage(), holder.recipe_IMG_poster);
            if (recipe.isFavorite())
                holder.recipe_IMG_favorite.setImageResource(R.drawable.heart);
            else
                holder.recipe_IMG_favorite.setImageResource(R.drawable.heart_empty);

        }
        public interface OnClickListener{
            void onClick(int position, Recipe recipeItem);
        }
        public void setOnClickListener(OnClickListener onClickListener) {
            this.onClickListener = onClickListener;
        }

        @Override
        public int getItemCount() {
            return this.recipeItem == null ? 0 : recipeItem.size();
        }

        private Recipe getItem(int position) {
            return this.recipeItem.get(position);
        }


        public class ItemViewHolder extends RecyclerView.ViewHolder {
            private MaterialTextView title;
            private MaterialTextView difficulty;
            private MaterialTextView preparation_time;
            private ShapeableImageView recipe_IMG_poster;
            private ShapeableImageView recipe_IMG_favorite;

            public ItemViewHolder(@NonNull View itemView) {
                super(itemView);
                recipe_IMG_poster = itemView.findViewById(R.id.recipe_IMG_Image);
                title = itemView.findViewById(R.id.recipe_LBL_title);
                difficulty = itemView.findViewById(R.id.recipe_LBL_difficulty);
                preparation_time = itemView.findViewById(R.id.recipe_LBL_duration);
                recipe_IMG_favorite = itemView.findViewById(R.id.recipe_IMG_favorite);

            }
        }

    }