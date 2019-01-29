class TestArrayLists
{
  public static void main(String argv[]) throws ArrayLists.ListException
  {
    ArrayLists X = new ArrayLists();;
    X.Store(0, 3.5);
    X.Store(1, 2.2);
    X.Store(0, 4.1);
    X.Store(2, 5.4);
    // Make sure Store (and Print) still work
    X.Print();
  
    // Test one, the student's MaxSize
    System.out.println(X.MaxSize());
  
    // Test the find
    System.out.println(X.Find(2.2));
    System.out.println(X.Find(5.4));
    System.out.println(X.Find(3.5));
    System.out.println(X.Find(4.1));
  
    // This returns a -1 because it "fails"
    System.out.println(X.Find(7.5));
  
    // Test the delete, the 3.5 should disappear
    X.Delete(1);
    X.Print();
  
    // Test the Delete's throw
    try
    {
      X.Delete(4);
      System.out.println("throw test 1 FAILED\n");
    }
    catch(ArrayLists.ListException e)
    {
      System.out.println("throw test 1 PASSED\n");
    };
    try
    {
      X.Delete(-1);
      System.out.println("throw test 2 FAILED\n");
    }
    catch(ArrayLists.ListException e)
    {
      System.out.println("throw test 2 PASSED\n");
    };
    // Check Stopping conditions
    // Fill up the array. It started with 4, we deleted 1 leaving 3,
    // so we add 4 to completely fill it.
    X.Store(0, 4.4);
    X.Store(0, 3.4);
    X.Store(0, 2.4);
    X.Store(0, 1.4);
    // Test the find on a full array with a value not to be found to
    // make sure the stop condition is correct.
    // Should still print a -1, should not throw an error or exception
    System.out.println(X.Find(7.5));
    // Test the delete on a full array to
    // make sure the stop condition on the delete loop is correct.
    X.Delete(2);
    X.Print();

    // Test the find again. Delete the last item then look for it.
    // It should give us a -1
    X.Delete(5);
    System.out.println(X.Find(2.2));
  }
}
