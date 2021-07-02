package ru.training.at.hw7.model;

public class User {
    private final String login;
    private final String password;
    private final String fullName;

    public User(String username, String password, String fullName) {
        this.login = username;
        this.password = password;
        this.fullName = fullName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }
}
