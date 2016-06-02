package com.pxjoke.entities;

import java.util.Date;

public class OrderPositionEntity extends AbstractEntity{
    public Long       orderID;
    public Long       itemID;
    public Long       amount;
    public Double     price;
    public ItemEntity item;

    @Override
    public String toString() {
        return "OrderPositionEntity{" +
                "orderID=" + orderID +
                ", itemID=" + itemID +
                ", amount=" + amount +
                ", price=" + price +
                ", item=" + item.toString() +
                '}';
    }
}
