package requerimiento2.entidad;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="participante")

@XmlType(propOrder = {
		"entrada",
	    "grupo",
	})

public class Participante {
	String entrada, grupo;

	public Participante() {
		
	}

	public Participante(String entrada, String grupo) {
		super();
		this.entrada = entrada;
		this.grupo = grupo;
	}

	@XmlElement
	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	@XmlElement
	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	@Override
	public String toString() {
		return "Participante [entrada=" + entrada + ", grupo=" + grupo + "]";
	}
	
	
}
