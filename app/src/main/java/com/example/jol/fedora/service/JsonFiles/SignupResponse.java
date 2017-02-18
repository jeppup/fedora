package com.example.jol.fedora.service.JsonFiles;

import com.example.jol.fedora.service.JsonFiles.JsonError;

/**
 * Created by antonfluch on 2017-02-18.
 */

public class SignupResponse {
    private String status;
    private Boolean success;
    private JsonError errors;

    public String getStatus() {
        return status;
    }

    public Boolean getSuccess() {
        return success;
    }

    public JsonError getErrors() {
        return errors;
    }

    @Override
    public String toString(){
        return status + " - " + success + " (" + errors + ")";
    }
}


