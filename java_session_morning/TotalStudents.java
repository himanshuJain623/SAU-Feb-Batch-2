import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class TotalStudents {
    public static void main(String[] args) {
        try{
            // ----------- deserialize student.txt file --------------------

            FileInputStream fileInputStream = new FileInputStream("student.txt");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
            Object object = objectInputStream.readObject();
            objectInputStream.close();
            ArrayList<Student> tstudents=(ArrayList<Student>)object;
            for(Student s:tstudents){
                System.out.println(s.roll+"->"+s.marks);
            }
            // ---------------  serialize the top 5 students' roll numbers and total marks into excel or csv file

            tstudents.sort( (a, b) -> b.marks-a.marks); 
            FileWriter fw = new FileWriter("topStudents.csv");
            fw.write("Rank, Roll No, Total Marks(out of 300\n");
            for(int i=0;i<(Math.min(5,tstudents.size()));i++)
            {
                fw.write(i+1 + "," + tstudents.get(i).roll + "," + tstudents.get(i).marks + "\n");
            }
            fw.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}