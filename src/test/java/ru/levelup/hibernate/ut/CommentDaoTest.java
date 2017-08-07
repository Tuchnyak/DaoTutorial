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
import ru.levelup.dao.CommentDao;
import ru.levelup.dao.DefaultCommentDao;
import ru.levelup.domain.Comment;
import ru.levelup.domain.Post;

import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CommentDaoTest {

    @Mock
    private SessionFactory factory;

    @Mock
    private Session session;

    @Mock
    private Transaction transaction;

    private CommentDao daoComment;

    @Before
    public void setup() {
        assertNotNull(factory);

        daoComment = new DefaultCommentDao(factory);

        when(factory.openSession()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);

    }

    @Test public void testCtreate() {
        Comment comment = daoComment.createComment("CommentText", new Date(1000));

        assertNotNull(comment);

        assertEquals("CommentText", comment.getText());
        assertEquals(new Date(1000), comment.getCommentedAt());

        verify(factory).openSession();
        verify(session).beginTransaction();
        verify(session).persist(any(Post.class));
        verify(transaction).commit();
        verify(session).close();

    }

}
