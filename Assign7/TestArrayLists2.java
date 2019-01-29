class TestArrayLists2
{
  public static void main(String[] argv) throws ArrayLists.ListException
  {
    // Make sure the old constructor was not removed
    ArrayLists A = new ArrayLists();
    // Test the simple one of the new constructors
    ArrayLists X = new ArrayLists(8);
    // Initial tests, make sure the old operators still work
    X.Store(0,3.5);
    X.Store(1,2.2);
    X.Store(0,4.1);
    // Make sure Store (and Print) still work
    X.Print();
  
    // Test one, the student's MaxSize
    System.out.println( X.MaxSize());
  
    // Test the find
    System.out.println(X.Find(2.2));
    System.out.println(X.Find(3.5));
    System.out.println(X.Find(4.1));
    System.out.println(X.Find(7.5));
  
    // Test the delete
    X.Delete(1);
    X.Print();
  
    // Test the Delete's throw
    try
    {
      X.Delete(4);
      System.out.println( "throw test FAILED");
    }
    catch(ArrayLists.ListException e)
    {
      System.out.println( "throw test PASSED");
    }
    // New tests, test the copy.
    // Put a couple more elements into X
    X.Store(2,3.2);
    X.Store(3,4.2);
    // Test the CopyOf method
    // Use a small array to make sure List gets redone.
    // If it doesn't CopyOf will throw with an array
    // index out of bounds.
    ArrayLists Y = new ArrayLists(2);
    Y.CopyOf(X);
    // X should change, but y should not.
    X.Store(0,9.99);
    //  Should be 9.99
    System.out.println( X.Retrieve(0));
    // Should be 4.1
    System.out.println( Y.Retrieve(0));
    // Should be 2.2
    System.out.println( Y.Retrieve(1));
    // Test the copy constructor.
    ArrayLists Z = new ArrayLists(X);
    //  Should be 9.99
    System.out.println(Z.Retrieve(0));
  
  };
};
