// For the first Queue assignment
public class StudentRecord
{
    public StudentRecord(StudentRecord Item)
    {
      StudentID = Item.StudentID;
      Grade = Item.Grade;
    };
    public StudentRecord(int iID, char iGrade)
    {
      StudentID = iID;
      Grade = iGrade;
    }
    public StudentRecord()
    {
    };
    public String toString()
    {
      return StudentID + " " + Grade + " ";
    };
    public int StudentID;
    public char Grade;
};
