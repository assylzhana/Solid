package models;

import interfaces.User;

public class SimpleUser implements User {
    private String username;

    public SimpleUser(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isLibrarian() {
        return false;
    }
}