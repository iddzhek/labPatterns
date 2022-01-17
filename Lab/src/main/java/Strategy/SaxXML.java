package Strategy;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLFilterImpl;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.*;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class SaxXML implements Strategy{

    private static double middleMark;
    private static ArrayList<Student> student = new ArrayList<>();
    String pathFile = CreteFile.pathFile;
    String nameFile = CreteFile.nameFile;
    String file = pathFile + "/" + nameFile + ".xml";

    private static class XMLHandler extends DefaultHandler{
        private String element;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            String title;
            double mark;
            if (qName.equals("Subject")){
                title = attributes.getValue("title");
                mark = Double.parseDouble(attributes.getValue("mark"));
                student.add(new Student(title, mark));
            }
            element = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String information = new String(ch, start, length);

            information = information.replace("\n", "").trim();

            if(!information.isEmpty()){
                if(element.equals("Average")){
                    Student.average = Double.parseDouble(information);
                }
            }
        }
    }

    public static class Student{

        private String title;
        private double mark;
        private static double average;

        public Student(String title, double mark) {
            this.title = title;
            this.mark = mark;
        }
    }

    @Override
    public void execute(String file) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        if(!check(file)){
            System.out.println("The average estimate is not correct");
            correction(file);
            System.out.println("The average score has been corrected and is " + middleMark);
            return;
        }
        System.out.println("The average estimate correct");
    }

    @Override
    public boolean check(String file) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        XMLHandler xmlHandler = new XMLHandler();
        parser.parse(new File(file), xmlHandler);

        for (Student student : student)
            middleMark += student.mark;
        middleMark = middleMark/student.size();
        if(middleMark == Student.average) return true; else return false;
    }

    @Override
    public void correction(String file) throws TransformerException, SAXException, IOException {

        XMLReader xmlReader = new XMLFilterImpl(XMLReaderFactory.createXMLReader()){

            private String element;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    super.startElement(uri, localName, qName, attributes);
                element = qName;
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                String information = new String(ch, start, length);

                information = information.replace("\n", "").trim();

                if(!information.isEmpty()){
                    if(element.equals("Average")){
                        String m = String.valueOf(middleMark);
                        ch = m.toCharArray();
                        start = 0;
                        length = m.length();
                        super.characters(ch, start, length);
                    }
                }
            }
        };

        Source source = new SAXSource(xmlReader, new InputSource(file));
        Result result = new StreamResult(pathFile + "/" + nameFile + "1.xml");
//        Result result = new StreamResult(file);
        TransformerFactory.newInstance().newTransformer().transform(source, result);

        Path path = Path.of(file);
        Files.delete(path);

        Path path1 = Path.of(pathFile + "/" + nameFile + "1.xml");
        Path path2 = Path.of(file);
        Files.move(path1, path2);

    }
}
