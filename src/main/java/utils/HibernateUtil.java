package utils;


import entities.Client;
import entities.Planet;
import entities.Ticket;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final HibernateUtil INSTANCE = new HibernateUtil();

    private SessionFactory sessionFactory;

    private HibernateUtil(){
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }
    public static HibernateUtil getInstance() {
        return INSTANCE;
    }
    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }
    public void close() {
        sessionFactory.close();
    }
}