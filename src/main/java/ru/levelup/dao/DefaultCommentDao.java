package ru.levelup.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.domain.Comment;

import java.util.Date;

public class DefaultCommentDao implements CommentDao {

    private SessionFactory factory;

    public DefaultCommentDao(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Comment createComment(String text, Date commentedAt) {

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Comment comment = new Comment();

        comment.setText(text);
        comment.setCommentedAt(commentedAt);

        session.persist(comment);

        transaction.commit();
        session.close();

        return comment;
    }
}
