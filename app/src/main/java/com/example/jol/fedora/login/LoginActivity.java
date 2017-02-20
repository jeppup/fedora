package com.example.jol.fedora.login;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jol.fedora.R;
import com.example.jol.fedora.service.FedoraClient;
import com.example.jol.fedora.service.JsonFiles.LoginResult;
import com.example.jol.fedora.service.ServiceActivity;
import com.example.jol.fedora.signUp.SignUpActivity;

/**
 * Created by Jesper on 2017-02-11.
 */

public class LoginActivity extends ServiceActivity<LoginResult> {
    public LoginActivity(){
        super(LoginResult.class);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logintest);
    }

    public void loginButtonClick(View v) {
        String password = ((EditText) findViewById(R.id.passwordEditText)).getText().toString();
        String username = ((EditText) findViewById(R.id.userNameEditText)).getText().toString();

        AsyncTask loginTask = new FedoraClient(getApplicationContext(), this).execute("auth", username, password, password);
    }

    @Override
    public void callback(LoginResult callbackObject) {
        Toast.makeText(this, "Login success: " + callbackObject.getSuccess(), Toast.LENGTH_LONG).show();
        //If success, redirect user to GameActivity here!!
    }

    public void signUpButtonClick(View v) {
        Intent signUpIntent = new Intent(v.getContext(), SignUpActivity.class);
        startActivity(signUpIntent);
    }
}
