package ru.levelup.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.domain.Post;

import java.util.Date;

public class DefaultPostDao implements PostDao {

    private SessionFactory factory;

    public DefaultPostDao(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Post createPost(String title, String text, Date postedAt) {

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Post post = new Post();

        post.setTitle(title);
        post.setText(text);
        post.setPostedAt(postedAt);

        session.persist(post);

        transaction.commit();
        session.close();

        return post;
    }
}
