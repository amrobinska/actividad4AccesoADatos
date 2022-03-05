package jaxb;

import java.util.ArrayList;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Concierto {

	private String fecha;
	private String hora;
	ArrayList<Participantes> participantes = new ArrayList<Participantes>();
	
	
	
	public Concierto() {
		super();
	}

	public Concierto(String fecha, String hora, ArrayList<Participantes> participantes) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.participantes = participantes;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public ArrayList<Participantes> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Participantes> participantes) {
		this.participantes = participantes;
	}

	@Override
	public String toString() {
		return "Concierto [fecha=" + fecha + ", hora=" + hora + ", participantes=" + participantes + "]";
	}
	
	
}
