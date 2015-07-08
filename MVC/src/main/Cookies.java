package main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class Cookies
 */
@WebServlet("/Cookies")
public class Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger log = LogManager.getRootLogger();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cookies() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookies = request.getCookies();

		Cookie cookieaux = null;
		// Recorremos la array para saber si contiene información o nó.
		for (int i = 0; i < cookies.length; i++) {
			cookieaux = cookies[i];
			log.trace("Nombre Cookie i" + cookieaux.getName());
		}
		// Para cada cookie_actual recorremos el array de cookies y mostramos el
		// nombre de cada cookie en nuestro log
		for (Cookie cookie_actual : cookies) {
			log.trace(cookie_actual.getName());
		}

	}

	// Metodo para obtener una cookie
	@SuppressWarnings("unused")
	private Cookie obtenerCookie(HttpServletRequest request,
			String nombre_cookie) {
		Cookie cookie = null;
		Cookie[] array_cookie = null;
		boolean encontrada = false;
		array_cookie = request.getCookies();
		// posicion de la cookie
		int pos = 0;
		Cookie cookie_aux = null;
		if (null == array_cookie) {
			cookie = new Cookie(nombre_cookie, "0");
		} else {// hay cookies
			while ((pos < array_cookie.length) && (!encontrada)) {

				cookie_aux = array_cookie[pos];
				if (cookie_aux.getName().equals(nombre_cookie)) {

					encontrada = true;
					cookie = cookie_aux;
				} else {
					pos = pos + 1;
				}

			}

		}

		return cookie;
	}

}
