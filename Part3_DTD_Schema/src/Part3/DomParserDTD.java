package Part3;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class DomParserDTD {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		boolean flag = true;
		String error = "none";
		try {
			// Validates the XML Document against DTD
			DTDValidation("employee.xml");
		}

		// Catches the validation error and stores in error variable
		catch (ParserConfigurationException e) {
			flag = false;
			error = e.getMessage();
		} catch (FileNotFoundException e) {
			flag = false;
			error = e.getMessage();
		} catch (SAXException e) {
			flag = false;
			error = e.getMessage();
		} catch (IOException e) {
			flag = false;
			error = e.getMessage();
		}

		if (flag == true) {
			System.out.println("XML file is validated against the DTD");

			// Parse XML Document
			parseXmlDom("employee.xml");
		} else {
			// Prints the error message if any error is caught
			System.out.println("Error is - " + error);
		}
	}

	// Validate XML Document against DTD
	public static void DTDValidation(String xmlFile)
			throws ParserConfigurationException, FileNotFoundException, SAXException, IOException {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setValidating(true);
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		documentBuilder.setErrorHandler(new ErrorHandler() {
			public void error(SAXParseException exception) throws SAXException {
				throw exception;
			}

			public void fatalError(SAXParseException exception) throws SAXException {
				throw exception;
			}

			public void warning(SAXParseException exception) throws SAXException {
				throw exception;
			}
		});
		documentBuilder.parse(new FileInputStream(xmlFile));

	}

	// Parses XML Document
	public static void parseXmlDom(String xml) throws SAXException, IOException, ParserConfigurationException {
		// Get Document Builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		// Build Document
		Document document = builder.parse(new File(xml));

		// Normalize the XML Structure
		document.getDocumentElement().normalize();

		// Here comes the root node
		Element root = document.getDocumentElement();
		System.out.println("\nRoot Element: " + root.getNodeName());

		// Get all Employee's
		NodeList nList = document.getElementsByTagName("employee");

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node node = nList.item(temp);
			System.out.println("");
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				
				// Print each Employee's detail
				Element eElement = (Element) node;
				System.out.println("Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
				System.out.println("Age : " + eElement.getElementsByTagName("age").item(0).getTextContent());
				System.out.println("Role : " + eElement.getElementsByTagName("role").item(0).getTextContent());
				System.out.println("Gender : " + eElement.getElementsByTagName("gender").item(0).getTextContent());
			}
		}
	}
}
