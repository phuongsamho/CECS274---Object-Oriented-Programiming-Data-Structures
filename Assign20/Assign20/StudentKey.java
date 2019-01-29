// Modify this class to implement the Comparable interface
public class StudentKey implements Comparable<StudentKey>
{
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
    public int compareTo(StudentKey N)
    {
      return StudentID-N.StudentID;
    }
    public StudentKey()
    {
    };
    public double Widget;
    public int StudentID;
};
