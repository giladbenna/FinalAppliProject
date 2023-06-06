package com.example.finalappliproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.finalappliproject.Fragments.NavFragments.FavoriteFragment;
import com.example.finalappliproject.Fragments.NavFragments.MainFragment;
import com.example.finalappliproject.Fragments.NavFragments.UserInfoFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    FrameLayout frameLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*-----------------Hooks----------------------*/
        findViews();

        /*-----------------Navigation Drawer Menu----------------------*/
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Begin the transaction
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, new MainFragment())
                .commit();

//        adapter = new FragmentsAdapter(getSupportFragmentManager(), getLifecycle());
//
//        // add Fragments to Adapter
//        adapter.addFragment(new MainFragment());
//        adapter.addFragment(new FavoriteFragment());
//        adapter.addFragment(new UserInfoFragment());
//
//        // Setting Adapter to viewPager
//        viewPager.setAdapter(adapter);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switchBetweenAdapters(item);
                return false;
            }
        });

    }

    private void switchBetweenAdapters(@NonNull MenuItem item){
        if(item.getItemId() == R.id.nav_home){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_layout, new MainFragment())
                    .commit();
        }
        else if(item.getItemId() == R.id.nav_favorite){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_layout, new FavoriteFragment())
                    .commit();
        }
        else if(item.getItemId() == R.id.nav_info){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_layout, new UserInfoFragment())
                    .commit();
        }
        else if(item.getItemId() == R.id.nav_logout){
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
        }
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    private void findViews() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        frameLayout = findViewById(R.id.frame_layout);
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    //        /*-----------------LogOut----------------------*/
//        firebaseAuth = FirebaseAuth.getInstance();
//        user = firebaseAuth.getCurrentUser();
//        if (user == null) {
//            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//            startActivity(intent);
//            finish();
//        } else {
//            info.setText(user.getEmail());
//        }
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FirebaseAuth.getInstance().signOut();
//                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });

}
