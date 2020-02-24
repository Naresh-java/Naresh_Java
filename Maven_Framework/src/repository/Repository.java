package repository;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Repository {
	static DocumentBuilder db;
	static DocumentBuilderFactory dmf;
	static Document doc;
	public static void loadRepository() {

		try {
			File  repFile= new File("C:\\Users\\NARESH\\git\\repository2\\Maven_Framework\\src\\repository\\test.xml");
			 dmf= DocumentBuilderFactory.newInstance();
			 db= dmf.newDocumentBuilder();
			doc = db.parse(repFile);
		} catch ( ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
	public static String[] getObjectInfo(String elementName){
		String[] objectInfo= new String[2];
		NodeList node= doc.getElementsByTagName(elementName);
		int nodeLength=node.getLength();
		if(nodeLength==1) {
			Element element=(Element) node.item(0);
			boolean isLocatorFound=element.hasAttribute("locator");
			boolean isValueFound= element.hasAttribute("value");
			if(isLocatorFound && isValueFound) {
				objectInfo[0]=element.getAttribute("locator");
				objectInfo[1]=element.getAttribute("value");
			}else {
				Assert.assertFalse(true,"Element "+elementName+""
											+ "	 does not have either locator or value");
			}
		}else {
			Assert.assertFalse(true,"Element "+elementName+""
					+ "	 does not have either locator or value");
		}

		return objectInfo;
	}
	public static By getBy(String elementName) {
		By by=null;
		String[] objInfo= getObjectInfo(elementName);
		
		switch (objInfo[0].toString()) {
		case "id":
			by=By.id(objInfo[1]);
			break;
		case "tagName":
			by=By.tagName(objInfo[1]);
			break;
		case "name":
			by=By.name(objInfo[1]);
			break;
		case "xpath":
			by=By.xpath(objInfo[1]);
			break;
		case "linktext":
			by=By.linkText(objInfo[1]);
			break;
		case "partiallinktext":
			by=By.partialLinkText(objInfo[1]);
			break;
		case "cssselector":
			by=By.cssSelector(objInfo[1]);
			break;
		case "classname":
			by=By.className(objInfo[1]);
			break;
		default:
			Assert.assertFalse(true,"Locator "+objInfo+" is invalid for the element : "
															+elementName+" is repository");
			break;
		}
		
		return by;
	}

}