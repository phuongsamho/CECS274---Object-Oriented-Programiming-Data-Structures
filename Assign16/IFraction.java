public class IFraction extends Fraction{
  public IFraction(int x) throws DivideByZero {
      super(x,1);
  }
  public IFraction(Fraction l ) throws DivideByZero {
     
      super(l.Numerator(), l.Denominator());
  }
  public IFraction(int p, int q) throws DivideByZero {
      super(p,q);
  }
  public static IFraction Divide (int d, Fraction e) throws DivideByZero {
      IFraction Answer = new IFraction (d * e.Denominator(), 1 * e.Numerator());
      return Answer; 
  }
  public static IFraction Divide (Fraction w, int z) throws DivideByZero {
      IFraction Answer = new IFraction (1 * w.Numerator(), z * w.Denominator());
      return Answer; 
  }
}
