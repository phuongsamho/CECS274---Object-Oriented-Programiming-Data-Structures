public class LinkedList
{
  // public because something returns it.
  public static class node
  {
    public int Item;
    public node Next;
  }

  // Create an empty linked list
  public LinkedList()
  {
    Head = null;
  };

  // Insert at front
  public void Insert(int Item)
  {
    node newNode = new node();
    newNode.Item = Item;
    newNode.Next = Head;
    Head = newNode;
  };

  // Delete the specified item. If the item is not
  // found, do nothing.
  public void Delete(int Item)
  {
    if (Head == null) return;
    if (Head.Item == Item)
    {
      Head = Head.Next;
    }
    else
    {
      node Cur = Head;
      while (Cur.Next != null)
      {
        if (Cur.Next.Item == Item)
        {
          Cur.Next = Cur.Next.Next;
          return;
        }
        Cur = Cur.Next;
      }
    }
  };

  // count and return the number of elements in the linked list
  public int Count()
  {
  	int count = 0;
	node Cur = Head;	
  	while (Cur != null)
	{
		count++;
		Cur = Cur.Next;
	}
	return count;
  }
  
  // find and return the largest (integer) in the linked list
  // if the list is empty, return 0
  public int GetLargest()
  {
  	node Cur = Head;
	int largest = 0;	
	//if (Head == null) return 0;
	//else
	//{
		while (Cur !=  null)
		{
			if(Cur.Item > largest) largest = Cur.Item;
			Cur = Cur.Next;
		}
		return largest;		
  	//}

  }
  // find and return the node that contains to the item.
  // If the item isn't in the list, return null.
  public node Retrieve(int Item)
  {
    node Cur = Head;
    while (Cur != null)
    {
      if (Cur.Item == Item) return Cur;
      Cur = Cur.Next;
    };
    return null;
  };
  
  // Retrieve the node at the front of the list.
  // If the list is empty, return null.
  public node Retrieve()
  {
    return Head;
  };

  // Print the contents of the linked list
  public void Print()
  {
    node Cur = Head;
    while (Cur != null)
    {
      System.out.println(Cur.Item);
      Cur = Cur.Next;
    }
  };

  // In case we decide to do an extension of the linked list,
  // we make this protected instead of private
  protected node Head;
};
