package requerimiento2.main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import requerimiento2.entidad.Concierto;
import requerimiento2.entidad.Participante;

public class ObjectToXML {

	public static void main(String[] args) {
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(Concierto.class);
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			e.printStackTrace();			
			return;//Dejamos de ejecutar el metodo main
		}

		Marshaller m;
		try {
			m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			Concierto concierto = new Concierto();
			concierto.setFecha("20-oct-2018");
			concierto.setHora("21:30");
			
			concierto.getListaParticipantes().add(new Participante("21:30", "Las Ardillas de Dakota"));
			concierto.getListaParticipantes().add(new Participante("22:15", "Fito y Fitipaldis"));
			concierto.getListaParticipantes().add(new Participante("23:00", "Coldplay"));

			m.marshal(concierto, new File("concierto2.xml"));
			System.out.println("El archivo concierto2.xml ha sido creado con exito,"
					+ " refresque su eclipse :)");
		} catch (JAXBException e) {
			System.out.println("Error convertiendo el objeto a formato XML");
			e.printStackTrace();
		}

	}

}
