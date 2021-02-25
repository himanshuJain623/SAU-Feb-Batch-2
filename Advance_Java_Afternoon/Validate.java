import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
public class Validate {
    public static void main(String[] args) {
        try{
            File file = new File("mergeLicenses.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc1 = db.parse(file);

            Document validDoc = db.newDocument();
            Document invalidDoc = db.newDocument();
            Element root1 = validDoc.createElement("CSR_Producer");
            validDoc.appendChild(root1);
            Element root2 = invalidDoc.createElement("CSR_Producer");
            invalidDoc.appendChild(root2);

            doc1.getDocumentElement().normalize();
            NodeList nodeList1 = doc1.getElementsByTagName("CSR_Producer");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		    LocalDate todayDate = LocalDate.of(2021,02,16);

            for (int i = 0; i < nodeList1.getLength(); ++i) {
                Node node = nodeList1.item(i);
                Element tElement1 = (Element) node;
                NodeList licensesList1 = tElement1.getElementsByTagName("License");
                // looping over all licenses in that CSR_Producer
                for (int j = 0; j < licensesList1.getLength(); j++) {
                    Element lic1 = (Element) licensesList1.item(j);
                    String led=lic1.getAttribute("License_Expiration_Date");
                    LocalDate leDate=LocalDate.parse(led, formatter);
                    if(leDate.compareTo(todayDate)>0){
                        Node license = validDoc.importNode(lic1, true);
                        root1.appendChild(license);
                    }
                    else{
                        Node license = invalidDoc.importNode(lic1, true);
                        root2.appendChild(license);
                    }
                }
            }
            // write into valid.xml
            Transformer tfactory = TransformerFactory.newInstance().newTransformer();
            tfactory.transform(new DOMSource(validDoc), new StreamResult(new File("valid.xml")));

            // write into invalid.xml
            tfactory.transform(new DOMSource(invalidDoc), new StreamResult(new File("invalid.xml")));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
