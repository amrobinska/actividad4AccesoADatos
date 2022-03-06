package requerimiento2JAXB;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


import requerimiento2Bean.Cine;
import requerimiento2Bean.Sala;

public class ObjectToXML {
	
	public static void main(String[] args) {
		JAXBContext contexto;
		try {
			
			contexto = JAXBContext.newInstance(Cine.class);
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}

		Marshaller m;
		try {
			
			m = contexto.createMarshaller();
			
			
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
		
			Cine p = new Cine("Ideal", "Dr Cortezo 6", null);
			Sala Sala = new Sala();
			Sala.setNumeroSala("Cuatro");
			Sala.setNombre("Calle");
			
			p.setSala(Sala);
			
			//Convertimos un objeto a xml y lo imprimimos por pantalla
			m.marshal(p, System.out);
			//tambien podemos crear un fichero
			m.marshal(p, new File("Requerimiento2.xml"));
		} catch (JAXBException e) {
			System.out.println("Error convertiendo el objeto a formato XML");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
