package main.listeners;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Sesion implements HttpSessionListener {
	private final Logger log = LogManager.getRootLogger();

	@SuppressWarnings("unchecked")
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		log.info("sesionCreated");

		// cogemos la sesion
		HttpSession sesion = arg0.getSession();
		// recogemos nuestro context con get.
		ServletContext sc = sesion.getServletContext();
		// recogemos nuestro map donde guardaremos los valores.
		HashMap<String, HttpSession> map = (HashMap<String, HttpSession>) sc
				.getAttribute("map_usuario");
		// Metemos la sesion en el Map.
		map.put(sesion.getId(), sesion);

	}

	@SuppressWarnings("unchecked")
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		log.info("Sesion destruida");
		// cogemos la sesion
		HttpSession sesion = arg0.getSession();
		// eliminamos por id
		String id = sesion.getId();
		// recogemos nuestro mapa
		HashMap<String, HttpSession> map = (HashMap<String, HttpSession>) sesion
				.getServletContext().getAttribute("map_usuario");
		// Le decimos que elimine de forma automatica la id
		map.remove(id);
		log.info("HttpSession" + arg0.getSession().getId()
				+ " eliminada del map");
		log.info("HttpSession con id" + arg0.getSession().getId()
				+ " cookie eliminada");

	}

}
