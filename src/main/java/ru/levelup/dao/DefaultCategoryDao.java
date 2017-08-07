package ru.levelup.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.domain.Category;

public class DefaultCategoryDao implements CategoryDao {

    private SessionFactory factory;

    public DefaultCategoryDao(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Category createCategory(String name) {

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Category category = new Category();

        category.setName(name);

        session.persist(category);

        transaction.commit();
        session.close();

        return category;
    }
}
