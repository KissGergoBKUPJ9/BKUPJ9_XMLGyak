package hu.domparse.bkupj9;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMQueryBKUPJ9 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		File file = new File("XMLBKUPJ9.xml");//Az XML file beolvas�sa
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();//DocumentBuilderFactory inicializ�l�sa
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();//A builder p�ld�nyos�t�sa
		 
		Document doc = dBuilder.parse(file);//A dokumentum konvert�l�sa hogy �rtse az xml-t
		doc.getDocumentElement().normalize();
		System.out.print("Gy�k�r element: ");//a gy�k�relem ki�rat�sa
        System.out.println(doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("szenzor�llom�s");//szenzor�llom�sok ment�se list�ba
        
        
        for (int i = 0; i < nList.getLength(); i++) {//szenzor�llom�s gyerek elemeinek megjelen�t�se a konzolon
        	Node node = nList.item(i);
            System.out.println("\nAktu�lis Elem : "+node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
            	Element elem = (Element) node;
            	System.out.println("ID:"+elem.getAttribute("szenzorID"));
            	NodeList nList2 = elem.getChildNodes();
            	for (int j = 0; j < nList2.getLength(); j++) {
            		Node node2 = nList2.item(j);
					if (node2.getNodeType() == Node.ELEMENT_NODE) {
						Element elem2 = (Element) node2;
						NodeList nList3 = elem2.getChildNodes();
						for (int k = 0; k < nList3.getLength(); k++) {
							Node node3 = nList3.item(k);
							if(node3.getNodeType()==Node.ELEMENT_NODE) {
								Element elem3 = (Element) node3;
								System.out.println(node3.getNodeName()+" : "+node3.getTextContent());
							}
						}
					}
				}
            }
		}
	}
}
