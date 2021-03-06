public class IFraction extends Fraction
{
	public IFraction(int a) throws DivideByZero
	{
		super(a, 1);
	}

	public IFraction(int a, int b) throws DivideByZero
	{
		super(a, b);
	}

	public IFraction(Fraction A) throws DivideByZero
	{
		super(A.Numerator(), A.Denominator());
		//numerator = A.numerator;
		//denominator = A.denominator;
	}

	public static Fraction Divide(Fraction L, int b) throws DivideByZero
	{
		Fraction Answer = new Fraction( L.Numerator() * 1,
				L.Denominator() * b );
		return Answer;
	}

	public static Fraction Divide(int a, Fraction R) throws DivideByZero
	{
		if (R.Numerator() == 0) throw new DivideByZero();	
		Fraction Answer = new Fraction( a * R.Denominator(),
				1 * R.Numerator() );
		
		return Answer;
	}
}
