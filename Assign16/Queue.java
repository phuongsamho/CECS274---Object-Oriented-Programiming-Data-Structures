public class Queue<ItemType>
{

  public static class EmptyException extends Exception
  {
    private static final long serialVersionUID=0;
  };

  public Queue()
  {
    // Set up the dummy node.
    Head = new node();
    Head.Next = Head;
    Head.Previous = Head;
  };

  // Put an item onto the queue
  public void Store(ItemType Item)
  {
    // Store on the back of the queue, that is
    // insert it at the front of the doubly linked list.
    node afterMe = Head.Previous; //storing at the back
    node newNode = new node();
    newNode.Item = Item;
    newNode.Previous = afterMe;
    newNode.Next = afterMe.Next;
    newNode.Previous.Next = newNode;
    newNode.Next.Previous = newNode;
  };
  
  // Retreive a copy of the top item on the queue
  // Throws EmptyException if the queue is empty
  public ItemType Retrieve() throws EmptyException
  {
    
	if (Head.Next == Head) throw new EmptyException();
    	return Head.Next.Item;
  };
  
  // Delete the item on the top of queue
  // Throws EmptyException if the queue is empty
  public void Delete() throws EmptyException
  {
  	if (Head.Next == Head) throw new EmptyException();
    	node DeleteMe = Head.Next;
	DeleteMe.Next.Previous = DeleteMe.Previous; 
	DeleteMe.Previous.Next = DeleteMe.Next;
	
  };

  // Return true if empty
  // return false if not empty
  public boolean Empty()
  {
    	if (Head.Next == Head) return true;
    	return false;
  };

  // Print the contents of the stack.
  public void SummarizeForward()
  {
    // go to the first node in the list
    node Cur = Head.Next;
    // Cycle until we come back to the dummy node
    while (Cur != Head)
    {
      System.out.print(Cur.Item + " " );
      Cur = Cur.Next;
    };
    System.out.println("");
  };

  public void SummarizeBackward()
  {
    // go to the dummy node
    node Cur = Head;
    // go to the last node in the list
    Cur = Head.Previous;
    // Cycle until we come back to the dummy node
    while (Cur != Head)
    {
      System.out.print(Cur.Item + " " );
      Cur = Cur.Previous;
    };
    System.out.println("");
  };

  // The node record
  // Can't be static if we are going to genericize it.
  private class node
  {
    ItemType Item;
    node Next;
    node Previous;
  };

  // The head of the doubly linked list,
  //  for the stack this points to the
  //  dummy node.
  private node Head;

};
