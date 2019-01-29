// Tester for assignment 7, CECS 274
// Do NOT modify, do NOT submit.

class TestQueue
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
            myQueue.Store(item);
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
    // Special tests to make sure the class is doing copies.
    Queue copyTestQueue = new Queue();
    // To be used in the copy tests.
    StudentRecord testItem;
    item.Grade='A';
    item.StudentID= 321;
    copyTestQueue.Store(item);
    // modify the test item
    item.StudentID = 456;
    testItem = copyTestQueue.Retrieve();
    if (testItem.StudentID != 321)
    {
      // We put a 321 in, it got changed, Store probably didn't make a copy 
      System.out.println("Store failed");
    }
    else
    {
      System.out.println("Store worked");
      // Now test the retrieve.
      testItem.StudentID = 789;
      testItem = copyTestQueue.Retrieve();
      if (testItem.StudentID != 321)
      {
        //We put a 321 in, it got changed, Retrieve probably didn't make a copy 
        System.out.println("Retrieve failed");
      }
      else
      {
        System.out.println("Retrieve worked");
      }
    }
  };
};
