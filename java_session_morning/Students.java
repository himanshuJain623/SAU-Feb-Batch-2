import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Node;  
import org.w3c.dom.Element;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;  


public class Students {
    public static void main(String[] args) {
        // ----------- deserialize student.xml file --------------------
        try{
            File file = new File("student.xml");  
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);  
            doc.getDocumentElement().normalize();  
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName()); 
            NodeList nodeList = doc.getElementsByTagName("student");


            ArrayList<Student> students=new ArrayList<>();
            for (int itr = 0; itr < nodeList.getLength(); itr++)   
            {  
                Node node = nodeList.item(itr);  
                // System.out.println("\nNode Name :" + node.getNodeName());  
                if (node.getNodeType() == Node.ELEMENT_NODE)   
                {  
                    Element eElement = (Element) node;  
                    // System.out.println("Student roll number: "+ eElement.getElementsByTagName("roll").item(0).getTextContent());  
                    // System.out.println("Subject: "+ eElement.getElementsByTagName("subject").item(0).getTextContent());  
                    // System.out.println("Marks: "+ eElement.getElementsByTagName("marks").item(0).getTextContent());
                    
                    int roll=Integer.parseInt(eElement.getElementsByTagName("roll").item(0).getTextContent());  
                    String subject=eElement.getElementsByTagName("subject").item(0).getTextContent();  
                    int marks=Integer.parseInt(eElement.getElementsByTagName("marks").item(0).getTextContent());
                    students.add(new Student(roll,marks,subject));
                }  
            }
            students.sort( (a, b) -> a.roll-b.roll); 
            ArrayList<Student> tStudents=new ArrayList<>();
            if(students.size()>0)
                tStudents.add(new Student(students.get(0).roll,students.get(0).marks,"total-marks"));
            for(int i=1;i<students.size();i++){
                if(students.get(i).roll==tStudents.get(tStudents.size()-1).roll){
                    tStudents.get(tStudents.size()-1).marks+=students.get(i).marks;
                }
                else{
                    tStudents.add(new Student(students.get(i).roll,students.get(i).marks,"total-marks"));
                }
            }

            for(Student s:tStudents){
                System.out.println(s.roll+"----"+s.subject+"->"+s.marks);
            }

            
            // ------------------- serialize -----------------
            FileOutputStream fileOutputStream = new FileOutputStream("student.txt");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
            objectOutputStream.writeObject(tStudents);
            objectOutputStream.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}