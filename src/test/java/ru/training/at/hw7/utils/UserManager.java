package ru.training.at.hw7.utils;

import static ru.training.at.hw7.data.UserData.getFullName;
import static ru.training.at.hw7.data.UserData.getLogin;
import static ru.training.at.hw7.data.UserData.getPassword;

import ru.training.at.hw7.model.User;

public class UserManager {
    public static User createUser() {
        return new User(getLogin(), getPassword(), getFullName());
    }
}
