// The tester for the generalized queue.
// Modify this file to add casts and new's on the store and
// retrieve portions of the upper part.
class TestQueue2
{
  public static void  main(String arvg[]) throws java.io.IOException,Exception
  {
    Queue myQueue = new Queue();
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
            item = new StudentRecord ( (StudentRecord) myQueue.Retrieve());
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

    // Lower part. Do not modify the file below here.
    // This makes sure you have done the modification to Fraction
    // and that you don't have any stray references to StudentRecord
    // left in the Queue.
    Queue FractionQueue = new Queue();
    IFraction F0 = new IFraction(1,4);
    IFraction F1 = new IFraction(2,4);
    IFraction F2 = new IFraction(3,4);
    FractionQueue.Store(new IFraction(F0));
    FractionQueue.Store(new IFraction(F1));
    FractionQueue.Store(new IFraction(F2));
    // should be 1/4 2/4 3/4
    FractionQueue.SummarizeForward();
    // Make sure the ToString didn't get removed, prints 1/4
    System.out.println(F0.ToString());
  };
};
