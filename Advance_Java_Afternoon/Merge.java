import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.HashMap;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class Merge {
    public static void main(String[] args) {
        try {
            File file1 = new File("License1.xml");
            File file2 = new File("License2.xml");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc1 = db.parse(file1);
            Document doc2 = db.parse(file1);
            Document totalDoc = db.newDocument();
            Element root = totalDoc.createElement("CSR_Producer");
            totalDoc.appendChild(root);

            doc1.getDocumentElement().normalize();
            doc2.getDocumentElement().normalize();
            HashMap<String,Element> map1=new HashMap<>();

            NodeList nodeList1 = doc1.getElementsByTagName("CSR_Producer");
            NodeList nodeList2 = doc2.getElementsByTagName("CSR_Producer");

            // looping over all licenses in nodeList1 and
            // generate key  NIPR_Number,StateCode, licenseNumber,EffectiveDate
            // and store that license into hashmap

            // looping over  CSR_Producer lsist
            for (int i = 0; i < nodeList1.getLength(); ++i) {
                Node node = nodeList1.item(i);
                Element tElement1 = (Element) node;
                StringBuilder key=new StringBuilder(tElement1.getAttribute("NIPR_Number"));
                NodeList licensesList1 = tElement1.getElementsByTagName("License");
                // looping over all licenses in that CSR_Producer
                for (int j = 0; j < licensesList1.getLength(); j++) {
                    Element lic1 = (Element) licensesList1.item(j);
                    key.append("#");
                    key.append(lic1.getAttribute("State_Code"));
                    key.append("#");
                    key.append(lic1.getAttribute("License_Number"));
                    key.append("#");
                    key.append(lic1.getAttribute("Date_Status_Effective"));
                    map1.put(key.toString(), lic1);
                }
            }

            // looping over all licenses in nodeList2 and
            // generate key  NIPR_Number,StateCode, licenseNumber,EffectiveDate
            // and check that license exists into hashmap map1

            // looping over  CSR_Producer list
            for (int i = 0; i < nodeList2.getLength(); ++i) {
                Node node = nodeList2.item(i);
                Element tElement2 = (Element) node;
                StringBuilder key=new StringBuilder(tElement2.getAttribute("NIPR_Number"));
                NodeList licensesList2 = tElement2.getElementsByTagName("License");
                // looping over all licenses in that CSR_Producer
                for (int j = 0; j < licensesList2.getLength(); j++) {
                    Element lic2 = (Element) licensesList2.item(j);
                    key.append("#");
                    key.append(lic2.getAttribute("State_Code"));
                    key.append("#");
                    key.append(lic2.getAttribute("License_Number"));
                    key.append("#");
                    key.append(lic2.getAttribute("Date_Status_Effective"));
                    if(map1.containsKey(key.toString())){
                        Node license = totalDoc.importNode(lic2, true);
                        root.appendChild(license);
                    }
                }
            }

            // write into mergeLicenses.xml
            Transformer tfactory = TransformerFactory.newInstance().newTransformer();
            tfactory.transform(new DOMSource(totalDoc), new StreamResult(new File("mergeLicenses.xml")));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}