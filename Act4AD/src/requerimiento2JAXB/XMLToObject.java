package requerimiento2JAXB;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


import requerimiento2Bean.Cine;

public class XMLToObject {
	
	public static void main(String[] args) {
		try {
			JAXBContext contexto = JAXBContext.newInstance(Cine.class);
			Unmarshaller u = contexto.createUnmarshaller();
			File fichero = new File("Requerimiento2.xml");
			if (fichero.exists()) {
				Cine c = (Cine) u.unmarshal(fichero);
				
				System.out.println(c);
			} else {
				System.out.println("Fichero XML Requerimiento2.xml no encontrado");
			}

		} catch (JAXBException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
