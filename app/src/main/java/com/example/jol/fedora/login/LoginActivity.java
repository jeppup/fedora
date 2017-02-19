package com.example.jol.fedora.login;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jol.fedora.R;
import com.example.jol.fedora.service.FedoraClient;
import com.example.jol.fedora.service.JsonFiles.SignupResponse;
import com.example.jol.fedora.service.ServiceActivity;
import com.example.jol.fedora.signUp.SignUpActivity;

/**
 * Created by Jesper on 2017-02-11.
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logintest);
    }

    public void loginButtonClick(View v) {
        Toast.makeText(this, "Button clicked", Toast.LENGTH_LONG).show();
    }

    public void signUpButtonClick(View v) {
        Intent signUpIntent = new Intent(v.getContext(), SignUpActivity.class);
        startActivity(signUpIntent);
//        Toast.makeText(this, "Sign up clicked", Toast.LENGTH_LONG).show();
//        EditText passwordTextBox = (EditText) findViewById(R.id.passwordEditText);
//        EditText userNameTextBox = (EditText) findViewById(R.id.userNameEditText);
//
//        AsyncTask loginTask = new FedoraClient(getApplicationContext()).execute("users");
    }

    private LoginResult attemptLogin(String username, String password) {
        LoginResult result = new LoginResult();
        return result;
    }

}
