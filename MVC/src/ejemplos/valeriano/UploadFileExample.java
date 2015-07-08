package ejemplos.valeriano;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UploadFileExample extends HttpServlet {

	Logger log = LogManager.getRootLogger();

	private String extraerRuta(String contentheader) {
		String ruta = null;

		ruta = contentheader.substring(contentheader.indexOf("filename=") + 10,
				contentheader.length() - 1);

		log.trace("Ruta obtenida =" + ruta);
		return ruta;
	}

	private String obtenerCabecera(HttpServletRequest request,
			String nombre_parte) throws IllegalStateException, IOException,
			ServletException {
		String cabecera = null;
		Collection<String> headers = null;
		Iterator<String> it = null;

		headers = request.getPart(nombre_parte).getHeaders(
				"content-disposition");
		it = headers.iterator();
		if (it.hasNext()) {
			cabecera = it.next();
		}

		return cabecera;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {

		String cabecera = obtenerCabecera(request, "fResumen");
		String nombre_fichero_origen = extraerRuta(cabecera);
		String nombre_fichero_destino = getServletConfig().getInitParameter(
				"RUTA_SUBIDA_FICHEROS")
				+ "\\" + nombre_fichero_origen;
		ServletOutputStream out = null;

		log.trace("Entro en doPost " + getClass().getName());
		int key = 0;
		// Hacer swich
		switch (key) {
		case 1:
			resp.setContentType("image/jpeg");

		case 2:
			resp.setContentType("image/png");

		case 3:
			resp.setContentType("application/pdf");

		case 4:
			resp.setContentType("application/zip");

		case 5:
			resp.setContentType("image/gif");

		case 6:
			resp.setContentType("application/msword");

		case 7:
			resp.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");

		case 8:
			resp.setContentType("application/vnd.ms-excel");

		case 9:
			resp.setContentType("application/vnd.ms-powerpoint");

		case 10:
			resp.setContentType("application/vnd.ms-powerpoint.presentation.macroEnabled.12");

		}

		// resp.setContentType("image/jpeg");
		out = resp.getOutputStream();
		try (InputStream f_entrada = request.getPart("fResumen")
				.getInputStream();
				FileOutputStream f_salida = new FileOutputStream(
						nombre_fichero_destino);) {

			byte array_intermedio[] = new byte[1024];
			int bytes_leidos = 0;
			while ((bytes_leidos = f_entrada.read(array_intermedio)) != -1) {
				out.write(array_intermedio, 0, bytes_leidos);
				f_salida.write(array_intermedio, 0, bytes_leidos);

			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.toString());
		}

	}

}
