package main.listeners;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

import main.SesionManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;

public class Context implements ServletContextListener {
	private final Logger log = LogManager.getRootLogger();

	/**
	 * SERVLET CONTEST ES COMO UN SACO Y VIVE EN TODO EL TRANSCURSO DE LA
	 * APLICACION
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		log.info("contextDestroyed");
		SessionFactory sf = null;
		ServletContext sc = null;

		sc = arg0.getServletContext();// Es un espacio donde
		// podemos meter
		// objetos.

		// Obtengo la sesion y le asignamos el atributo.
		sf = (SessionFactory) sc.getAttribute("sf");

		// Cerramos la sesion.
		sf.close();

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

		log.info("contextInitialized");
		SessionFactory sf = null;
		ServletContext sc = null;
		Map<String, HttpSession> usuarios_activos = null;

		// Obtengo el objeto de ServletContext
		sc = arg0.getServletContext();// Es un espacio donde
										// podemos meter
										// objetos.
		sf = SesionManager.getSessionFactory();
		sc.setAttribute("sf"/* identificador */, sf/* Objeto */);

		// Con esto vamos a almacenar los usuarios activos sabiendo su nombre y
		// sesion.
		usuarios_activos = new HashMap<String, HttpSession>();

		// Ahora lo metemos en el context por medio del setAttribute.
		sc.setAttribute("map_usuario", usuarios_activos);

	}
}
