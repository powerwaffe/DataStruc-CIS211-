package Demos;

/**
 * Created by Sean on 8/28/2016.
 */
public class Student {
    private Name fullName;
    private String id; //Identification number

    public Student()
    {
        fullName = new Name();
        id = "";
    } //end default constructor

    public Student(Name studentName, String studentID)
    {
        fullName = studentName;
        id = studentID;
    } //end constructor

    public void setStudent(Name studentName, String studentId)
    {
        setName(studentName); //Or fullName = studentName
        setId(studentId); //Or id = studentId
    } //end setStudent

    public void setName(Name studentName)
    {
        fullName = studentName;
    } //end setName

    public Name getName()
    {
        return fullName;
    } //end getName

    public void setId(String studentId)
    {
        id = studentId;
    } //end setId

    public String getId()
    {
        return id;
    } //end getId

    public String toString()
    {
        return id + " " + fullName.toString();
    }

    public static void main(String[] cheese)
    {
        Student student = new Student();
        Name studentName = new Name();
        studentName.setFirst("Wynn");
        studentName.setLast("Duffy");
        student.setId("125");
        student.setName(studentName);
        student.setStudent(studentName, "125");
        System.out.println(studentName.getFirst() + " " + studentName.getLast());
        System.out.println(student.getName() + " " + student.getId());

    }
}
