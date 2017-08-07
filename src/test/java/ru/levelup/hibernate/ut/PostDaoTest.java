package ru.levelup.hibernate.ut;


import org.hibernate.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import ru.levelup.dao.DefaultPostDao;
import ru.levelup.dao.PostDao;
import ru.levelup.domain.Post;

import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostDaoTest {

    @Mock
    private SessionFactory factory;

    @Mock
    private Session session;

    @Mock
    private Transaction transaction;

    private PostDao daoPost;

    @Before
    public void setup() {
        assertNotNull(factory);

        daoPost = new DefaultPostDao(factory);

        when(factory.openSession()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);
    }

    @Test
    public void testCreate() {
        Post post = daoPost.createPost("Post title",
                "Mnogo texta", new Date(1000));

        assertNotNull(post);

        assertEquals("Post title", post.getTitle());
        assertEquals("Mnogo texta", post.getText());
        assertEquals(new Date(1000), post.getPostedAt());

        verify(factory).openSession();
        verify(session).beginTransaction();
        verify(session).persist(any(Post.class));
        verify(transaction).commit();
        verify(session).close();
    }

}
