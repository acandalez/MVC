package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * SESION FACTORY SESSIONMANAGER USA EL PATRON SINGLETON YA QUE VAMOS A REALIZAR
 * UNA CONEXION A LA VEZ.
 * 
 * ESTA CLASE SE UTILIZA PARA GESTIONAR LAS SESIONES EN HIBERNATE
 */

public class SesionManager {
	private static SesionManager sm = new SesionManager();
	private static SessionFactory factory = null;

	static {
		factoryStart();
	}

	public static void factoryStart() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		if (factory == null) {
			factory = configuration.buildSessionFactory(builder.build());
		}
	}

	private SesionManager() {
	}

	public static SesionManager getInstance() {
		return sm;
	}

	public boolean comprobarEstadoFactory() {
		return (factory != null);
	}

	public Session getNewSession() {
		return factory.openSession();
	}

	public static SessionFactory getSessionFactory() {
		return factory;
	}

	public void sessionClose(Session session) throws Throwable {
		session.close();
	}

	public static void factoryClose() throws Throwable {
		factory.close();
	}
}