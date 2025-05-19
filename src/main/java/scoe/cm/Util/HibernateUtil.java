package scoe.cm.Util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import scoe.cm.Model.Contact;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();

            // Database connection properties (Without hibernate.cfg.xml)
            configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/contactdb?useSSL=false");
            configuration.setProperty("hibernate.connection.username", "root"); 
            configuration.setProperty("hibernate.connection.password", ""); 
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            configuration.setProperty("hibernate.show_sql", "true");
            configuration.setProperty("hibernate.hbm2ddl.auto", "update");

            // 🔹 Use HikariCP for better connection pooling
            configuration.setProperty("hibernate.hikari.minimumIdle", "2");
            configuration.setProperty("hibernate.hikari.maximumPoolSize", "10");
            configuration.setProperty("hibernate.hikari.idleTimeout", "30000");
            configuration.setProperty("hibernate.hikari.connectionTimeout", "30000");

            // Add annotated class
            configuration.addAnnotatedClass(Contact.class);

            // Build SessionFactory
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception ex) {
            System.err.println("SessionFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
