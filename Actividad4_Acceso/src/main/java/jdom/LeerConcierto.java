package jdom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeerConcierto {
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
			//este metodo nos devuelve todos los nodos hijos Directos del elemento raiz "conciertos"
			NodeList nodos = raiz.getChildNodes();
			System.out.println("Fecha y hora del concierto: " + nodos.item(0).getTextContent() + " " + nodos.item(1).getTextContent());
			Node participantes = nodos.item(2);
			recorrerParticipantes(participantes);
			
		}
		private static void recorrerParticipantes(Node participantes) {
			
			NodeList nodos = participantes.getChildNodes();
			
			System.out.println("Participan los siguientes grupos: ");
			for (int i=0; i<nodos.getLength();i++) {
				Node participante = nodos.item(i);
				if(participante.getNodeType() == Node.ELEMENT_NODE) {
					Node hora = participante.getChildNodes().item(0);
					Node grupo = participante.getChildNodes().item(1);
					System.out.println("\t" + hora.getTextContent() + " " + grupo.getTextContent());
				}
			}
		}
	}