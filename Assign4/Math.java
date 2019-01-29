// Tester file for the debugger homework assignment.
// Do NOT change this file, do NOT submit this file.
public class Math
{ 
  public int calc1(int a, int b)
  {
    int answer = (a+b)/(a-b+1);
    save = a+b;
    return answer;
  };

  public int calc2(int a, int b)
  {
    int answer = (a-b)/(a+b);
    save = a+b;
    return answer;
  };
  private int save;
};
