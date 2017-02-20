package com.example.jol.fedora.signUp;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jol.fedora.R;
import com.example.jol.fedora.login.LoginActivity;
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
        setContentView(R.layout.signuptest);
    }

    public void signUpButtonClick(View v) {
        EditText userNameTextBox = (EditText) findViewById(R.id.userNameEditText);
        EditText passwordTextBox = (EditText) findViewById(R.id.passwordEditText);
        EditText confirmPasswordTextBox = (EditText) findViewById(R.id.confirmPasswordText);

        String username = userNameTextBox.getText().toString();
        String password = passwordTextBox.getText().toString();
        String confirmPassword = confirmPasswordTextBox.getText().toString();
        String requestBody = getRequestBody(username, password, confirmPassword);

        // TODO Fixa dom här röda fälten om username är tomt, eller om password inte matchar m.m

        AsyncTask loginTask = new FedoraClient(getApplicationContext(), this).execute("users", requestBody);
//            Intent loginIntent = new Intent(v.getContext(), SignUpActivity.class);
//            startActivity(loginIntent);

    }

    private String getRequestBody(String username, String password, String confirmPassword)
    {
        String body =  "{\"username\":\"" + username + "\",\"password\":\"" + password + "\",\"passwordConfirmation\":\"" + confirmPassword + "\",\"errors\":{\"username\":\"\"\n" +
                "},\"isLoading\":false,\"invalid\":false}";

        return body;
    }

    public void backArrowClick(View v){
        Intent backArrowIntent = new Intent(v.getContext(), LoginActivity.class);
        startActivity(backArrowIntent);
    }

    @Override
    public void callback(SignupResponse response){
//        System.out.println("Här är code: " + response);
        Toast.makeText(this, response.getStatus(), Toast.LENGTH_LONG).show();
        Toast.makeText(this, "Success: " + response.getSuccess(), Toast.LENGTH_LONG).show();
    }
}

