package com.example.finalappliproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SignUpTabFragment extends Fragment {

    TextView email;
    TextView password;
    TextView phoneNum;
    TextView confirmPassword;
    Button signUp;
    float v = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_fragment,container,false);
        findViews(root);
        animation(root);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,password,phoneNum;

            }
        });



        return root;
    }


    private void animation(ViewGroup root) {
        email.setTranslationY(300);
        phoneNum.setTranslationY(300);
        password.setTranslationY(300);
        confirmPassword.setTranslationY(300);
        signUp.setTranslationY(300);

        email.setAlpha(v);
        phoneNum.setAlpha(v);
        password.setAlpha(v);
        confirmPassword.setAlpha(v);
        signUp.setAlpha(v);


        email.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        phoneNum.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(400).start();
        password.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(600).start();
        confirmPassword.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(600).start();
        signUp.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(800).start();
    }

    private void findViews(ViewGroup root) {
        email = root.findViewById(R.id.email);
        phoneNum = root.findViewById(R.id.phoneNumber);
        password = root.findViewById(R.id.password);
        confirmPassword = root.findViewById(R.id.confirmPassword);
        signUp = root.findViewById(R.id.signUp);
    }


}
