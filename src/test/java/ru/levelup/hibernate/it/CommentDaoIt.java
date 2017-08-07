package ru.levelup.hibernate.it;

import org.junit.Assert;
import org.junit.Test;
import ru.levelup.dao.CommentDao;
import ru.levelup.dao.DefaultCommentDao;
import ru.levelup.domain.Comment;
import ru.levelup.hibernate.config.HibernateTestConfiguration;

import java.util.Date;

import static org.junit.Assert.*;

public class CommentDaoIt {

    private CommentDao daoComment = new DefaultCommentDao(HibernateTestConfiguration.getFACTORY());

    @Test
    public void testCreate() {

        Comment comment = daoComment.createComment("CommentText", new Date(1000));

        assertNotNull(comment);

        assertEquals("CommentText", comment.getText());
        assertEquals(new Date(1000), comment.getCommentedAt());

        assertNotEquals(0, comment.getCommentId());

    }

}
