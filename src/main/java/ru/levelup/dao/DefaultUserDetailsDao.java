package ru.levelup.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.domain.User;
import ru.levelup.domain.UserDetails;

public class DefaultUserDetailsDao implements UserDetailsDao {

    private SessionFactory factory;

    public DefaultUserDetailsDao(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public UserDetails createUD(User user, int age, String email) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        UserDetails ud = new UserDetails();

        ud.setUser(user);
        ud.setAge(age);
        ud.setEmail(email);

        session.persist(ud);

        transaction.commit();
        session.close();

        return ud;
    }
}
