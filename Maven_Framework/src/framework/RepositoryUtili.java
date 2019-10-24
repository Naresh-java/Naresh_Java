package framework;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class RepositoryUtili {
	public static void loadRepositoryFile(String filePath) {
		try {
			File file = new File(filePath);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Data.repFile = db.parse(file);

		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String[] getObjectInfo(String elementName) {
		String[] objectInfo = new String[2];

		NodeList nodeList = Data.repFile.getElementsByTagName(elementName);
		int nodeLength = nodeList.getLength();
		if (nodeLength == 1) {
			Element element = (Element) nodeList.item(0);
			boolean isLocaterAttributeFound = element.hasAttribute("locator");
			boolean isValueAttributeFound = element.hasAttribute("value");
			if (isValueAttributeFound && isLocaterAttributeFound) {
				objectInfo[0] = element.getAttribute("locator");
				objectInfo[1] = element.getAttribute("value");

			} else {
				Assert.assertFalse(true, "Element : " + elementName + " dosn't have "
						+ "either loactor attribute or value attribute in Repository ");
			}

		} else {
			Assert.assertFalse(true, "Element '" + elementName + "'"
					+ " have Multiple Elements ");
		}
		return objectInfo;
	}

	public static By getBy(String elementName) {
		By by = null;
		String[] object = getObjectInfo(elementName);
		switch (object[0]) {
		case "id":
			by = By.id(object[1]);
			break;
		case "name":
			by = By.name(object[1]);
			break;

		case "linktext":
			by = By.linkText(object[1]);
			break;

		case "partiallinktext":
			by = By.partialLinkText(object[1]);
			break;

		case "xpath":
			by = By.xpath(object[1]);
			break;

		case "cssselector":
			by = By.cssSelector(object[1]);
			break;

		case "classname":
			by = By.className(object[1]);
			break;

		case "tagname":
			by = By.tagName(object[1]);
			break;

		default:
			Assert.assertTrue(false,
					"Locator : " + object[0] + " is invalid for the element :"
							+ "" + elementName + " in the repository");
			break;
		}

		return by;

	}
}
