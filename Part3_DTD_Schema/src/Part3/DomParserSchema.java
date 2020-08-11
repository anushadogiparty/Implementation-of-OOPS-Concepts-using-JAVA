package Part3;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class DomParserSchema {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		boolean flag = true;
		String error = "none";
		try {
			// Validate XML Document against Schema
			schemaValidation("employee.xml", "employee.xsd");
		}

		// Catches the validation error and stores in error variable
		catch (SAXException e) {
			flag = false;
			error = e.getMessage();
		} catch (IOException e) {
			flag = false;
			error = e.getMessage();
		}

		if (flag == true) {
			System.out.println("XML file is validated against XSD Schema");

			// Parse XML Document
			parseXmlDom("employee.xml");
		} else {
			
			// Prints if any error is caught
			System.out.println("Error is - " + error);
		}

	}

	// Validate XML Document against Schema
	public static void schemaValidation(String xmlFile, String validationFile) throws SAXException, IOException {
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		((schemaFactory.newSchema(new File(validationFile))).newValidator())
				.validate(new StreamSource(new File(xmlFile)));
	}

	// Parse XML Document
	public static void parseXmlDom(String xml) throws SAXException, IOException, ParserConfigurationException {
		// Get Document Builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		// Build Document
		Document document = builder.parse(new File(xml));

		// Normalize the XML Structure
		document.getDocumentElement().normalize();

		// Root node
		Element root = document.getDocumentElement();
		System.out.println("\nRoot XML Element: " + root.getNodeName());

		// Get all Employee's
		NodeList list = document.getElementsByTagName("employee");

		for (int temp = 0; temp < list.getLength(); temp++) {
			Node node = list.item(temp);
			System.out.println("");
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				
				// Print each employee's detail
				Element eElement = (Element) node;
				System.out.println("Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
				System.out.println("Age : " + eElement.getElementsByTagName("age").item(0).getTextContent());
				System.out.println("role : " + eElement.getElementsByTagName("role").item(0).getTextContent());
				System.out.println("gender : " + eElement.getElementsByTagName("gender").item(0).getTextContent());
			}
		}
	}
}
