package ru.levelup.hibernate.ut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import ru.levelup.dao.DefaultUserDao;
import ru.levelup.dao.UserDao;
import ru.levelup.domain.User;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoTest {

    @Mock
    private SessionFactory factory;

    @Mock
    private Session session;

    @Mock
    private Transaction transaction;

    private UserDao dao;

    @Before
    public void setup() {
//        factory = Mockito.mock(SessionFactory.class);
//        MockitoAnnotations.initMocks(this);
        assertNotNull(factory);

        dao = new DefaultUserDao(factory);

        when(factory.openSession()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);
    }

    @Test
    public void testCreate() {
        User user = dao.createUser("Dmipro", "Dmitry", "Protsko");

        assertNotNull(user);

        assertEquals("Dmipro", user.getLogin());
        assertEquals("Dmitry", user.getName());
        assertEquals("Protsko", user.getLastName());

        verify(factory).openSession();
        verify(session).beginTransaction();
        verify(session).persist(any(User.class));
        verify(transaction).commit();
        verify(session).close();

    }

}
