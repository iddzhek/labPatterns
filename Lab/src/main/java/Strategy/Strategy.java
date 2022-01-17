package Strategy;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public interface Strategy {

    void execute(String file) throws IOException, SAXException, ParserConfigurationException, TransformerException;

    boolean check(String file) throws ParserConfigurationException, IOException, SAXException;

    void correction(String file) throws TransformerException, ParserConfigurationException, SAXException, IOException;
}
