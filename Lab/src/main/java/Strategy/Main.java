package Strategy;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TransformerException {

//        "./src/main/resources/Strategy.xml"

//        String pathFile = CreteFile.pathWayFile();
//        String name = CreteFile.nameFile();
//        String file = pathFile + "/" + name + ".xml";
        String pathFile = "./src/main/resources/";
        String file = pathFile + args[0];

        DomXML domXML = new DomXML();
        domXML.execute(file);

//        SaxXML saxXML = new SaxXML();
//        saxXML.execute(file);
    }
}
