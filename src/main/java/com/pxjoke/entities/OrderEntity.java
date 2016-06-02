package com.pxjoke.entities;

import com.pxjoke.enums.OrderStatus;

import java.util.Date;

public class OrderEntity extends AbstractEntity{
    public Long userID;
    public Date saleDate;
    public OrderStatus status;
    public Double sum;
    public Long count;

    @Override
    public String toString() {
        return "OrderEntity{" +
                "userID=" + userID +
                ", saleDate=" + saleDate +
                ", status=" + status +
                ", sum=" + sum +
                ", count=" + count +
                "}\n";
    }
}
