package com.example.myproject.Exception;

public class GetAddressException  extends RuntimeException{
    public GetAddressException() {
    }

    public GetAddressException(String msg){
        super(msg);
    }
}
