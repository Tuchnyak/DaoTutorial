package ru.levelup.hibernate.ut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.levelup.dao.DefaultUserDetailsDao;
import ru.levelup.dao.UserDetailsDao;
import ru.levelup.domain.Post;
import ru.levelup.domain.User;
import ru.levelup.domain.UserDetails;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserDetailsDaoTest {

    @Mock
    private SessionFactory factory;

    @Mock
    private Session session;

    @Mock
    private Transaction transaction;

    private UserDetailsDao daoUd;

    @Mock
    private User user;

    @Before
    public void setup() {
        assertNotNull(factory);

        daoUd = new DefaultUserDetailsDao(factory);

        when(factory.openSession()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);
    }

    @Test
    public void createTest() {
        UserDetails ud = daoUd.createUD(user, 10, "u@mail.cz");

        assertNotNull(ud);

        assertEquals(user, ud.getUser());
        assertEquals(10, ud.getAge());
        assertEquals("u@mail.cz", ud.getEmail());

        verify(factory).openSession();
        verify(session).beginTransaction();
        verify(session).persist(any(Post.class));
        verify(transaction).commit();
        verify(session).close();

    }

}
