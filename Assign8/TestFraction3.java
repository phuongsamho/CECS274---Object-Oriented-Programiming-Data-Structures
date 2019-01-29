//Phuong Ho 
//011056693
// CECS275
// Tester for the second version of the fractions class
// Add the calls indicated in the comments below
class TestFraction3
{
  public static void main(String argv[]) throws java.io.IOException,
     Fraction.DivideByZero
  {
    // Make sure the old stuff still works.
    //int numerator;
    //int denominator;
    Fraction c;
    Fraction a = new Fraction(2,3);
    Fraction b = new Fraction(4,5);
    //Fraction z = new Fraction(0,1);
    int x = 7;
    c = Fraction.Multiply(a,b);
    // Answer should be 8, 15
    System.out.println("answer is " + c.ToString());

    // Test the IFraction Class
    // Test the new integer constructor
    IFraction p = new IFraction(x);
    // Answer should be 7, 1
    // This also tests the inheritance of ToString
    System.out.println("answer is " + p.ToString());

    // Test the new copy constructor
    IFraction p2 = new IFraction(b);
    // Answer should be 4, 5
    System.out.println("answer is " + p2.ToString());

    // Test of the inheritance of the old constructor
    IFraction q = new IFraction(3,4);
    // Answer should be 3, 4
    System.out.println("answer is " + q.ToString());

    // Divide test
    Fraction s = IFraction.Divide(q,x);
    // Answer should be 3,28
    System.out.println("answer is " + s.ToString());

    // Second Divide test
    s = IFraction.Divide(3,q);
    // Answer should be 12,3
    System.out.println("answer is " + s.ToString());

    // Add a call to Divide for s=a/4
	s = IFraction.Divide(a, 4);
    // Answer should be 2,12
    System.out.println("answer is " + s.ToString());


    // Add a call to Divide for c=4/a
	c = IFraction.Divide(4, a);
    // Answer should be 12,2
    System.out.println("answer is " + c.ToString());
  }
}
