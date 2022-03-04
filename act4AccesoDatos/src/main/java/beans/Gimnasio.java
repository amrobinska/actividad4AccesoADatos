package beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="gimnasio")
@XmlType(propOrder= {
		"nombre",
		"direccion",
		"socios"
})
public class Gimnasio {
	
	private String nombre, direccion;
	private List<Socio> socios;
	
	public Gimnasio() {
		socios = new ArrayList<Socio>();
	}

	@XmlElement(name="socio")
	@XmlElementWrapper(name="socios")
	public List<Socio> getSocios() {
		return socios;
	}

	public void setSocios(List<Socio> socios) {
		this.socios = socios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	
	
}
