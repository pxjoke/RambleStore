package com.pxjoke.requests;

public abstract class AbstractRequestArguments {
    public String token;
    public abstract void checkValidity() throws Exception;
}
