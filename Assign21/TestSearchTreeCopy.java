// The tester for the tree copy assignment
// The student info and student key classes need
// to be modified to support HasClone.
public class TestSearchTreeCopy
{
  private static SearchTree<StudentKey,StudentInfo> SourceTree;
  public static void TreeAdd(int keyStuff, String dataStuff)
    throws Exception
  {
    StudentKey addKey = new StudentKey(keyStuff,keyStuff);
    StudentInfo addData = new StudentInfo(dataStuff,dataStuff.charAt(0));
    SourceTree.Insert(addKey, addData);
  };
  public static boolean TreeFind(
    SearchTree<StudentKey,StudentInfo> WhichTree,
    int keyStuff, String dataStuff)
      throws Exception
  {
    StudentKey addKey = new StudentKey(keyStuff,keyStuff);
    StudentInfo findData;
    findData = WhichTree.Find(addKey);
      if (findData.StudentName != dataStuff) 
        return false;
      else
        return true;
  };
      
  public static void TreeUpdate(
    SearchTree<StudentKey,StudentInfo> WhichTree,
    int keyStuff, String dataStuff)
      throws Exception
  {
    StudentKey findKey = new StudentKey(keyStuff,keyStuff);
    StudentInfo newData = new StudentInfo(dataStuff,dataStuff.charAt(0));
    WhichTree.Update(findKey,newData);
  };

