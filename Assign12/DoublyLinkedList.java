public class DoublyLinkedList
{

  private class node
  {
    int Item;
    node Next;
    node Previous;
  };

  private node Head;

  public DoublyLinkedList()
  {
    // Set up the dummy node.
    Head = new node();
    Head.Next = Head;
    Head.Previous = Head;
  
  };
  
  // Add at the front
  public void Insert(int Item)
  {
    // Insert at the front of the doubly linked list.
    node afterMe = Head;
    node newNode = new node();
    newNode.Item = Item;
    // Set up the pointers in the new node
    // The new node points back to the dummy node
    newNode.Previous = afterMe;
    // The new node points forward to the former first node.
    newNode.Next = afterMe.Next;
    // This changes the dummy node to pointer to the new node.
    newNode.Previous.Next = newNode;
    // Change the former first node to indicate we are in front of it.
    newNode.Next.Previous = newNode;
  
  };
  
  // count (and return) the number of elements in the linked list
  public int Count()
  {
  	int count = 0;
  	node Cur = Head.Previous;
  	while (Cur != Head)
  	{
		count++;
		Cur = Cur.Previous;
  	}
	return count;	 
  }

  // find and return the largest element in the linked list
  // Assume all the value are greater than zero and return 0 on an empty list
  public int GetLargest()
  {
  	node Cur = Head.Previous;
	int largest = 0;
	while (Cur != Head)
	{
		if (Cur.Item > largest) largest = Cur.Item;
		Cur = Cur.Previous;
	}
	return largest;	
  }

};
