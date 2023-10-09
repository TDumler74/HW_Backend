package hibernate;

import hibernate.domain.Event;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EntityManagerDemo {
    public static void main(String[] args) {
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        EntityManager em = factory.createEntityManager();
        Event event = em.find(Event.class,1);
        System.out.println(event);

    }
}
