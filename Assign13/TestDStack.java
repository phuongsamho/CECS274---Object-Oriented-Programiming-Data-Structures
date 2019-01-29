// Tester for assignment, CECS 274
// Do NOT modify, do NOT submit.
class TestDStack
{
  public static void  main(String arvg[]) throws java.io.IOException
  {
    DStack myStack = new DStack();
    String userInput;
    double item;
    java.io.BufferedReader br = new java.io.BufferedReader(
      new java.io.InputStreamReader(System.in));
    do
    {
      userInput = "";
      try
      {
        System.out.println(
          "s)tore, d)elete, e)mpty, r)etrieve, summarize f)orward, summarize b)ackward  q)uit");
        System.out.println("enter choice: ");
        userInput = br.readLine();
        switch (userInput.charAt(0))
        {
          case 's' :
            System.out.println("enter a number (a double): ");
            userInput = br.readLine();
            item = Float.parseFloat(userInput);
            myStack.Store(item);
            break;
          case 'd' :
            System.out.println("deleting top of stack:\n");
            myStack.Delete();
            break;
          case 'r' :
            System.out.println("retrieving top of stack:\n");
            item = myStack.Retrieve();
            System.out.println("Contents of top of stack: "
               + item);
            break;
          case 'f' :
            System.out.println("The items on the stack (top down) are: ");
            myStack.SummarizeForward();
            break;
          case 'b' :
            System.out.println("The items on the stack (bottom up) are: ");
            myStack.SummarizeBackward();
            break;
          case 'e' :
      if (myStack.Empty())
            {
              System.out.println("The stack is empty");
            }
            else
            {
              System.out.println("The stack is NOT empty");
            }
            break;
          default :
            break;
        }
      }
      catch (java.lang.NumberFormatException e)
      {
        System.out.println("Expected a double");
      }
      catch (DStack.EmptyException e)
      {
        System.out.println("Operation failed due to empty stack");
      };
    } while (userInput.charAt(0) != 'q');
  };
};
