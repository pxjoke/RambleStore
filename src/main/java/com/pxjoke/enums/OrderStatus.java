package com.pxjoke.enums;

public enum OrderStatus {
    cart("cart"),
    paid("paid");

    private final String status;

    OrderStatus(String status) {
        this.status = status;
    }

    public final String getRole() {
        return status;
    }
}
