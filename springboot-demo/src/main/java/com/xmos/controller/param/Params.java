package com.xmos.controller.param;

import com.xmos.entity.User;

public class Params {
    private User user;
    private String operations;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOperations() {
        return operations;
    }

    public void setOperations(String operations) {
        this.operations = operations;
    }
}
