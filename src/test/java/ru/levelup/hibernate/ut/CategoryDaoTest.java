package ru.levelup.hibernate.ut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.levelup.dao.CategoryDao;
import ru.levelup.dao.DefaultCategoryDao;
import ru.levelup.domain.Category;
import ru.levelup.domain.Post;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategoryDaoTest {

    @Mock
    private SessionFactory factory;

    @Mock
    private Session session;

    @Mock
    private Transaction transaction;

    private CategoryDao daoCat;

    @Before
    public void setup() {
        assertNotNull(factory);

        daoCat = new DefaultCategoryDao(factory);

        when(factory.openSession()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);
    }

    @Test
    public void createTest() {

        Category cat = daoCat.createCategory("CatName");

        assertNotNull(cat);

        assertEquals("CatName", cat.getName());

        verify(factory).openSession();
        verify(session).beginTransaction();
        verify(session).persist(any(Post.class));
        verify(transaction).commit();
        verify(session).close();

    }

}
