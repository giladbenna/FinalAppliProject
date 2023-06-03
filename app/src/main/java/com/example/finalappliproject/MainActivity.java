package com.example.finalappliproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.finalappliproject.Adapters.FragmentsAdapter;
import com.example.finalappliproject.Fragments.FavoriteFragment;
import com.example.finalappliproject.Fragments.MainFragment;
import com.example.finalappliproject.Fragments.UserInfoFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    Button button;
    TextView info;
    FirebaseUser user;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ViewPager2 viewPager;
    FragmentsAdapter adapter;


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


        adapter = new FragmentsAdapter(getSupportFragmentManager(), getLifecycle());

        // add Fragments to Adapter
        adapter.addFragment(new MainFragment());
        adapter.addFragment(new FavoriteFragment());
        adapter.addFragment(new UserInfoFragment());

        // Setting Adapter to viewPager
        viewPager.setAdapter(adapter);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switchBetweenAdapters(item);
                return false;
            }
        });



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

    private void switchBetweenAdapters(@NonNull MenuItem item){
        if(item.getItemId() == R.id.nav_home){
            viewPager.setCurrentItem(0);
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else if(item.getItemId() == R.id.nav_favorite){
            viewPager.setCurrentItem(1);
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else if(item.getItemId() == R.id.nav_info){
            viewPager.setCurrentItem(2);
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else if(item.getItemId() == R.id.nav_logout){
//            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
        }
    }

    private void findViews() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        viewPager = findViewById(R.id.view_pager);

    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
