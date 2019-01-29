public class Fraction
{
        public static class DivideByZero extends Exception {
                private static final long serialVersionUID=0;
        };
	public Fraction(int top, int bottom) throws DivideByZero{
		numerator = top;
		denominator = bottom;
		if (bottom == 0) throw new DivideByZero();
		
	}
	
	public static Fraction Multiply(Fraction L, Fraction R) throws DivideByZero
	{

		Fraction Answer = new Fraction( L.Numerator() * R.Numerator(),
		L.Denominator() * R.Denominator() );

		return Answer;

	}

	public static Fraction Divide (Fraction L, Fraction R) throws DivideByZero 
	{
		Fraction Answer = new Fraction( L.Numerator() * R.Denominator(),
			L.Denominator() * R.Numerator() );
		return Answer;
	}
		
	public int Numerator()
	{
		return numerator;
	}

	public int Denominator()
	{
		return denominator;
	}

 	public String ToString()
	{
		return (" " + Numerator() + " / " + Denominator());
	}
	
	public String toString()
	{
		return (" " + Numerator() + " / " + Denominator());
	}	

 	public void Reciprocal() throws DivideByZero

	{
		if (numerator == 0) throw new DivideByZero();
		int flip = numerator;
		numerator = denominator;
		denominator = flip;	
	}
	private int numerator;
	private int denominator;
}
