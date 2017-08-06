package ru.levelup.hibernate.config;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ru.levelup.domain.*;

import java.util.Properties;

public class HibernateTestConfiguration {

    private static final SessionFactory FACTORY = buildFactory();

    private static SessionFactory buildFactory() {

        final ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(defineHibernateSettings())
                .build();

        return new Configuration()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Post.class)
                .addAnnotatedClass(UserDetails.class)
                .addAnnotatedClass(Comment.class)
                .addAnnotatedClass(Category.class)
                .buildSessionFactory(registry);

    }

    private static Properties defineHibernateSettings() {

        Properties properties = new Properties();

        properties.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        properties.setProperty("hibernate.connection.url", "jdbc:h2:mem:posts;INIT=create schema if not exists posts");
        properties.setProperty("hibernate.connection.username", "sa");
        properties.setProperty("hibernate.connection.password", "");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");

        return properties;

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {

    }

}
