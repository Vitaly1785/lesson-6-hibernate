package ru.geekbrains.manager;

import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
@Component
public class HibernateManager {

    private static final EntityManagerFactory factory = new Configuration().configure("hibernate.xml").buildSessionFactory();
    private static EntityManager manager;
    private HibernateManager() {}

    public EntityManager getManager() {
        if (manager == null) {
            try {
                return factory.createEntityManager();
            } catch (Exception e) {
                System.out.println("Exception" + e);
            }
        }
        return manager;
    }
}
