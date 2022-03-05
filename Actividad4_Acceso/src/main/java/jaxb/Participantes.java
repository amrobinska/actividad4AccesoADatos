package jaxb;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Participantes {

	private String entrada;
	private String grupo;
	
	
	public Participantes() {
		super();
	}

	public Participantes(String entrada, String grupo) {
		this.entrada = entrada;
		this.grupo = grupo;
	}

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	@Override
	public String toString() {
		return "Participantes [entrada=" + entrada + ", grupo=" + grupo + "]";
	}
	
	
}
