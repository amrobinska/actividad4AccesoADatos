package requerimiento1;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LecturaXML {

	public static void main(String[] args) {
		
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder analizador;
		Document doc;
		Node raiz;
		
		try {
			analizador = fabrica.newDocumentBuilder();
			doc = analizador.parse("concierto.xml");
			raiz = doc.getDocumentElement();
			recorrerNodos(raiz);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void recorrerNodos(Node raiz) {

		NodeList nodos = raiz.getChildNodes();

		Node fecha = nodos.item(0).getChildNodes().item(0);
		Node hora = nodos.item(1).getChildNodes().item(0);
		System.out.println("Fecha y hora del concierto: " + fecha.getTextContent() + " " + hora.getTextContent());
		System.out.println("Participan los siguientes grupos:");
		
		NodeList participantes = raiz.getChildNodes().item(2).getChildNodes();
		
		for (int i=0; i<participantes.getLength();i++) {
			
			Node nodoHijo = participantes.item(i);
			Node entrada = nodoHijo.getChildNodes().item(0);
			Node grupo = nodoHijo.getChildNodes().item(1);
			System.out.println("  " + entrada.getTextContent() + " " + grupo.getTextContent());

		}
	
	}
}
