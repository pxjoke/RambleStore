package com.pxjoke.entities;

import java.util.Date;

public class ItemEntity extends AbstractEntity{
    public String title;
    public String company;
    public String description;
    public String img;
    public String genre;
    public Double price;
    public Date   release_date;

    @Override
    public String toString() {
        return "ItemEntity{" +
                "title='" + title + '\'' +
                ", company='" + company + '\'' +
                ", description='" + description + '\'' +
                ", img='" + img + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", release_date=" + release_date +
                "} " + super.toString();
    }
}
