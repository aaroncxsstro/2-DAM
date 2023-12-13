package Utilidades;


import java.util.logging.Logger;
import java.util.logging.Level;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
public class Utilidades {
	
    private static SessionFactory sessionFactory;
    private static SessionFactory buildSessionFactory() {
        try {
            Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
            StandardServiceRegistry standardRegistry = new
                    StandardServiceRegistryBuilder()
                    .configure("res/hibernate.cfg.xml").build();
            Metadata metaData = new
                    MetadataSources(standardRegistry).getMetadataBuilder().build();
            sessionFactory = metaData.getSessionFactoryBuilder().build();
            System.out.println("Ya tienes conexi n con tu base de datos!");
            return sessionFactory;
        } catch (Throwable ex) {
            System.err.println("Fall la creaci n de la factor a de sesiones inicial" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null)
            sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
}
