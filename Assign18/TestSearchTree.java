// The tester for the first search tree assignment
class TestSearchTree
{
  // Check if we have the expected Height and Size 
  private static boolean AutoCheck(SearchTree T, int Ht, int Sz)
  {
    if (T.Size() != Sz)
      return false;
    if (T.Height() != Ht)
      return false;
    return true;
  }
  public static void main(String argv[]) throws Exception
  {
    SearchTree myTree = new SearchTree();
    String userInput;
    int key;
    double data;
    int answer;
    boolean AutoGood = true;
    java.io.BufferedReader br = new java.io.BufferedReader(
      new java.io.InputStreamReader(System.in));
    do
    {
      userInput = "";
      try
      {
        System.out.println(
          "r)eport, f)ind, i)nsert, d)elete, s)ize, h)eight q)uit");
        System.out.println("enter choice: ");
        userInput = br.readLine();
        switch (userInput.charAt(0))
        {
          case 'r' :
            myTree.Report();
            System.out.println(" ");
            break;
          case 'f' :
            System.out.println("Enter key ");
            userInput = br.readLine();
            key = Integer.parseInt(userInput);
            data = myTree.Find(key);
            System.out.println("Data was " + data);
            break;
          case 'i' :
            System.out.println("Enter key ");
            userInput = br.readLine();
            key = Integer.parseInt(userInput);
            System.out.println("Enter Data ");
            userInput = br.readLine();
            data = Float.parseFloat(userInput);
            myTree.Insert(key, data);
            break;
          case 'd' :
            System.out.println("Enter key ");
            userInput = br.readLine();
            key = Integer.parseInt(userInput);
            myTree.Delete(key);
            break;
          case 's' :
            answer = myTree.Size();
            System.out.println("Tree size is " + answer);
            break;
          case 'h' :
            answer = myTree.Height();
            System.out.println("Tree height is " + answer);
            break;
          default :
            break;
        }
      }
      catch (Exception e)
      {
        System.out.println("Oops, try again");
      }
    } while (userInput.charAt(0) != 'q');

    System.out.println("Automatic Testing");
    SearchTree autoTree = new SearchTree();

    AutoGood = AutoCheck(autoTree,0 ,0);
    autoTree.Insert(4, 4.4);
    AutoGood &= AutoCheck(autoTree,1 ,1);
    autoTree.Insert(6, 6.6);
    AutoGood &= AutoCheck(autoTree,2 ,2);
    autoTree.Insert(5, 5.5);
    AutoGood &= AutoCheck(autoTree,3 ,3);
    autoTree.Insert(2, 2.2);
    AutoGood &= AutoCheck(autoTree,3 ,4);
    autoTree.Insert(3, 3.3);
    AutoGood &= AutoCheck(autoTree,3 ,5);
    autoTree.Insert(1, 1.1);
    AutoGood &= AutoCheck(autoTree,3 ,6);
    autoTree.Insert(7, 7.7);
    AutoGood &= AutoCheck(autoTree,3 ,7);
    autoTree.Insert(8, 8.8);
    AutoGood &= AutoCheck(autoTree,4 ,8);

    if (AutoGood)
      System.out.println("Good");
    else
      System.out.println("Bad");
    System.out.println("Automatic Testing Done");

  };
};
