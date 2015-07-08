package main.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Request implements ServletRequestListener {
	private final Logger log = LogManager.getRootLogger();

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub

		log.info("requestDestroyed");

	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub

		log.info("requestInitialized");

	}

}
