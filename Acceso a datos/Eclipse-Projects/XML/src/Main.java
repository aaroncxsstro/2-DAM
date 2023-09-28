import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws SAXException, IOException {
	Path path = Path.of("test.xml");
	File xml = path.toFile();
	
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	
	DocumentBuilder builder;
	try {
		builder = factory.newDocumentBuilder();
		Document document = builder.parse(xml);
		
		//TRATAR EL DOCUMENTO
		NodeList listaInicial = document.getElementsByTagName("Tests").item(0).getChildNodes();
		
		//LISTA ELEMENTOS
		
		for (int i = 0; i<listaInicial.getLength(); i++) {
			Node node = listaInicial.item(i);
			
			if(node.getNodeType()==Node.ELEMENT_NODE) {
			Element elemento = (Element) node;
			
			
			//IMPRIME ATRIBUTOS
			String id = elemento.getAttributes().getNamedItem("TestId").getNodeValue();
			System.out.println(node.getNodeName()+ "\t"+id);
			System.out.println();
			
			//IMPRIME ELEMENTOS
			System.out.println("Name"+getNodo("Name",elemento));
			System.out.println("CommandLine"+getNodo("CommandLine",elemento));
			}
		}
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		


	}
	
	public static String getNodo (String etiqueta, Element elem) {
		NodeList nodo = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
		Node valorNodo = (Node) nodo.item(0);
		
		return valorNodo.getNodeValue(); //devuelve el valor del nodo
		
	}

}
