package com.app.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

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
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GeneratePDF{

	private static final String _DEST = "G://Resume.pdf";
	
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
		Element root = dom.createElement("insights");
		dom.appendChild(root);
		DOMSource source = new DOMSource(dom);

		Transformer transformer = TransformerFactory.newInstance()
				.newTransformer();
		StringWriter sw = new StringWriter();
		StreamResult sr = new StreamResult(sw);
		transformer.transform(source, sr);
		return sw.toString();
	}
}
