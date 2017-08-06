package ru.levelup.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.domain.User;

import java.util.ArrayList;
import java.util.HashSet;

public class DefaultUserDao implements UserDao {

    private SessionFactory factory;

    public DefaultUserDao(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public User createUser(String login, String name, String lastName) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        User user = new User();

        user.setLogin(login);
        user.setName(name);
        user.setLastName(lastName);
        user.setComments(new ArrayList<>());
        user.setPosts(new HashSet<>());

        session.persist(user);

        transaction.commit();
        session.close();

        return user;
    }
}
