class TestDList
{
  public static void main(String argv[]) throws java.io.IOException
  {
    DoublyLinkedList myList = new DoublyLinkedList();
    int item;
    String userInput;
    java.io.BufferedReader br = new java.io.BufferedReader(
      new java.io.InputStreamReader(System.in));
    do
    {
      System.out.println("i)nsert, c)ount g)etlargest q)uit");
      System.out.println("enter choice: ");
      userInput = br.readLine();
      switch (userInput.charAt(0))
      {
        case 'i' :
          System.out.println("insert what item (enter an integer): ");
          userInput = br.readLine();
          item = Integer.parseInt(userInput);
          myList.Insert(item);
          break;
        case 'c' :
          System.out.println("The number of items in the list is: "
            + myList.Count());
          break;
        case 'g' :
          System.out.println("The largest in the list is "
            + myList.GetLargest());
          break;
        default :
          break;
      }
    } while (userInput.charAt(0) != 'q');
  };
};
