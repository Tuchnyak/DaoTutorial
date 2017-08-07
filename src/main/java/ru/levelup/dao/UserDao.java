package ru.levelup.dao;

import ru.levelup.domain.User;

public interface UserDao {

    User createUser(String login, String name, String lastName);

}
