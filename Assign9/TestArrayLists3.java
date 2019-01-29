class TestArrayLists3
{
  public static void main(String[] argv) throws Fraction.DivideByZero,
    ArrayLists.ListException
  {
    IFraction a = new IFraction(2,3);
    IFraction b = new IFraction(4,5);
    ArrayLists X = new ArrayLists();
    // Initial tests, make sure the old operators still work
    X.Store(0,a);
    X.Store(1,b);
    // List of 0 has 2/3, list of 1 has 4/5
    X.Print();
    // Check the copy in.
    a.Reciprocal();
    b.Reciprocal();
    // The list should still be the same.
    X.Print();

    // Check the copy out.
    IFraction c = X.Retrieve(1);
    // We should still get the 4/5
    System.out.println(c.ToString());
    // Make sure it's a copy
    c.Reciprocal();
    // The list should still be the same.
    X.Print();
  };
};
