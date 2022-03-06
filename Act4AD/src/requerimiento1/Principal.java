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
		
		try {
			analizador = fabrica.newDocumentBuilder();
			// Creamos nuevo documento
			doc = analizador.newDocument();
			// Añadimos elemento raiz
			Element concierto = doc.createElement("Concierto");
			doc.appendChild(concierto);
			// Añadimos tres contactos al elemento raíz agenda.
			agregarConcierto(concierto, doc);
			// Guardamos en disco el nuevo documento XML.
			guardar(doc);
			
			System.out.println("El archivo se ha creado con éxito");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void agregarConcierto(Element concierto, Document doc) {
		
		Element fecha= doc.createElement("fecha");
		Text textoFecha = doc.createTextNode("20-10-2018");
		fecha.appendChild(textoFecha);
		concierto.appendChild(fecha);
		
		Element hora=doc.createElement("hora");
		Text textohora=doc.createTextNode("21:30");
		hora.appendChild(textohora);
		concierto.appendChild(hora);
		
		Element participantes =doc.createElement("participantes");
		concierto.appendChild(participantes);
		
		Element participante=doc.createElement("participante");
		participantes.appendChild(participante);
		
		Element entrada=doc.createElement("entrada");
		participante.appendChild(entrada);
		Text horaEntrada=doc.createTextNode("21:30");
		entrada.appendChild(horaEntrada);
		Element grupo=doc.createElement("grupo");
		participante.appendChild(grupo);
		Text nombreGrupo=doc.createTextNode("Las Ardillas de Dakota");
		grupo.appendChild(nombreGrupo);
		
		participante=doc.createElement("participante");
		participantes.appendChild(participante);
		
		entrada=doc.createElement("entrada");
		participante.appendChild(entrada);
		horaEntrada=doc.createTextNode("22:15");
		entrada.appendChild(horaEntrada);
		
		grupo=doc.createElement("grupo");
		participante.appendChild(grupo);
		nombreGrupo=doc.createTextNode("fito y fitipaldis");
		grupo.appendChild(nombreGrupo);
		
		
		participante=doc.createElement("participante");
		participantes.appendChild(participante);
		
		entrada=doc.createElement("entrada");
		participante.appendChild(entrada);
		horaEntrada=doc.createTextNode("23:00");
		entrada.appendChild(horaEntrada);
		
		grupo=doc.createElement("grupo");
		participante.appendChild(grupo);
		
		nombreGrupo=doc.createTextNode("Coldplay");
		grupo.appendChild(nombreGrupo);
		
		
		
		
		
		
		
		
		
	}
	private static void guardar(Document doc) throws TransformerException {
		TransformerFactory fabricaConversor = TransformerFactory.newInstance();
		Transformer conversor = fabricaConversor.newTransformer();
		DOMSource fuente = new DOMSource(doc); 
		StreamResult resultado = new StreamResult(new File("concierto.xml"));
		conversor.transform(fuente, resultado);
	}
}