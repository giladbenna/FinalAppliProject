package com.example.finalappliproject.Fragments.NavFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.example.finalappliproject.Adapters.FragmentsAdapter;
import com.example.finalappliproject.Fragments.RecipeFragment;
import com.example.finalappliproject.MainActivity;
import com.example.finalappliproject.R;

import java.util.Objects;

public class MainFragment extends Fragment {
    Button button;
    MainActivity mainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_fragment, container, false);

        // Find and initialize your views here
        button = rootView.findViewById(R.id.recipeButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new RecipeFragment()).commit();
            }
        });
        return rootView;
    }


}
