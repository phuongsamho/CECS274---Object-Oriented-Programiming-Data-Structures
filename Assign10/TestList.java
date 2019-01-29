class TestList
{
  public static void main(String argv[]) throws java.io.IOException
  {
    LinkedList myList = new LinkedList();
    int item;
    LinkedList.node retrieveAnswer;
    String userInput;
    java.io.BufferedReader br = new java.io.BufferedReader(
      new java.io.InputStreamReader(System.in));
    do
    {
      System.out.println(
        "i)nsert, d)elete, r)etrieve c)ount g)etLargest p)rint q)uit");
      userInput = br.readLine();
      switch (userInput.charAt(0))
      {
        case 'i':
          System.out.println("insert what item (enter an integer): ");
          userInput = br.readLine();
          item = Integer.parseInt(userInput);
          myList.Insert(item);
          break;
        case 'd' :
          System.out.println("delete what item (enter an integer): ");
          userInput = br.readLine();
          item = Integer.parseInt(userInput);
          myList.Delete(item);
          break;
        case 'r' :
          System.out.println("retrieve what item (enter an integer): ");
          userInput = br.readLine();
          item = Integer.parseInt(userInput);
          retrieveAnswer = myList.Retrieve(item);
          if (retrieveAnswer == null)
          {
            System.out.println("Item not found") ;
          }
          else
          {
            System.out.println("Found ");
          }
          break;
      case 'c' :
          // Test of student built Count method
          System.out.println("The number of items in the list is: " +
            myList.Count());
          break;
      case 'g' :
          // Test of student built GetLargest method
          System.out.println("The largest is: " + myList.GetLargest());
          break;
        case 'p' :
          System.out.println("Printing list");
          myList.Print();
          break;
        default :
          break;
      }
    } while (userInput.charAt(0) != 'q');
  };
};
