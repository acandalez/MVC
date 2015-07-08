package main.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet Filter implementation class AccessControl
 */
@WebFilter("/AccessControl")
public class FiltroControlAcceso implements Filter {
	private final Logger log = LogManager.getRootLogger();

	/**
	 * Default constructor.
	 */
	public FiltroControlAcceso() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletRequest hsrequest = (HttpServletRequest) request;
		HttpServletResponse hsresponse = (HttpServletResponse) response;
		String url = hsrequest.getRequestURI();
		HttpSession sesion = hsrequest.getSession();

		// Session sesion = SesionManager.getSessionFactory();
		// pass the request along the filter chain

		if (sesion != null) {
			chain.doFilter(request, response);
		} else if (url.contentEquals("Servlet/ServletAutentication")
				|| url.contentEquals("/Servlet/")) {
			chain.doFilter(request, response);
			ServletContext sc = hsrequest.getServletContext();
			sc.setAttribute("url", url);
			log.info(sc.getAttribute("uri"));
		} else {
			ServletContext sc = hsrequest.getServletContext();
			sc.setAttribute("url", url);
			log.info(sc.getAttribute("url"));
			hsresponse.sendRedirect("/WebProject/");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
