// Modify this class to implement the Comparable interface
public class StudentKey implements Comparable<StudentKey>
{
    public int compareTo(StudentKey S)
    {
	return StudentID - S.StudentID;
    }		

    public StudentKey(StudentKey Item)
    {
      Widget = Item.Widget;
      StudentID = Item.StudentID;
    };
    public StudentKey(double iWidget, int iID)
    {
      Widget = iWidget;
      StudentID = iID;
    }
    public StudentKey()
    {
    };
    public double Widget;
    public int StudentID;
};
