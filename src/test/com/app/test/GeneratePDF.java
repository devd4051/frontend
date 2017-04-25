package com.app.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.io.FileUtils;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GeneratePDF{

	private static final String _DEST = "";
	
	private static final Properties  properties = new Properties();
	
	@Before
	public void loadProperties(){
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream("contents.properties"));
		} catch (IOException e) {
			
		}
	}
	
	@Test
	public void generatePDF(){
		try {
			FileUtils.writeByteArrayToFile(new File(_DEST), transformInsightsToPdf());
		} catch (Exception e) {
			
		}
	}
	
	
	private byte[] transformInsightsToPdf() throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		StringReader reader = new StringReader(prepareXML());
		StreamSource source = new StreamSource(reader);
		StreamSource transformSource = new StreamSource(getClass().getClassLoader().getResourceAsStream("stylesheet.xsl"));

		Transformer transformer = TransformerFactory.newInstance()
				.newTransformer(transformSource);
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());

		Fop fop = fopFactory.newFop("application/pdf",
				fopFactory.newFOUserAgent(), outStream);
		javax.xml.transform.Result res = new SAXResult(
				fop.getDefaultHandler());

		transformer.transform(source, res);

		return outStream.toByteArray();		
	}

	private String prepareXML() throws Exception {
		Document dom = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder().newDocument();
		Element root = dom.createElement("resume");
		dom.appendChild(root);
		DOMSource source = new DOMSource(dom);

		root = appendXMLData(dom, root, "name","Devaraj Gurikar ");
		
		root = appendXMLData(dom, root, "email","gurikar.devaraj@gmail.com");
		
		root = appendXMLData(dom, root, "contact","7204305688 ");
		
		Element contents = dom.createElement("contents");
		appendXMLData(dom, contents, "summary",properties.getProperty("summary"));
		root.appendChild(contents);
		
		Transformer transformer = TransformerFactory.newInstance()
				.newTransformer();
		StringWriter sw = new StringWriter();
		StreamResult sr = new StreamResult(sw);
		transformer.transform(source, sr);
		return sw.toString();
	}
	
	private Element appendXMLData(Document dom, Element parentNode,
			String childTagName, String childData) throws Exception {
		Element element = dom.createElement(childTagName);
		element.appendChild(dom.createTextNode(childData));
		parentNode.appendChild(element);
		return parentNode;
	}
	
}
