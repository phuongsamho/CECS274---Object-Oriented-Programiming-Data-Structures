public class SearchTree <KeyType extends Comparable<KeyType>,DataType extends HasVisit>
{

  public static class NotFound extends Exception
  {
    private static final long serialVersionUID=0;
  };

  public static class Duplicate extends Exception
  {
    private static final long serialVersionUID=0;
  };

  // Initialize an empty tree
  public SearchTree()
  {
    Root = null;
  };

  // Report the contents of the tree
  public void Report()
  {
    Report(Root); 
  };

  // Locate an element with the given key and return the
  //  associated data.
  public DataType Find(KeyType Key) throws NotFound
  {
    return Find(Root, Key);
  };

  // Insert a new element into the tree.
  public void Insert(KeyType Key, DataType Data) throws Duplicate
  {
    Root = Insert(Root, Key, Data);
  };
  public int Size()
	{ return Size(Root);
}
  private int Size(Tree_Node T)
{if(T==null)
{
return 0;
}
else
{return Size(T.Left)+Size(T.Right)+1;
}
}
public int Height()
{
return Height(Root);
}
private int Height(Tree_Node T)
{
if(T == null){
 return 0;
}
else{
if(Height(T.Right) > Height(T.Left))
return Height(T.Right)+1;
else{
return Height(T.Left)+1;
}
}
}
  public void Update( KeyType Key,DataType Data) throws NotFound
  { Update(Root,Key,Data); 

  }
  private void Update(Tree_Node T,KeyType Key, DataType Data) throws NotFound                                                                      
  {if(T == null)throw new NotFound();
   if(Key.compareTo(T.Key)==0){
      
    T.Data = Data;  
      
      
      
    }
   else if(Key.compareTo(T.Key)<0){
	 Update(T.Left,Key,Data);
     }
   else{
     Update(T.Right,Key,Data); 
      } 	
  }
  // Find and delete a key.
  public void Delete(KeyType Key) throws NotFound
  {
    Root = Delete(Root, Key);
  };

  private class Tree_Node
  {
    KeyType Key;
    DataType Data;
    Tree_Node Left, Right;
  };

  private Tree_Node Root;
  private void Report(Tree_Node T)
  {
  // Print the contents of a tree from
  //  smallest to largest by doing an InOrder
  //  traversal
    if (T != null)
    {
      Report(T.Left);
      T.Data.Visit();
      Report(T.Right);
     }
  };

  private DataType Find(Tree_Node T,KeyType Key) throws NotFound 
  {
    if (T == null)
      throw new NotFound();
    if (Key.compareTo(T.Key) ==0)
      return T.Data;
    else if (Key.compareTo(T.Key) <0 )
      return Find(T.Left, Key);
    else
      return Find(T.Right, Key);
  };

  // A tree node (Save) is passed back.
  // Save.Data and Save.Key will be needed by the original caller.
  // All nodes will use Save.Right to adjust their appropriate child 
  // pointer. Save.Left is unused.
  private Tree_Node Get_And_Remove_Smallest(Tree_Node T)
  {
    if (T.Left == null)
    {
      // Who ever pointed to this node,
      // should now point to what ever T.Right pointed to.
      return T;
    }
    else 
    {
      Tree_Node Save = Get_And_Remove_Smallest(T.Left);
      // Make any needed adjustment to our left pointer
      T.Left = Save.Right;
      // Whoever pointed to this node,
      // should still point to this node.
      Save.Right = T;
      return Save;
    }
  };

  private Tree_Node Insert(Tree_Node T, KeyType Key,
                 DataType Data) throws Duplicate 
  {
    if (T == null)
    {
      Tree_Node newNode = new Tree_Node();
      newNode.Key = Key;
      newNode.Data = Data;
      newNode.Left = null;
      newNode.Right = null;
      // Inserted a node, return the value of the new node
      return newNode;
    }
    else if (Key.compareTo(T.Key)==0)
      throw new Duplicate(); // Duplicate_Key
    else if (Key.compareTo(T.Key) <0 )
      T.Left = Insert(T.Left, Key, Data);
    else
      T.Right = Insert(T.Right, Key, Data);
    // No change, return the old value
    return T;
  };

  private Tree_Node Delete(Tree_Node T,KeyType Key) throws NotFound
  {
    Tree_Node Save;
    if (T == null)
      throw new NotFound(); // Key Not Found
    if (Key.compareTo(T.Key)<0 )
      T.Left = Delete(T.Left, Key);
    else if (Key.compareTo(T.Key)>0)
      T.Right = Delete(T.Right, Key);
    else
    {
      if ((T.Left == null) && (T.Right == null)) {
        return null;
       }
       else if (T.Right == null) {
         return T.Left;
       }
      else if (T.Left == null) {
        return T.Right;
      }
      else
      {
        // Move the smallest of the right subtree
	// to the current location.
        Save = Get_And_Remove_Smallest(T.Right);
        T.Data = Save.Data;
        T.Key = Save.Key;
	// Also perform any needed adjustment to our left pointer
        T.Right = Save.Right;
      }
    }
    // There should be no change to the pointer we were passed
    return T; 
  };

};
