package com.pxjoke.entities;

import com.pxjoke.enums.UserRole;

import java.util.Date;

public class UserEntity extends AbstractEntity {
    public String eMail;
    public String password;
    public UserRole role;
//    public String role;

    @Override
    public String toString() {
        return "UserEntity{" +
                "eMail='" + eMail + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                "} " + super.toString();
    }
}
