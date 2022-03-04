package main;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import beans.Gimnasio;
import beans.Socio;

public class XMLToObject {

	public static void main(String[] args) {
		try {
			JAXBContext contexto = JAXBContext.newInstance(Gimnasio.class);
			Unmarshaller u = contexto.createUnmarshaller();
			File fichero = new File("gimnasio.xml");
			if(fichero.exists()) {
				Gimnasio gimnasio = (Gimnasio) u.unmarshal(fichero);
				System.out.println("\nGIMNASIO: \n");
				System.out.println("- nombre: " + gimnasio.getNombre().toUpperCase());
				System.out.println("- dirección: " + gimnasio.getDireccion() + "\n");
				List<Socio> socios = gimnasio.getSocios();
				for(Socio socio: socios) {
					System.out.println("\n----------- Socio "+ socio.getId() + " -----------");
					System.out.println("\t- nombre: " +socio.getNombre());
					System.out.println("\t- apellidos: " +socio.getApellidos());
					System.out.println("\t- dirección: " +socio.getDireccion());
					System.out.println("\t- teléfono: " +socio.getTelefono());
				}
			} else {
				System.out.println("Fichero gimnasio.xml no encontrado");
			}
		} catch (JAXBException e) {
			System.out.println(e.getMessage());
		}

	}

}
