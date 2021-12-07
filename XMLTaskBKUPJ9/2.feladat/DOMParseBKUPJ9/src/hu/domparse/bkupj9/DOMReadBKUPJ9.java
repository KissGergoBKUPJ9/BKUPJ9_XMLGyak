
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

		        File xml = new File("XMLBKUPJ9.xml"); //Az XML file beolvas�sa
		        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //DocumentBuilderFactory inicializ�l�sa
		        
		        DocumentBuilder docBuilder = factory.newDocumentBuilder(); // A builder p�ld�nyos�t�sa
		        Document document = docBuilder.parse(xml); //A dokumentum konvert�l�sa hogy �rtse az xml-t
		        document.getDocumentElement().normalize(); 
		        
		        ReadFile(document); //Ki�ratjuk az �sszes adatot
		    }
		
		public static void ReadFile(Document document) { //Az adatok beolvas�sa �s ki�rat�sa
			
			  NodeList nodeList1 = document.getElementsByTagName("szenzor�llom�s"); //Lista l�trehoz�sa a gyermekelemeknek a szenzor�llom�s kulcssz�ra
		        for (int i = 0; i < nodeList1.getLength(); i++) {
		            Node szNode = nodeList1.item(i);

		            if (szNode.getNodeType() == Node.ELEMENT_NODE) { //Elemek id-hez ad�sa
		                Element element1 = (Element) szNode;
		                String kozpont_id = element1.getAttribute("k�zpontID"); //Attrib�tumok elt�rol�sa
		                String szenzor_id = element1.getAttribute("szenzorID");
		                
		                Node szNode1 = element1.getElementsByTagName("sz�lir�ny").item(0); //Elemek elt�rol�sa
		                String szelirany = szNode1.getTextContent();
		                
		                Node szNode2 = element1.getElementsByTagName("sz�lsebess�g").item(0);
		                String szelsebesseg = szNode2.getTextContent();
		                
		                Node szNode3 = element1.getElementsByTagName("p�ratartalom").item(0);
		                String paratartalom = szNode3.getTextContent();
		                
		                Node szNode4 = element1.getElementsByTagName("h�m�rs�klet").item(0);
		                String homerseklet = szNode4.getTextContent();
		                
		                Node szNode5 = element1.getElementsByTagName("l�gnyom�s").item(0);
		                String legnyomas = szNode5.getTextContent();
		                
		                System.out.println("Szenzor�llom�s adatok: K�zpont ID: " + kozpont_id + ", Szenzor ID: " + szenzor_id + ", sz�lir�ny: " 
						+ szelirany + ", sz�lsebess�g: " + szelsebesseg + ", p�ratartalom: " + paratartalom + ", h�m�rs�klet: " + homerseklet + "."); //Az elt�rolt adatok ki�r�sa
		                
		            }
		        }
		       
		        NodeList nodeList2 = document.getElementsByTagName("eloszt�k�zpont");
		        for (int i = 0; i < nodeList2.getLength(); i++) {
		            Node eloNode = nodeList2.item(i);
		            
		            if (eloNode.getNodeType() == Node.ELEMENT_NODE) {
		                Element element2 = (Element) eloNode;
		                String elorejelzo_id = element2.getAttribute("el�rejelz�ID");
		                String kozpont_id = element2.getAttribute("k�zpontID");
		                String monitor_id = element2.getAttribute("monitorID");
		                String szenzor_id = element2.getAttribute("szenzorID");
		                
		                Node eloNode1 = element2.getElementsByTagName("elosztand�Adat").item(0);
		                String elosztandoAdat = eloNode1.getTextContent();
		                
		                System.out.println("Eloszt�k�zpont adatok: el�rejelz� ID: " + elorejelzo_id + ", K�zpont ID: " + kozpont_id + ", Monitor ID: "
						+ monitor_id +", Szenzor ID: "+ szenzor_id+ ", Elosztand�Adat: " + elosztandoAdat);
		            }
		        }
		        
		        NodeList nodeList3 = document.getElementsByTagName("el�rejelz��llom�s");
		        for (int i = 0; i < nodeList3.getLength(); i++) {
		            Node elorNode = nodeList3.item(i);
		            
		            if (elorNode.getNodeType() == Node.ELEMENT_NODE) {
		                Element element3 = (Element) elorNode;
		                String elorejelzo_id = element3.getAttribute("el�rejelz�ID");
		                String kozpont_id = element3.getAttribute("k�zpontID");
		                
		                Node elorNode1 = element3.getElementsByTagName("megbecs�ltId�j�r�s").item(0);
		                String megbecsult_idojaras = elorNode1.getTextContent();
		                
		                Node elorNode2 = element3.getElementsByTagName("nyersadatok").item(0);
		                String nyersadatok = elorNode2.getTextContent();
		                		                
		                System.out.println("El�rejlz��llom�s adatok: El�rejelz� ID: " + elorejelzo_id + ", TK�zpont ID " + kozpont_id + ", Megbecs�lt Id�j�r�s" 
		                + megbecsult_idojaras + ", Nyersadatok: " + nyersadatok);
		            }
		     }
		        
		        NodeList nodeList4 = document.getElementsByTagName("monitoroz�s");
		        for (int i = 0; i < nodeList4.getLength(); i++) {
		            Node mNode = nodeList4.item(i);
		            
		            if (mNode.getNodeType() == Node.ELEMENT_NODE) {
		                Element element4 = (Element) mNode;
		                String kozpont_id = element4.getAttribute("k�zpontId");
		                String monitor_id = element4.getAttribute("monitorID");
		                
		                Node mNode1 = element4.getElementsByTagName("v�rhat�Id�j�r�s").item(0);
		                String varhatoIdojaras = mNode1.getTextContent();
		                
		                Node mNode2 = element4.getElementsByTagName("aktu�lisId�j�r�s").item(0);
		                String aktualisIdojaras = mNode2.getTextContent();
		                
		                Node mNode3 = element4.getElementsByTagName("id�").item(0);
		                String ido = mNode3.getTextContent();
		                
		                Node mNode4 = element4.getElementsByTagName("elm�ltId�j�r�s").item(0);
		                String elmultIdojaras = mNode4.getTextContent();
		                
		                Node mNode5 = element4.getElementsByTagName("el�rejelz�sPontoss�ga").item(0);
		                String elorejelzesPontossaga = mNode5.getTextContent();
		                
		                System.out.println("Monitoroz�s adatok: K�zpont ID: " + kozpont_id + ", Monitor ID: " + monitor_id + 
		                		", V�rhat� Id�j�r�s: " + varhatoIdojaras + ", Aktu�lis I�j�r�s: " + aktualisIdojaras + ", GId�: " + ido +
						", Elm�ltId�j�r�s: " + elmultIdojaras + ".");
				}    
			}
		        
		        
		}

}