  static java.io.BufferedReader br;
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
          "r)eport, f)ind, i)nsert, d)elete, s)ize, h)eight u)pdate c)opy q)uit");
        System.out.print("enter choice: ");
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
          case 'c' :
            {
              System.out.println("Doing copy");
              SearchTree<StudentKey,StudentInfo> newTree = 
                new SearchTree<StudentKey,StudentInfo>();
              newTree.CopyOf(myTree);
              System.out.println("Original was");
              myTree.Report();
              System.out.println("Copy is");
              newTree.Report();
              System.out.println("Doing Copy Constructor");
              SearchTree<StudentKey,StudentInfo> newTree2 = 
                new SearchTree<StudentKey,StudentInfo>(myTree);
              System.out.println("Copy construtor gives");
              newTree2.Report();
            }
          default :
            break;
        }
      }
      catch (Exception e)
      {
        System.out.println("Oops, try again");
      }
    } while (userInput.charAt(0) != 'q');
    // Automatic tests
    try
    {
      System.out.println("Begin Automated Tests for presence of Clone calls");
      boolean AutoGood = true;
      SearchTree<StudentKey,StudentInfo> AutoTree =
        new SearchTree<StudentKey,StudentInfo>();
      // build a little tree.
      StudentKey AutoKey = new StudentKey(3.0,3);
      StudentInfo AutoInfo = new StudentInfo("3",'3');
      // Insert should clone
      AutoTree.Insert(AutoKey, AutoInfo);
      AutoKey.Widget = 1.0;
      AutoKey.StudentID = 1;
      AutoInfo.StudentName = "1";
      AutoInfo.Grade = '1';
      AutoTree.Insert(AutoKey, AutoInfo);
      AutoKey.Widget = 2.0;
      AutoKey.StudentID = 2;
      AutoInfo.StudentName = "2";
      AutoInfo.Grade = '2';
      StudentInfo FindInfo;
      AutoTree.Insert(AutoKey, AutoInfo);
      StudentKey NewKey = new StudentKey(1.0,1);
      FindInfo = AutoTree.Find(NewKey);
      if (FindInfo.StudentName != "1" || FindInfo.Grade != '1')
        AutoGood = false;
      NewKey.Widget = 2.0;
      NewKey.StudentID = 2;
      FindInfo = AutoTree.Find(NewKey);
      if (FindInfo.StudentName != "2" || FindInfo.Grade != '2')
        AutoGood = false;
      NewKey.Widget = 3.0;
      NewKey.StudentID = 3;
      FindInfo = AutoTree.Find(NewKey);
      if (FindInfo.StudentName != "3" || FindInfo.Grade != '3')
        AutoGood = false;
      // Find should clone
      FindInfo.StudentName = "4";
      FindInfo.Grade = '4';
      StudentInfo NewFindInfo = AutoTree.Find(NewKey);
      if (NewFindInfo.StudentName != "3" || NewFindInfo.Grade != '3')
        AutoGood = false;
      // Update should clone
      AutoTree.Update(NewKey, FindInfo);
      FindInfo.StudentName = "5";
      FindInfo.Grade = '5';
      NewFindInfo = AutoTree.Find(NewKey);
      if (NewFindInfo.StudentName != "4" || NewFindInfo.Grade != '4')
        AutoGood = false;
      if (AutoGood)
        System.out.println("Automated Clone Tests Passed");
      else
        System.out.println("Automated Clone Tests Failed");
       
    }
    catch (Exception e)
    {
      System.out.println("Automated Clone Tests Failed");
    };

    try
    {
      System.out.println("Begin Automated Tests of Copy ");
      boolean CopyGood = true;
      SourceTree = new SearchTree<StudentKey,StudentInfo>();
      TreeAdd(4,"d");
      TreeAdd(2,"b");
      TreeAdd(1,"a");
      TreeAdd(3,"c");
      TreeAdd(6,"f");
      TreeAdd(5,"e");
      TreeAdd(8,"h");
      TreeAdd(7,"g");

      // Use the CopyOf function
      SearchTree<StudentKey,StudentInfo> CopyOfTree = 
        new SearchTree<StudentKey,StudentInfo>();
      CopyOfTree.CopyOf(SourceTree);
      //Modify the copy, the original should not change.
      TreeUpdate(CopyOfTree,1,"A");
      TreeUpdate(CopyOfTree,2,"B");
      TreeUpdate(CopyOfTree,3,"C");
      TreeUpdate(CopyOfTree,4,"D");
      TreeUpdate(CopyOfTree,5,"E");
      TreeUpdate(CopyOfTree,6,"F");
      TreeUpdate(CopyOfTree,7,"G");
      TreeUpdate(CopyOfTree,8,"H");
      // Check the original
      CopyGood &= TreeFind(SourceTree,1,"a");
      CopyGood &= TreeFind(SourceTree,2,"b");
      CopyGood &= TreeFind(SourceTree,3,"c");
      CopyGood &= TreeFind(SourceTree,4,"d");
      CopyGood &= TreeFind(SourceTree,5,"e");
      CopyGood &= TreeFind(SourceTree,6,"f");
      CopyGood &= TreeFind(SourceTree,7,"g");
      CopyGood &= TreeFind(SourceTree,8,"h");

      // Check the Copy
      CopyGood &= TreeFind(CopyOfTree,1,"A");
      CopyGood &= TreeFind(CopyOfTree,2,"B");
      CopyGood &= TreeFind(CopyOfTree,3,"C");
      CopyGood &= TreeFind(CopyOfTree,4,"D");
      CopyGood &= TreeFind(CopyOfTree,5,"E");
      CopyGood &= TreeFind(CopyOfTree,6,"F");
      CopyGood &= TreeFind(CopyOfTree,7,"G");
      CopyGood &= TreeFind(CopyOfTree,8,"H");

      // Use the Copy Constructor function
      SearchTree<StudentKey,StudentInfo> ConsTree = 
        new SearchTree<StudentKey,StudentInfo>(SourceTree);
      //Modify the copy, the original should not change.
      TreeUpdate(ConsTree,1,"A");
      TreeUpdate(ConsTree,2,"B");
      TreeUpdate(ConsTree,3,"C");
      TreeUpdate(ConsTree,4,"D");
      TreeUpdate(ConsTree,5,"E");
      TreeUpdate(ConsTree,6,"F");
      TreeUpdate(ConsTree,7,"G");
      TreeUpdate(ConsTree,8,"H");
      // Check the original
      CopyGood &= TreeFind(SourceTree,1,"a");
      CopyGood &= TreeFind(SourceTree,2,"b");
      CopyGood &= TreeFind(SourceTree,3,"c");
      CopyGood &= TreeFind(SourceTree,4,"d");
      CopyGood &= TreeFind(SourceTree,5,"e");
      CopyGood &= TreeFind(SourceTree,6,"f");
      CopyGood &= TreeFind(SourceTree,7,"g");
      CopyGood &= TreeFind(SourceTree,8,"h");
      // Check the Copy
      CopyGood &= TreeFind(ConsTree,1,"A");
      CopyGood &= TreeFind(ConsTree,2,"B");
      CopyGood &= TreeFind(ConsTree,3,"C");
      CopyGood &= TreeFind(ConsTree,4,"D");
      CopyGood &= TreeFind(ConsTree,5,"E");
      CopyGood &= TreeFind(ConsTree,6,"F");
      CopyGood &= TreeFind(ConsTree,7,"G");
      CopyGood &= TreeFind(ConsTree,8,"H");

      if (CopyGood)
        System.out.println("Automated Copy Tests Passed");
      else
        System.out.println("Automated Copy Tests Failed");

    }
    catch (Exception e)
    {
      System.out.println("Automated Copy Tests Failed");
    };
  };
};
