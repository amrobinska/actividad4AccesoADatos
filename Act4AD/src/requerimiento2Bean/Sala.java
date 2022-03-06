package requerimiento2Bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="sala")

public class Sala {
	private String numeroSala;
	private String nombre;
	
		
	public Sala() {
		super();
	}
	public Sala(String numeroSala, String nombre) {
		super();
		this.numeroSala = numeroSala;
		this.nombre = nombre;
	}
	public String getNumeroSala() {
		return numeroSala;
	}
	public void setNumeroSala(String numeroSala) {
		this.numeroSala = numeroSala;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Sala [numeroSala=" + numeroSala + ", nombre=" + nombre + "]";
	}
	
	

}
