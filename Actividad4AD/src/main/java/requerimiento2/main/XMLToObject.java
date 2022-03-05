package requerimiento2.main;

import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import requerimiento2.entidad.Concierto;
import requerimiento2.entidad.Participante;

public class XMLToObject {

	public static void main(String[] args) {
		try {
			JAXBContext contexto = JAXBContext.newInstance(Concierto.class);
			Unmarshaller u = contexto.createUnmarshaller();
			File fichero = new File("concierto2.xml");
			
			if (fichero.exists()) {
				Concierto c = (Concierto) u.unmarshal(fichero);
				
				System.out.println("Fecha: " + c.getFecha());
				System.out.println("Hora: " + c.getHora() + "\n");
				
				List<Participante> listaParticipantes = c.getListaParticipantes();
				System.out.println("Participan los siguientes grupos:");			
				
				for(Participante p: listaParticipantes) {
					System.out.println("Entrada: " + p.getEntrada());
					System.out.println("Grupo: " + p.getGrupo() + "\n");
				}
				
			} else {
				System.out.println("Fichero XML concierto2.xml no encontrado");
			}

		} catch (JAXBException e) {
			System.out.println(e.getMessage());
		}

	}

}
