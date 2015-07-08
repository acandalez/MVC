package ejemplos_valeriano;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class EtiquetaSimpleBucle extends SimpleTagSupport {

	private int num;

	@Override
	public void doTag() throws JspException, IOException {
		// sSystem.out.println(getJspBody().toString());
		StringWriter bodyamodificar = new StringWriter();
		getJspBody().invoke(bodyamodificar); // relleno la variable para poder
												// modificarla
		bodyamodificar = bodyamodificar.append("- MODIFICADO");
		// con el append equivale a concatenar.ahora bodyamodificar vale
		// "es esto" + "modificado".

		// Esto seria lo que vamos a rellenar en invoke
		getJspContext().getOut().println(
				"El body es = " + bodyamodificar + " ese es el body");

		for (int i = 0; i < num; i++) {

			getJspBody().invoke(null);
			// recorre el cuerpo original nveces ya que no metemos el objeto
			// modificado en el invoke osease invoke es un null para no insertar
			// "--MODIFICADO".

		}

	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
