package com.example.jol.fedora.service.JsonFiles;

/**
 * Created by antonfluch on 2017-02-18.
 */

public class JsonError {
    public String username;
    public String password;
    public String passwordConfirmation;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    @Override
    public String toString(){
        return username + " - " + password + " - " + passwordConfirmation;
    }

}
