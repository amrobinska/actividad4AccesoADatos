package requerimiento2.entidad;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="concierto")
//Podemos hacer que las etiquetas salgan en un determinado orden
//etiqueta opcional
@XmlType(propOrder = {
		"fecha",
	    "hora",
	    "listaParticipantes"
	})

public class Concierto {
	private String fecha, hora;
	private List<Participante> listaParticipantes;
	
	public Concierto() {
		listaParticipantes = new ArrayList<Participante>();
	}

	@XmlElement
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@XmlElement
	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@XmlElement(name = "participante")
	@XmlElementWrapper(name = "participantes")
	public List<Participante> getListaParticipantes() {
		return listaParticipantes;
	}

	public void setListaParticipantes(List<Participante> listaParticipantes) {
		this.listaParticipantes = listaParticipantes;
	}

	@Override
	public String toString() {
		return "Concierto [fecha=" + fecha + ", hora=" + hora + ", listaParticipantes=" + listaParticipantes + "]";
	}
	
	
}
