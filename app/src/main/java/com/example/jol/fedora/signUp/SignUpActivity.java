package com.example.jol.fedora.signUp;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jol.fedora.R;
import com.example.jol.fedora.service.FedoraClient;
import com.example.jol.fedora.service.ServiceActivity;
import com.example.jol.fedora.service.JsonFiles.SignupResponse;

/**
 * Created by antonfluch on 2017-02-18.
 */

public class SignUpActivity extends ServiceActivity<SignupResponse> {
    public SignUpActivity(){
        super(SignupResponse.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    public void signUpButtonClick(View v) {
        EditText userNameTextBox = (EditText) findViewById(R.id.userNameEditText);
        EditText passwordTextBox = (EditText) findViewById(R.id.passwordEditText);
        EditText confirmPasswordTextBox = (EditText) findViewById(R.id.confirmPasswordText);

        String userNameString = userNameTextBox.getText().toString();
        String passwordText = passwordTextBox.getText().toString();
        String confirmPasswordText = confirmPasswordTextBox.getText().toString();


        // TODO Fixa dom här röda fälten om username är tomt, eller om password inte matchar m.m

            AsyncTask loginTask = new FedoraClient(getApplicationContext(), this).execute("users", userNameString, passwordText, confirmPasswordText);
//            Intent loginIntent = new Intent(v.getContext(), SignUpActivity.class);
//            startActivity(loginIntent);

    }

    @Override
    public void callback(SignupResponse response){
//        System.out.println("Här är code: " + response);
        Toast.makeText(this, response.getStatus(), Toast.LENGTH_LONG).show();
        Toast.makeText(this, "Success: " + response.getSuccess(), Toast.LENGTH_LONG).show();
    }
}

