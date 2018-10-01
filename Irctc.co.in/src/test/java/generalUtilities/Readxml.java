package generalUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

public class Readxml {
	Document document;
	FileInputStream inputFile;
	SAXReader saxReader;
	String xmlFile;

	public Readxml(String xmlFile) {
		// TODO Auto-generated constructor stub
		this.xmlFile = xmlFile;
	}

	// \\testData\\properties.xml System.getProperty("user.dir") +

	public Document readxmlFile() {
		try {
			inputFile = new FileInputStream(xmlFile);
			saxReader = new SAXReader();
			document = saxReader.read(inputFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return document;
	}

	public String getMenuData(String TagName, String Value) {
		document = readxmlFile();
		return TagName = document.selectSingleNode(Value).getText();
	}

}