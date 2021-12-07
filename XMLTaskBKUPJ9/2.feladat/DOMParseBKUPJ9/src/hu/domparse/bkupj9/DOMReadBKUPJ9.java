
package hu.domparse.bkupj9;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.IOException;

public class DOMReadBKUPJ9 {

	public static void main(String[] args)
	
			throws ParserConfigurationException, IOException, SAXException {

		        File xml = new File("XMLBKUPJ9.xml"); //Az XML file beolvasása
		        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //DocumentBuilderFactory inicializálása
		        
		        DocumentBuilder docBuilder = factory.newDocumentBuilder(); // A builder példányosítása
		        Document document = docBuilder.parse(xml); //A dokumentum konvertálása hogy értse az xml-t
		        document.getDocumentElement().normalize(); 
		        
		        ReadFile(document); //Kiíratjuk az összes adatot
		    }
		
		public static void ReadFile(Document document) { //Az adatok beolvasása és kiíratása
			
			  NodeList nodeList1 = document.getElementsByTagName("szenzorállomás"); //Lista létrehozása a gyermekelemeknek a szenzorállomás kulcsszóra
		        for (int i = 0; i < nodeList1.getLength(); i++) {
		            Node szNode = nodeList1.item(i);

		            if (szNode.getNodeType() == Node.ELEMENT_NODE) { //Elemek id-hez adása
		                Element element1 = (Element) szNode;
		                String kozpont_id = element1.getAttribute("központID"); //Attribútumok eltárolása
		                String szenzor_id = element1.getAttribute("szenzorID");
		                
		                Node szNode1 = element1.getElementsByTagName("szélirány").item(0); //Elemek eltárolása
		                String szelirany = szNode1.getTextContent();
		                
		                Node szNode2 = element1.getElementsByTagName("szélsebesség").item(0);
		                String szelsebesseg = szNode2.getTextContent();
		                
		                Node szNode3 = element1.getElementsByTagName("páratartalom").item(0);
		                String paratartalom = szNode3.getTextContent();
		                
		                Node szNode4 = element1.getElementsByTagName("hõmérséklet").item(0);
		                String homerseklet = szNode4.getTextContent();
		                
		                Node szNode5 = element1.getElementsByTagName("légnyomás").item(0);
		                String legnyomas = szNode5.getTextContent();
		                
		                System.out.println("Szenzorállomás adatok: Központ ID: " + kozpont_id + ", Szenzor ID: " + szenzor_id + ", szélirány: " 
						+ szelirany + ", szélsebesség: " + szelsebesseg + ", páratartalom: " + paratartalom + ", hõmérséklet: " + homerseklet + "."); //Az eltárolt adatok kiírása
		                
		            }
		        }
		       
		        NodeList nodeList2 = document.getElementsByTagName("elosztóközpont");
		        for (int i = 0; i < nodeList2.getLength(); i++) {
		            Node eloNode = nodeList2.item(i);
		            
		            if (eloNode.getNodeType() == Node.ELEMENT_NODE) {
		                Element element2 = (Element) eloNode;
		                String elorejelzo_id = element2.getAttribute("elõrejelzõID");
		                String kozpont_id = element2.getAttribute("központID");
		                String monitor_id = element2.getAttribute("monitorID");
		                String szenzor_id = element2.getAttribute("szenzorID");
		                
		                Node eloNode1 = element2.getElementsByTagName("elosztandóAdat").item(0);
		                String elosztandoAdat = eloNode1.getTextContent();
		                
		                System.out.println("Elosztóközpont adatok: elõrejelzõ ID: " + elorejelzo_id + ", Központ ID: " + kozpont_id + ", Monitor ID: "
						+ monitor_id +", Szenzor ID: "+ szenzor_id+ ", ElosztandóAdat: " + elosztandoAdat);
		            }
		        }
		        
		        NodeList nodeList3 = document.getElementsByTagName("elõrejelzõállomás");
		        for (int i = 0; i < nodeList3.getLength(); i++) {
		            Node elorNode = nodeList3.item(i);
		            
		            if (elorNode.getNodeType() == Node.ELEMENT_NODE) {
		                Element element3 = (Element) elorNode;
		                String elorejelzo_id = element3.getAttribute("elõrejelzõID");
		                String kozpont_id = element3.getAttribute("központID");
		                
		                Node elorNode1 = element3.getElementsByTagName("megbecsültIdõjárás").item(0);
		                String megbecsult_idojaras = elorNode1.getTextContent();
		                
		                Node elorNode2 = element3.getElementsByTagName("nyersadatok").item(0);
		                String nyersadatok = elorNode2.getTextContent();
		                		                
		                System.out.println("Elõrejlzõállomás adatok: Elõrejelzõ ID: " + elorejelzo_id + ", TKözpont ID " + kozpont_id + ", Megbecsült Idõjárás" 
		                + megbecsult_idojaras + ", Nyersadatok: " + nyersadatok);
		            }
		     }
		        
		        NodeList nodeList4 = document.getElementsByTagName("monitorozás");
		        for (int i = 0; i < nodeList4.getLength(); i++) {
		            Node mNode = nodeList4.item(i);
		            
		            if (mNode.getNodeType() == Node.ELEMENT_NODE) {
		                Element element4 = (Element) mNode;
		                String kozpont_id = element4.getAttribute("központId");
		                String monitor_id = element4.getAttribute("monitorID");
		                
		                Node mNode1 = element4.getElementsByTagName("várhatóIdõjárás").item(0);
		                String varhatoIdojaras = mNode1.getTextContent();
		                
		                Node mNode2 = element4.getElementsByTagName("aktuálisIdõjárás").item(0);
		                String aktualisIdojaras = mNode2.getTextContent();
		                
		                Node mNode3 = element4.getElementsByTagName("idõ").item(0);
		                String ido = mNode3.getTextContent();
		                
		                Node mNode4 = element4.getElementsByTagName("elmúltIdõjárás").item(0);
		                String elmultIdojaras = mNode4.getTextContent();
		                
		                Node mNode5 = element4.getElementsByTagName("elõrejelzésPontossága").item(0);
		                String elorejelzesPontossaga = mNode5.getTextContent();
		                
		                System.out.println("Monitorozás adatok: Központ ID: " + kozpont_id + ", Monitor ID: " + monitor_id + 
		                		", Várható Idõjárás: " + varhatoIdojaras + ", Aktuális Iõjárás: " + aktualisIdojaras + ", GIdõ: " + ido +
						", ElmúltIdõjárás: " + elmultIdojaras + ".");
				}    
			}
		        
		        
		}

}
