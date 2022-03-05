package jaxb;
import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;



public class MainXmlToObject {
	

		public static void main(String[] args) {
			try {
				JAXBContext contexto = JAXBContext.newInstance(Concierto.class);
				//Esta vez creamos un objeto que nos permite pasar
				//de XML a Object, es decir deserializar
				Unmarshaller u = contexto.createUnmarshaller();
				File fichero = new File("concierto1.xml");
				if (fichero.exists()) {
					Concierto c = (Concierto) u.unmarshal(fichero);
					System.out.println("Fecha y hora del concierto: " + c.getFecha() + " " + c.getHora());
					System.out.println("Participan los siguiente grupos: " );
					ArrayList<Participantes> participantes = c.getParticipantes();
					for(int i=0; i<participantes.size();i++) {
						String detalles = "";
						detalles = participantes.get(i).getEntrada() + " " + participantes.get(i).getGrupo();
						System.out.println(" " + detalles);
					}
				} else {
					System.out.println("Fichero XML concierto1.xml no encontrado");
				}

			} catch (JAXBException e) {
				System.out.println(e.getMessage());
			}
		}

}
