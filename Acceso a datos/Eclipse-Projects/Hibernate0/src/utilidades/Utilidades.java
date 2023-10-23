package utilidades;

import java.util.logging.Logger;

import java.util.logging.Level;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Utilidades {

	// Factoria de sesi�n para crear objeto sesi�n a partir de XML
	private static SessionFactory sessionFactory;

	private static SessionFactory buildSessionFactory() {
		try {

			Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml").build();
			Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			sessionFactory = metaData.getSessionFactoryBuilder().build();
			System.out.println("Ya tienes conexi�n con tu base de datos!");
			return sessionFactory;
		} catch (Throwable ex) {
			// En un caso real se registra en un log
			System.err.println("Fall� la creaci�n de la factor�a de sesiones inicial." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/*
	 * M�todo est�tico (Fachada) para crear la factor�a de sesiones
	 */
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			sessionFactory = buildSessionFactory();
		return sessionFactory;
	}

}
