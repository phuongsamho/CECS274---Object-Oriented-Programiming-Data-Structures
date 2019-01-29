// The tester for the generic search tree assignment
// This file should not be changed.
public class TestGenericSearchTree
{
  static java.io.BufferedReader br;
  static  SearchTree<StudentKey,StudentInfo> autoTree =
      new SearchTree<StudentKey,StudentInfo>();
  public static StudentKey GetKey() throws java.io.IOException
  {
    String userInput;
    double NewWidget;
    int newID;
    System.out.print("Enter Widget ");
    userInput = br.readLine();
    NewWidget = Float.parseFloat(userInput);
    System.out.print("Enter StudentID ");
    userInput = br.readLine();
    newID = Integer.parseInt(userInput);
    StudentKey Answer = new StudentKey(NewWidget,newID);
    return Answer;
  };
  public static StudentInfo GetInfo() throws java.io.IOException
  {
    String userInput;
    String Name;
    char Grade;
    System.out.print("Enter Name ");
    Name = br.readLine();
    System.out.print("Enter Letter Grade ");
    userInput = br.readLine();
    Grade = userInput.charAt(0);
    StudentInfo Answer = new StudentInfo(Name,Grade);
    return Answer;
  };
  public static boolean TreeAdd(int keyStuff, String dataStuff,
    boolean shouldThrow)
  {
    StudentKey addKey = new StudentKey(keyStuff,keyStuff);
    StudentInfo addData = new StudentInfo(dataStuff,dataStuff.charAt(0));
    try
    {
      autoTree.Insert(addKey, addData);
    }
    catch (Exception e)
    {
      return shouldThrow;
    }
    return !shouldThrow;
  };
  public static boolean TreeFind(int keyStuff, boolean shouldThrow)
  {
    StudentKey addKey = new StudentKey(keyStuff,keyStuff);
    StudentInfo findData;
    try
    {
      findData = autoTree.Find(addKey);
    }
    catch (Exception e)
    {
      return shouldThrow;
    }
    return !shouldThrow;
  };
  public static boolean TreeUpdate(int keyStuff, String dataStuff,
    boolean shouldThrow)
  {
    StudentKey findKey = new StudentKey(keyStuff,keyStuff);
    StudentInfo newData = new StudentInfo(dataStuff,dataStuff.charAt(0));
    try
    {
      autoTree.Update(findKey,newData);
    }
    catch (Exception e)
    {
      return shouldThrow;
    }
    return !shouldThrow;
  };
  public static boolean TreeDelete(int keyStuff, boolean shouldThrow)
  {
    StudentKey addKey = new StudentKey(keyStuff,keyStuff);
    try
    {
      autoTree.Delete(addKey);
    }
    catch (Exception e)
    {
      return shouldThrow;
    }
    return !shouldThrow;
  };

  public static void main(String argv[]) throws java.io.IOException
  {
    SearchTree<StudentKey,StudentInfo> myTree =
      new SearchTree<StudentKey,StudentInfo>();
    String userInput;
    StudentKey key;
    StudentInfo data;
    int answer;
    br = new java.io.BufferedReader(
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
            key = GetKey();
            data = myTree.Find(key);
            System.out.println("Data was: ");
	    data.Visit();
            break;
          case 'i' :
            System.out.println("Enter key ");
            key = GetKey();
            System.out.println("Enter Data ");
            data = GetInfo();
	    data.Visit();
            myTree.Insert(key, data);
            break;
          case 'd' :
            System.out.println("Enter key ");
            key = GetKey();
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
          case 'u' :
            System.out.println("Enter key: ");
            key = GetKey();
            System.out.println("Enter Data: ");
            data = GetInfo();
            myTree.Update(key, data);
          default :
            break;
        }
      }
      catch (java.io.IOException e)
      {
        System.out.println("Bad input, try again");
      }
      catch (Exception e)
      {
        System.out.println("An execption got thrown, you've got a problem");
      };
    } while (userInput.charAt(0) != 'q');
    // Automatic tests
    System.out.println("Begin Automated Tests");
    boolean AutoGood = true;
    AutoGood &= TreeAdd(3, "c", false);
    AutoGood &= TreeAdd(3, "x", true);
    AutoGood &= TreeAdd(1, "a", false);
    AutoGood &= TreeAdd(2, "b", false);
    AutoGood &= TreeAdd(4, "d", false);
    AutoGood &= TreeAdd(5, "e", false);
    AutoGood &= TreeAdd(2, "x", true);
    AutoGood &= TreeFind(2,false);
    AutoGood &= TreeFind(5,false);
    AutoGood &= TreeFind(6,true);
    AutoGood &= TreeFind(0,true);
    AutoGood &= TreeUpdate(2,"B",false);
    AutoGood &= TreeUpdate(5,"E", false);
    AutoGood &= TreeUpdate(6,"X",true);
    AutoGood &= TreeUpdate(0,"X",true);
    AutoGood &= TreeDelete(6,true);
    AutoGood &= TreeDelete(0,true);
    AutoGood &= TreeDelete(2,false);
    AutoGood &= TreeDelete(5, false);

    if (AutoGood)
    {
      System.out.println("Automated Tests Passed");
    }
    else
    {
      System.out.println("Automated Tests Failed");
    }
  };
};
