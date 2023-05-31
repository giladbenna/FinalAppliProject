package com.example.finalappliproject;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class LoginTabFragment extends Fragment {

    TextView emailTV;
    TextView passwordTV;
    TextView forgotPasswordTV;
    Button login;
    float v = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment,container,false);
        findViews(root);
        animation(root);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,password;
                email = String.valueOf(emailTV.getText());
                password = String.valueOf(passwordTV.getText());

                if(TextUtils.isEmpty(email)){
                    MessageOnNoEmail();
                }
                if(TextUtils.isEmpty(password)){
                    MessageOnNoPassword();
                }
            }
        });


        return root;
    }
    private void MessageOnNoEmail(){
        Toast.makeText(getContext(),"Please Put a Email",Toast.LENGTH_SHORT).show();
    }
    private void MessageOnNoPassword(){
        Toast.makeText(getContext(),"Please Put A Password",Toast.LENGTH_SHORT).show();
    }

    private void animation(ViewGroup root) {
        emailTV.setTranslationY(300);
        passwordTV.setTranslationY(300);
        forgotPasswordTV.setTranslationY(300);
        login.setTranslationY(300);

        emailTV.setAlpha(v);
        passwordTV.setAlpha(v);
        forgotPasswordTV.setAlpha(v);
        login.setAlpha(v);


        emailTV.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        passwordTV.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgotPasswordTV.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        login.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(700).start();
    }

    private void findViews(ViewGroup root) {
        emailTV = root.findViewById(R.id.email);
        passwordTV = root.findViewById(R.id.password);
        forgotPasswordTV = root.findViewById(R.id.forgotPassword);
        login = root.findViewById(R.id.loginButton);
    }


}
