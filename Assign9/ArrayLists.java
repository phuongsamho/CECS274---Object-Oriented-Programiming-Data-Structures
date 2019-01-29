// You need to fill in the bodies for MaxSize, Delete and Find

public class ArrayLists
{
  public static class ListException extends Exception
  {
    private static final long serialVersionUID=0;
  };

  public ArrayLists()
  {
    // The array has a maximum size of 7
    maxSize = 7;
    List = new IFraction[7];
    // The array starts empty.
    size = 0;
  };

public ArrayLists(int maximumSize) 
{
	maxSize = maximumSize;
	List = new IFraction[maximumSize];
	size = 0;	
}

public void CopyOf(ArrayLists a) throws ListException, Fraction.DivideByZero
{
	maxSize = a.maxSize;
	size = a.size;
	List = new IFraction[maxSize];
	for (int i = 0; i < size; i++)
	{
		List[i] = new IFraction(a.List[i]);
	}
}

public ArrayLists(ArrayLists R) throws Fraction.DivideByZero
{
	maxSize = R.maxSize;
	size = R.size;
	List = new IFraction[maxSize];
	for (int i = 0; i < size; i++)
	{
		List[i] = new IFraction(R.List[i]);
	}
}
  // Put an element into the list,
  // will throw it where is not between 0 and size
  public void Store(int where, IFraction Item) throws ListException, Fraction.DivideByZero
  {
    // Throw if out of bounds or full
    if (where>size || where<0 || size==maxSize) throw new ListException();
    // Open space (move rightmost first)
    for (int i = size; i > where ; i-- )
    {
      List[i]=List[i-1];
    }
    // Drop the new item in
    List[where]= new IFraction(Item);
    // Increment the number of things in the list
    size++;
  };

  // Retrieve an element from the list
  // will throw it where is not between 0 and size-1
  public IFraction Retrieve(int where) throws ListException, Fraction.DivideByZero
  {
    // Throw if it is "out of bounds"
    if (where >= size || where < 0) throw new ListException();
    // return the requested item
    return List[where] = new IFraction();
  };

  // Delete an element from the list
  // will throw if where is not between 0 and size-1
  public void Delete(int where) throws ListException
  {
  	if (size == 0 || where > size || where < 0) throw new ListException();
	for (int i = where; i < size - 1; i++)
	{
		List[i] = List[i + 1];
	}
	size--;  
  }

  // Return number of things in the list 
  public int Size() 
  {
    return size;
  };

  // Return the maximum number of things that can be in the list
  public int MaxSize()
  {
  	return maxSize;  
  };

  // Locate an item in the list, return "where" you
  //  found it. return -1 if it wasn't found.
  public int Find(IFraction Item)
  {
  	int answer = -1;
	for (int i = 0; i < size; i++)
	{
		if (List[i] == Item) answer = i;
	}
	return answer;  
  };

  // Just here for testing, not for the final product.
  // Print what is in the list. The list is printed on a single line.
  public void Print()
  {
    for (int i=0 ; i< size ; i++)
    {
      System.out.print(List[i].ToString() + " ");
    }
    System.out.println("");
  };

  private int maxSize;
  private int size;
  private IFraction[] List;
};

  
  
