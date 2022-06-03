package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="objetoUI")
@ViewScoped
public class ObjetoUI {

	private String pruebaString = "";

	public String getPruebaString() {
		return pruebaString;
	}

	public void setPruebaString(String pruebaString) {
		this.pruebaString = pruebaString;
	}
}
