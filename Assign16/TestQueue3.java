// Modify this file by making the queue references generic
// to complete the assignment.
class TestQueue3
{
  public static void  main(String arvg[]) throws java.io.IOException,Exception
  {
    // A queue of student records
    Queue<StudentRecord> myQueue = new Queue<StudentRecord>();
    String userInput;
    StudentRecord item = new StudentRecord();
    java.io.BufferedReader br = new java.io.BufferedReader(
      new java.io.InputStreamReader(System.in));
    do
    {
      System.out.println(
        "s)tore, d)elete, r)etrieve, summarize f)orward, summarize b)ackward  q)uit");
      userInput = "";
      try
      {
        System.out.println("enter choice: ") ;
         userInput = br.readLine();
        switch (userInput.charAt(0))
        {
          case 's' :
            System.out.println("enter student id (an integer): ") ;
            userInput = br.readLine();
            item.StudentID = Integer.parseInt(userInput);
            System.out.println("enter student grade (a character): ");
            userInput = br.readLine();
            item.Grade = userInput.charAt(0);
            myQueue.Store(new StudentRecord (item));
            break;
          case 'd' :
            System.out.println("deleting front of queue");
            myQueue.Delete();
            break;
          case 'r' :
            System.out.println("retrieving front of queue: ");
            item = myQueue.Retrieve();
            System.out.println("Contents of front of queue: StudentID "
               + item.StudentID);
            System.out.println(" Grade " + item.Grade);
            break;
          case 'f' :
            System.out.println("The items in the queue (front to back) are: ");
            myQueue.SummarizeForward();
            break;
          case 'b' :
            System.out.println("The items in the queue (back to front) are: ");
            myQueue.SummarizeBackward();
            break;
          default :
            break;
        }
      }
      catch (Queue.EmptyException e)
      {
        System.out.println("Queue empty execption");
      }
      catch (Exception e)
      {
        System.out.println("Probably Bad Input, try again");
      }
    } while (userInput.charAt(0) != 'q');

    // Special tests to make sure the queue is generic
    // DO NOT MODIFY anything below this line
    Queue<Fraction>  FractionQueue = new Queue<Fraction>();
    Fraction F0 = new Fraction(1,4);
    Fraction F1 = new Fraction(2,4);
    Fraction F2 = new Fraction(3,4);
    FractionQueue.Store(F0);
    FractionQueue.Store(F1);
    FractionQueue.Store(F2);
    Fraction F3=FractionQueue.Retrieve();
    System.out.println("Expect 1/4 " + F3.ToString());
  };
};
