//package Strategy;
//
//import org.w3c.dom.Attr;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerException;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//import java.io.File;
//
//public class CreateXML {
//
//    class Data{
//        private String student;
//        private int mark;
//        private double middleMark;
//
//    }
//
//    public void save (Data object, String file) throws ParserConfigurationException, TransformerException {
//
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        factory.setNamespaceAware(true);
//        Document doc = factory.newDocumentBuilder().newDocument();
//
//        Element tasks = doc.createElement("tasks");
//        doc.appendChild(tasks);
//
//        for (int i = 0; i < object.size; i++){
//
//            String getTitleTask = object.getTask(i).getTitle();
//            String getActiveTask = String.valueOf(object.getTask(i).isActive());
//            String getRepeatedTask = String.valueOf(object.getTask(i).isRepeated());
//            String getTimeTask = String.valueOf(object.getTask(i).getTime());
//            String getStartTask = String.valueOf(object.getTask(i).getStartTime());
//            String getEndTask = String.valueOf(object.getTask(i).getEndTime());
//            String getRepeatTask = String.valueOf(object.getTask(i).getRepeatInterval());
//
//            Element task = doc.createElement("task");
//            task.appendChild(doc.createTextNode(String.valueOf(getTitleTask)));
//
//            Attr attrActive = doc.createAttribute("active");
//            attrActive.setValue(getActiveTask);
//            task.setAttributeNode(attrActive);
//
//            Attr attrTime = doc.createAttribute("time");
//            attrTime.setValue(getTimeTask);
//            task.setAttributeNode(attrTime);
//
//            Attr attrStart = doc.createAttribute("start");
//            attrStart.setValue(getStartTask);
//            task.setAttributeNode(attrStart);
//
//            Attr attrEnd = doc.createAttribute("end");
//            attrEnd.setValue(getEndTask);
//            task.setAttributeNode(attrEnd);
//
//            Attr attrRepeat = doc.createAttribute("repeat");
//            attrRepeat.setValue(getRepeatTask);
//            task.setAttributeNode(attrRepeat);
//
//            Attr attrRepeated = doc.createAttribute("repeated");
//            attrRepeated.setValue(getRepeatedTask);
//            task.setAttributeNode(attrRepeated);
//
//            tasks.appendChild(task);
//        }
//
//        TransformerFactory transformerFactory = TransformerFactory.newInstance();
//        Transformer transformer = transformerFactory.newTransformer();
//        DOMSource domSource = new DOMSource(doc);
//        StreamResult streamResult = new StreamResult(new File(file));
//        transformer.transform(domSource, streamResult);
//    }
//}
