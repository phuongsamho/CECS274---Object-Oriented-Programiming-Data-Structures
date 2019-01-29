// Tester file for the debugger homework assignment.
// Do NOT change this file, do NOT submit this file.
public class Crash
{
  public static final void main(String[] argv)
  {
    Math doMath = new Math();
    System.out.println("starting");
    doMath.calc1(8,8);
    doMath.calc2(8,8);
    System.out.println("doing loop");
    for (int i = 0 ; i < 6 ; i++)
    {
      doMath.calc1(i,4);
      doMath.calc2(i,-4);
    }
    System.out.println("done");
  };
};
