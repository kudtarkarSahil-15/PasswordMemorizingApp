package com.example.passwordmemorizingapp;

import java.io.Serializable;
//
public class Model implements Serializable {
//    fields where user have save credentials
    String userId, password, domain;

//    constructor
    public Model(String userId, String password, String domain) {
        this.userId = userId;
        this.password = password;
        this.domain = domain;
    }

//    getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
