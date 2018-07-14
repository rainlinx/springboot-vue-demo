package com.xmos.controller.param;

import com.xmos.entity.User;

public class Params {
    public User user;
    public String operations;

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
