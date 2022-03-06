package requerimiento2Bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="cine")

public class Cine {
	private String nombre;
	private String direccion;
	private Sala sala;
	
	
	public Cine() {
		super();
	}
	public Cine(String nombre, String direccion, Sala sala) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.sala = sala;
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
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	@Override
	public String toString() {
		return "Cine [nombre=" + nombre + ", direccion=" + direccion + ", sala=" + sala + "]";
	}
}
