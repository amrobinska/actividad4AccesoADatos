package jaxb;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MainOjectToXML {

	public static void main(String[] args) {
		
		ArrayList<Participantes> participantes = new ArrayList<Participantes>();
		
		Participantes participante1 = new Participantes("21:30", "LAS ARDILLAS DE DAKOTA");
		Participantes participante2 = new Participantes("22:15", "FITO Y LOS FITIPALDIS");
		Participantes participante3 = new Participantes("23:00", "COLDPLAY");
		
		participantes.add(participante1);
		participantes.add(participante2);
		participantes.add(participante3);
		
		Concierto concierto1 = new Concierto("20-oct-2018", "21:30",participantes);
		
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

			
			m.marshal(concierto1, new File("concierto1.xml"));
			System.out.println("El archivo concierto1.xml ha sido creado con éxito");
		} catch (JAXBException e) {
			System.out.println("Error convertiendo el objeto a formato XML");
			e.printStackTrace();
		}
		
		

	}

}
