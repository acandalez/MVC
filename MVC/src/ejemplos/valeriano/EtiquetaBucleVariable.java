package ejemplos.valeriano;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class EtiquetaBucleVariable extends SimpleTagSupport {

	private int num;

	@Override
	public void doTag() throws JspException, IOException {

		PageContext pc = (PageContext) getJspContext();

		for (int i = 0; i < num; i++) {
			// TANTO EL REQUEST COMO EL PAGECONTEXT SON SAQUITOS QUE USAREMOS
			// DEPENDIENDO DE LA DURACION DE LA SESION
			pc.getRequest().setAttribute("count",
					String.valueOf(i + 1/* i vale 1 */));
			// EQUIVALENCIA
			// getJspContext().setAttribute("count",
			// String.valueOf(i + 1/* i vale 1 */));
			getJspBody().invoke(null);

		}

	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
