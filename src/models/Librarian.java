package models;

import interfaces.User;

public class Librarian implements User {
    private String username;

    public Librarian(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isLibrarian() {
        return true;
    }
}