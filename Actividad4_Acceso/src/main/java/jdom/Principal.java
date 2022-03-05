package jdom;

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
			Element concierto = doc.createElement("concierto");
			doc.appendChild(concierto);

			Element fecha = doc.createElement("fecha");
			concierto.appendChild(fecha);
			Text textoFecha = doc.createTextNode("20-oct-2018");
			fecha.appendChild(textoFecha);

			Element hora = doc.createElement("hora");
			concierto.appendChild(hora);
			Text textoHora = doc.createTextNode("21:30");
			hora.appendChild(textoHora);
			//Añadimos tres participantes
			CrearParticipantes(concierto, doc);
			// Guardamos en disco el nuevo documento XML.
			guardar(doc);

			System.out.println("El archivo se ha creado con éxito");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void CrearParticipantes(Element concierto, Document doc) {
		Element participantes = doc.createElement("participantes");
		concierto.appendChild(participantes);

		// participantes1
		Element participante = doc.createElement("participante");
		participantes.appendChild(participante);
		Element entrada = doc.createElement("entrada");
		participante.appendChild(entrada);
		Text textoEntrada = doc.createTextNode("21:30");
		entrada.appendChild(textoEntrada);
		Element grupo = doc.createElement("grupo");
		participante.appendChild(grupo);
		Text textoGrupo = doc.createTextNode("Las Ardillas De Dakota");
		grupo.appendChild(textoGrupo);

		// participante2

		participante = doc.createElement("participante");
		participantes.appendChild(participante);
		entrada = doc.createElement("entrada");
		participante.appendChild(entrada);
		textoEntrada = doc.createTextNode("22:15");
		entrada.appendChild(textoEntrada);
		grupo = doc.createElement("grupo");
		participante.appendChild(grupo);
		textoGrupo = doc.createTextNode("Fito y Fitipaldis");
		grupo.appendChild(textoGrupo);

		// participante3

		participante = doc.createElement("participante");
		participantes.appendChild(participante);
		entrada = doc.createElement("entrada");
		participante.appendChild(entrada);
		textoEntrada = doc.createTextNode("23:00");
		entrada.appendChild(textoEntrada);
		grupo = doc.createElement("grupo");
		participante.appendChild(grupo);
		textoGrupo= doc.createTextNode("Coldplay");
		grupo.appendChild(textoGrupo);

	}

	private static void guardar(Document doc) throws TransformerException {
		// fabrica de Transformes
		TransformerFactory fabricaConversor = TransformerFactory.newInstance();
		// creamos el objeto Transfomer, que nos permitira serializar el arbol
		// dom a un fichero
		Transformer conversor = fabricaConversor.newTransformer();
		// creamos la fuente de la cual sacaremos el arbol dom
		DOMSource fuente = new DOMSource(doc);
		// Creamos el flujo de salida, al fichero que queremos (tubito)
		StreamResult resultado = new StreamResult(new File("concierto.xml"));
		// por ultimo, serializamos los datos
		conversor.transform(fuente, resultado);
	}

}
