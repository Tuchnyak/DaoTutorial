package ru.levelup.hibernate.it;

import org.junit.Assert;
import org.junit.Test;
import ru.levelup.dao.CategoryDao;
import ru.levelup.dao.DefaultCategoryDao;
import ru.levelup.domain.Category;
import ru.levelup.hibernate.config.HibernateTestConfiguration;

import static org.junit.Assert.*;

public class CategoryDaoIT {

    private CategoryDao daoCat = new DefaultCategoryDao(HibernateTestConfiguration.getFACTORY());

    @Test
    public void testCreate() {

        Category cat = daoCat.createCategory("CatName");

        assertNotNull(cat);

        assertEquals("CatName", cat.getName());

        assertNotEquals(0, cat.getCategoryId());

    }

}
