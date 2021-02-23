import java.io.Serializable;

public class Student implements Serializable{
    public int roll;
    public int marks;
    public String subject;
    public Student(int roll,int marks,String subject){
        this.roll=roll;
        this.marks=marks;
        this.subject=subject;
    }
}
