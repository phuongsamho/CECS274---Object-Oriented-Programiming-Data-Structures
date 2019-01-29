// Tester for the fractions class
// You add the try catch block as directed in the homework assignment
class TestFraction
{
  public static void main(String argv[]) throws java.io.IOException
  {
    int numerator;
    int denominator;
    Fraction c;
    String userInput=" ";
    java.io.BufferedReader br = new java.io.BufferedReader(
      new java.io.InputStreamReader(System.in));
    do
    {try{
      System.out.println("first fraction");
      System.out.println("numerator ");
      userInput = br.readLine();
      numerator = Integer.parseInt(userInput);
      System.out.println("denominator ");
      userInput = br.readLine();
      denominator = Integer.parseInt(userInput);
      Fraction a = new Fraction(numerator,denominator);
      System.out.println("second fraction");
      System.out.println("numerator ");
      userInput = br.readLine();
      numerator = Integer.parseInt(userInput);
      System.out.println("denominator ");
      userInput = br.readLine();
      denominator = Integer.parseInt(userInput);
      Fraction b = new Fraction(numerator,denominator);
      System.out.println("choose * or / ");
      userInput = br.readLine();
      switch (userInput.charAt(0))
      {
        case '*':
          c = Fraction.Multiply(a, b);
          break;
        case '/':
          c = Fraction.Divide(a, b);
          break;
        default:
          c = new Fraction(0,1);
          System.out.println("Bad choice");
          break;
      }
      System.out.println("answer is " + c.ToString());
	}	
	catch (DivideByZero e)
	{
		System.out.println("Don't try 0");
	}	
	System.out.println("y to continue ");		
      userInput = br.readLine();
    } while (userInput.charAt(0) == 'y');
  
  }
}
