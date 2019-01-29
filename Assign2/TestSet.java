
// <file> testSet.cc
// <Purpose> The testing program for homework assignment 3 in CECS 274
//   Do not modify or submit this file.

class TestSet
{
  public static void main(String argv[])
  {
    CharSet Set1 = new CharSet();
    CharSet Set2 = new CharSet();
    CharSet Set3 = new CharSet();

    Set1.Add('A');
    Set1.Add('B');
    Set1.Add('C');
    Set2.Add('B');
    Set2.Add('C');
    Set2.Add('D');
    Set3.Add('A');
    Set3.Add('B');
    Set3.Add('C');

    Set1.Intersect(Set2);
    Set3.Union(Set2);
    Set2.Remove('C');
    System.out.println("Expect BC");
    printSet(Set1);
    System.out.println("Expect ABCD");
    printSet(Set3);
    System.out.println("Expect BD");
    printSet(Set2);
  }
  public static void printSet(CharSet ASet)
  {
    for (char c = 'A' ; c <= 'Z' ; c++ )
    {
      if (ASet.Member(c))
      {
	  System.out.print(c);
      };
    };
    System.out.println();
  };

}
