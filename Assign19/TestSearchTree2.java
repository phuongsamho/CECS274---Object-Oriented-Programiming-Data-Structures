// The tester for the second search tree assignment
class TestSearchTree2
{
  public static void main(String argv[]) throws Exception
  {
    SearchTree myTree = new SearchTree();
    String userInput;
    int key;
    double data;
    int answer;
    // boolean AutoGood = true;
    java.io.BufferedReader br = new java.io.BufferedReader(
      new java.io.InputStreamReader(System.in));
    do
    {
      userInput = "";
      try
      {
        System.out.println(
          "r)eport, f)ind, i)nsert, d)elete, s)ize, h)eight u)pdate q)uit");
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
	  case 'u':
            System.out.println("Enter key ");
            userInput = br.readLine();
            key = Integer.parseInt(userInput);
            System.out.println("Enter Data ");
            userInput = br.readLine();
            data = Float.parseFloat(userInput);
            myTree.Update(key, data);
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

    // Automated tests of the Update function

    System.out.println("Begin automated tests of the Update function");
    SearchTree autoTree = new SearchTree();
    try
    {
      // Build a tree
      autoTree.Insert(4, 44.0);
      autoTree.Insert(2, 22.0);
      autoTree.Insert(1, 11.0);
      autoTree.Insert(3, 33.0);
      autoTree.Insert(6, 66.0);
      autoTree.Insert(5, 55.0);
      autoTree.Insert(8, 88.0);
      autoTree.Insert(7, 77.0);

      // Update the nodes
      autoTree.Update(1, 100.0);
      autoTree.Update(2, 200.0);
      autoTree.Update(3, 300.0);
      autoTree.Update(4, 400.0);
      autoTree.Update(5, 500.0);
      autoTree.Update(6, 600.0);
      autoTree.Update(7, 700.0);
      autoTree.Update(8, 800.0);

      // See if the updates are done

      boolean autoOK = true;
      autoOK = autoOK && (autoTree.Find(1)==100.0);
      autoOK = autoOK && (autoTree.Find(2)==200.0);
      autoOK = autoOK && (autoTree.Find(3)==300.0);
      autoOK = autoOK && (autoTree.Find(4)==400.0);
      autoOK = autoOK && (autoTree.Find(5)==500.0);
      autoOK = autoOK && (autoTree.Find(6)==600.0);
      autoOK = autoOK && (autoTree.Find(7)==700.0);
      autoOK = autoOK && (autoTree.Find(8)==800.0);

      if (autoOK)
        System.out.println("Automated tests passed");
      else
        System.out.println("Automated tests failed");

    }
    catch (Exception e)
    {
      System.out.println("Automated tests failed");
    }

  };
};
