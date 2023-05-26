package com.example.finalappliproject;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    TextInputEditText editTextEmail, editTextPassword;
    MaterialButton buttonReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findViews();

    }

    private void ButtonLogic(){
        buttonReg.setOnClickListener(v -> {
            String email,password;

        });
    }

    private void findViews(){
        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        buttonReg = findViewById(R.id.RegisterButton);
    }
}