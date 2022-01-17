package Strategy;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class DomXML implements Strategy{

    private Document document;
    private double average;
    private double middleMark;
    String pathFile = CreteFile.pathFile;
    String nameFile = CreteFile.nameFile;

    @Override
    public void execute(String file) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        if (!check(file)){
            System.out.println("The average estimate is not correct");
            correction(file);
            System.out.println("The average score has been corrected and is " + middleMark);
            return;
        }
        System.out.println("The average estimate correct");
    }

    @Override
    public boolean check(String file) throws ParserConfigurationException, IOException, SAXException {

        double generalValue = 0;

        DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document =  builder.parse(new File(file));
        document.getDocumentElement().normalize();

        NodeList listSubject = document.getElementsByTagName("Subject");
        for (int i = 0; i < listSubject.getLength(); i++){

            Node node = listSubject.item(i);
            Element element = (Element) node;
            double value = Double.parseDouble(element.getAttribute("mark"));
            generalValue += value;
        }
        middleMark = generalValue/listSubject.getLength();

        NodeList listAverage = document.getElementsByTagName("Average");
        Node node = listAverage.item(0);
        Element element = (Element) node;
        average = Double.parseDouble(element.getTextContent());

        if (middleMark == average) return true; else return false;
    }

    @Override
    public void correction(String file) throws TransformerException {

        NodeList listAverage = document.getElementsByTagName("Average");
        Node node = listAverage.item(0);
        Element element = (Element) node;
        element.setTextContent(String.valueOf(middleMark));

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(file);
        transformer.transform(source, result);
    }
}
