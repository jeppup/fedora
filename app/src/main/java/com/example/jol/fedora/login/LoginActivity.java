package com.example.jol.fedora.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jol.fedora.R;

/**
 * Created by Jesper on 2017-02-11.
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    public void loginButtonClick(View v)
    {
        Toast.makeText(this, "Button Clicked", Toast.LENGTH_LONG).show();
        EditText passwordTextBox = (EditText)findViewById(R.id.passwordEditText);
        EditText userNameTextBox = (EditText)findViewById(R.id.userNameEditText);
    }

    private LoginResult attemptLogin(String username, String password){
        LoginResult result = new LoginResult();
        return result;
    }

}
