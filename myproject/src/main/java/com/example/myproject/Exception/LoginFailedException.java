package com.example.myproject.Exception;

public class LoginFailedException extends RuntimeException {

    public LoginFailedException() {
    }

    public LoginFailedException(String msg){
        super(msg);
    }
}
