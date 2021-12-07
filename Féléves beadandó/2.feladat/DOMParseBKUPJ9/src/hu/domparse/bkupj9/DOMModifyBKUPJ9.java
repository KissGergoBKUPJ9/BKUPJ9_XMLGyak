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
        
		String xmlFilePath = "XMLBKUPJ9.xml"; //File beolvasása
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File(xmlFilePath));
		
		Node masodikMonitorozás = document.getElementsByTagName("monitorozás").item(1); //A 2. monitorozás elem gyerekelemeinek megkeresése
		NodeList masodikMonitorozásNodeList = masodikMonitorozás.getChildNodes();
		
		for (int i = 0; i < masodikMonitorozásNodeList.getLength(); i++) { //A 2. monitorozás elem aktuális idõjárásának megváltoztatása naposra
			Node element = masodikMonitorozásNodeList.item(i);
			if ("aktuálisIdõjárás".equals(element.getNodeName())) {
				element.setTextContent("napos");
			}
		}
		
		Element monitorozo = document.createElement("monitorozó"); //A 2. monitorozás elemhez hozzáadjuk a monitorozó nevét
		monitorozo.appendChild(document.createTextNode("Béla"));
		masodikMonitorozás.appendChild(monitorozo);
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance(); //A módosításokat feltöltjük az XML file-ba
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File(xmlFilePath));
		transformer.transform(source, result);
		
		System.out.println("Változtatások sikeresen eszközölve az XML file-on!!!!"); //Nyugtázzuk az elvégzett módosításokat
		}
	}
}
