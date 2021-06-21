package ru.training.at.hw3.utils;

import static ru.training.at.hw3.data.UserData.getPassword;
import static ru.training.at.hw3.data.UserData.getUserName;

import ru.training.at.hw3.model.User;

public class UserManager {
    public static User createUser() {
        return new User(getUserName(), getPassword());
    }
}
