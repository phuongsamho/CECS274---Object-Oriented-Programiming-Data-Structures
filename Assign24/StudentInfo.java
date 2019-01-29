// Modify this class to implement the HasVisit interface
// (as defined in the assignment and lecture)
public class StudentInfo implements HasVisit, HasClone<StudentInfo>
{
    public StudentInfo Clone()
    {
    	return new StudentInfo(this); 
    }

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
    public void Visit()
    {
	System.out.println(StudentName + " " + Grade);
    }

    public String StudentName;
    public char Grade;
};
