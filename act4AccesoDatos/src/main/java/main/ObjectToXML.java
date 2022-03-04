package main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


import beans.Gimnasio;
import beans.Socio;


public class ObjectToXML {

	public static void main(String[] args) {
		
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(Gimnasio.class);
			
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
			
			//creamos el gimnasio con sus socios
			Gimnasio gimnasio = new Gimnasio();
			gimnasio.setNombre("caos");
			gimnasio.setDireccion("Paseo de la direccion");
			
			gimnasio.getSocios().add(new Socio(1, "Alfonso", "Olivas Garcia", "Calle Goya 86", "9144422233"));
			gimnasio.getSocios().add(new Socio(2, "Alexandra", "Mendoza Robinska", "Calle Pez Volador 24", "913332211"));
			gimnasio.getSocios().add(new Socio(3, "Maria", "Perez Martinez", "Calle Alcala 33", "915552233"));
			gimnasio.getSocios().add(new Socio(4, "Miguel", "Dominguez Dominguez", "Calle Sirio 34", "913334411"));
			
			m.marshal(gimnasio, new File("gimnasio.xml"));
			System.out.println("El archivo gimnasio.xml ha sido creado con exito");
			
		} catch (JAXBException e) {
			System.out.println("Error convertiendo el objeto a formato XML");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
