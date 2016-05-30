package com.pxjoke.requests.items;

import com.pxjoke.requests.AbstractRequestArguments;
import java.util.Date;

public class CreateItemRequestArguments extends AbstractRequestArguments {
    public String  title;
    public String  company;
    public String  description;
    public String  genre;
    public String  img;
    public Double  price;
    public Date    releaseDate;


    @Override
    public void checkValidity() throws Exception {

    }
}
