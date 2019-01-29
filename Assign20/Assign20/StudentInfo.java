// Modify this class to implement the HasVisit interface
// (as defined in the assignment and lecture)
public class StudentInfo implements HasVisit
{   public void Visit(){
	System.out.println("name : "+StudentName+"Grade : "+Grade);
     };
    public StudentInfo(StudentInfo Item)
    {
      StudentName = Item.StudentName;
      Grade = Item.Grade;
    };
    public StudentInfo(String iName, char iGrade)
    {
      StudentName = iName;
      Grade = iGrade;
    }
    public StudentInfo()
    {
    };
    public String StudentName;
    public char Grade;
};
