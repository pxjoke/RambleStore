package com.pxjoke.entities;

import java.util.Date;

public class OrderEntity extends AbstractEntity{
    public Long userID;
    public Date saleDate;

    @Override
    public String toString() {
        return "OrderEntity{" +
                "userID=" + userID +
                ", saleDate=" + saleDate +
                "} " + super.toString();
    }
}
