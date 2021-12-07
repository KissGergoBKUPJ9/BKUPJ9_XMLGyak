package hu.domparse.bkupj9;

import java.io.*;

import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;

import org.w3c.dom.*;
import org.xml.sax.*;

public class DOMModifyBKUPJ9 {

public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException, TransformerException { {
        
		String xmlFilePath = "XMLBKUPJ9.xml"; //File beolvas�sa
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File(xmlFilePath));
		
		Node masodikMonitoroz�s = document.getElementsByTagName("monitoroz�s").item(1); //A 2. monitoroz�s elem gyerekelemeinek megkeres�se
		NodeList masodikMonitoroz�sNodeList = masodikMonitoroz�s.getChildNodes();
		
		for (int i = 0; i < masodikMonitoroz�sNodeList.getLength(); i++) { //A 2. monitoroz�s elem aktu�lis id�j�r�s�nak megv�ltoztat�sa naposra
			Node element = masodikMonitoroz�sNodeList.item(i);
			if ("aktu�lisId�j�r�s".equals(element.getNodeName())) {
				element.setTextContent("napos");
			}
		}
		
		Element monitorozo = document.createElement("monitoroz�"); //A 2. monitoroz�s elemhez hozz�adjuk a monitoroz� nev�t
		monitorozo.appendChild(document.createTextNode("B�la"));
		masodikMonitoroz�s.appendChild(monitorozo);
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance(); //A m�dos�t�sokat felt�ltj�k az XML file-ba
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File(xmlFilePath));
		transformer.transform(source, result);
		
		System.out.println("V�ltoztat�sok sikeresen eszk�z�lve az XML file-on!!!!"); //Nyugt�zzuk az elv�gzett m�dos�t�sokat
		}
	}
}
