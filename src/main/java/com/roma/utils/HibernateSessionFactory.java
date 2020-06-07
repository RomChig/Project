package com.roma.utils;

import com.roma.models.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

    private static SessionFactory factory;

    public static SessionFactory getSessionFactory() {
        if (factory == null) {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(User.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            factory = configuration.buildSessionFactory(builder.build());
        }
        return factory;
    }
}