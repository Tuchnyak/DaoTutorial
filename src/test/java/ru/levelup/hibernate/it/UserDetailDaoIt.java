package ru.levelup.hibernate.it;

import org.junit.Assert;
import org.junit.Test;
import ru.levelup.dao.DefaultUserDao;
import ru.levelup.dao.DefaultUserDetailsDao;
import ru.levelup.dao.UserDao;
import ru.levelup.dao.UserDetailsDao;
import ru.levelup.domain.User;
import ru.levelup.domain.UserDetails;
import ru.levelup.hibernate.config.HibernateTestConfiguration;

import static org.junit.Assert.*;

public class UserDetailDaoIt {

    private UserDetailsDao daoUd = new DefaultUserDetailsDao(HibernateTestConfiguration.getFACTORY());

    private UserDao daoUser = new DefaultUserDao(HibernateTestConfiguration.getFACTORY());

    @Test
    public void testCreate() {

        User user = daoUser.createUser("Dmipro", "Dmitry", "Protsko");

        UserDetails ud = daoUd.createUD(user, 10, "u@mail.cz");

        assertNotNull(user);
        assertNotNull(ud);
        assertNotNull(ud.getUser());

        assertEquals(user, ud.getUser());
        assertEquals("Dmipro", ud.getUser().getLogin());
        assertEquals(10, ud.getAge());
        assertEquals("u@mail.cz", ud.getEmail());

        assertNotEquals(0, ud.getUser().getUserId());

    }

}
