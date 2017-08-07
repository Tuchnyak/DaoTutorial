package ru.levelup.dao;

import ru.levelup.domain.User;
import ru.levelup.domain.UserDetails;

public interface UserDetailsDao {

    UserDetails createUD(User user, int age, String email);

}
