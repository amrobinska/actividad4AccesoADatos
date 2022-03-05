package requerimiento1;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Principal {

	public static void main(String[] args) {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder analizador;
		Document doc;
		
		// A partir de la información de la actividad 4 creamos el concierto.xml
		try {
			analizador = fabrica.newDocumentBuilder();
			doc = analizador.newDocument();
			Element concierto = doc.createElement("concierto");
			doc.appendChild(concierto);
			
			Element fecha = doc.createElement("fecha");
			Text textoFecha = doc.createTextNode("20-oct-2018");
			fecha.appendChild(textoFecha);
			concierto.appendChild(fecha);
			
			Element hora = doc.createElement("hora");
			Text textoHora = doc.createTextNode("21:30");
			hora.appendChild(textoHora);
			concierto.appendChild(hora);
			
			// Añadimos los datos del concierto
			agregarParticipantes(concierto,doc);
			
			//Guardamos el documento XML
			guardar(doc);
			
			System.out.println("El documento concierto.xml se ha creado correctamente");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public static void agregarParticipantes(Element concierto, Document doc) {
		
		
		Element participantes = doc.createElement("participantes");
		concierto.appendChild(participantes);
		
		Element participante = doc.createElement("participante");
		participantes.appendChild(participante);

		Element entrada = doc.createElement("entrada");
		Text textoEntrada = doc.createTextNode("22:15");
		entrada.appendChild(textoEntrada);
		participante.appendChild(entrada);
		Element grupo = doc.createElement("grupo");
		Text textoGrupo = doc.createTextNode("Las Ardillas de Dakota");
		grupo.appendChild(textoGrupo);
		participante.appendChild(grupo);
			
		
		participante = doc.createElement("participante");
		participantes.appendChild(participante);

		entrada = doc.createElement("entrada");
		textoEntrada = doc.createTextNode("22:15");
		entrada.appendChild(textoEntrada);
		participante.appendChild(entrada);
		grupo = doc.createElement("grupo");
		textoGrupo = doc.createTextNode("Fito y Fitipaldis");
		grupo.appendChild(textoGrupo);
		participante.appendChild(grupo);
		
		participante = doc.createElement("participante");
		participantes.appendChild(participante);

		entrada = doc.createElement("entrada");
		textoEntrada = doc.createTextNode("23:00");
		entrada.appendChild(textoEntrada);
		participante.appendChild(entrada);
		grupo = doc.createElement("grupo");
		textoGrupo = doc.createTextNode("Coldplay");
		grupo.appendChild(textoGrupo);
		participante.appendChild(grupo);
	}
	
	private static void guardar(Document doc) throws TransformerException {
		TransformerFactory fabricaConversor = TransformerFactory.newInstance();
		Transformer conversor = fabricaConversor.newTransformer();
		DOMSource fuente = new DOMSource(doc);
		StreamResult resultado = new StreamResult(new File("concierto.xml"));
		conversor.transform(fuente,resultado);
	}

}
