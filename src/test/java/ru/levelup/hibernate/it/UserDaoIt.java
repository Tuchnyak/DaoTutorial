package ru.levelup.hibernate.it;

import org.junit.Test;
import ru.levelup.dao.DefaultUserDao;
import ru.levelup.dao.UserDao;
import ru.levelup.domain.User;
import ru.levelup.hibernate.config.HibernateTestConfiguration;

import static org.junit.Assert.*;

public class UserDaoIt {

    private UserDao dao = new DefaultUserDao(HibernateTestConfiguration.getFACTORY());

    @Test
    public void testCreate() {

        User user = dao.createUser("Dmipro", "Dmitry", "Protsko");

        assertNotNull(user);

        assertEquals("Dmipro", user.getLogin());
        assertEquals("Dmitry", user.getName());
        assertEquals("Protsko", user.getLastName());

        assertNotEquals(0, user.getUserId());
    }


}
