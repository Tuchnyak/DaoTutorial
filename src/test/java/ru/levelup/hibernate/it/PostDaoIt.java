package ru.levelup.hibernate.it;

import org.junit.Test;
import ru.levelup.dao.DefaultPostDao;
import ru.levelup.dao.PostDao;
import ru.levelup.domain.Post;
import ru.levelup.hibernate.config.HibernateTestConfiguration;

import java.util.Date;

import static org.junit.Assert.*;

public class PostDaoIt {

    private PostDao daoPost = new DefaultPostDao(HibernateTestConfiguration.getFACTORY());

    @Test
    public void testCreate() {

        Post post = daoPost.createPost("Post title",
                "Mnogo texta", new Date(1000));

        assertNotNull(post);

        assertEquals("Post title", post.getTitle());
        assertEquals("Mnogo texta", post.getText());
        assertEquals(new Date(1000), post.getPostedAt());

        assertNotEquals(0, post.getPostId());

    }

}
