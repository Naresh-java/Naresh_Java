package xml;

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

public class Read_Data_From_XML {
	public static void main(String[] args) {
		File file = new  File("D:\\JavaPractice\\Maven_Framework\\src\\xml\\Test.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getElementsByTagName("student"); 
			for (int itr = 0; itr < nodeList.getLength(); itr++)   
			{  
			Node node = nodeList.item(itr);  
			System.out.println("\nNode Name :" + node.getNodeName());  
			if (node.getNodeType() == Node.ELEMENT_NODE)   
			{  
			Element eElement = (Element) node;  
			System.out.println("Student id: "+ eElement.getElementsByTagName("id").item(0).getTextContent());  
			System.out.println("First Name: "+ eElement.getElementsByTagName("firstname").item(0).getTextContent());  
			System.out.println("Last Name: "+ eElement.getElementsByTagName("lastname").item(0).getTextContent());  
			System.out.println("Subject: "+ eElement.getElementsByTagName("subject").item(0).getTextContent());  
			System.out.println("Marks: "+ eElement.getElementsByTagName("marks").item(0).getTextContent());  
			}  
			}  
			}   catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

}
