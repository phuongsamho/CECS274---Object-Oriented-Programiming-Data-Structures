// Phuong Ho
// phoa
// Assignment 2
// CECS 274
//REPLACE THIS WITH YOUR INFORMATION (name, account, homework number, CECS 274)

// Replace the ...'s with code to complete the assignment.

// Maintains a set of characters. The characters are limited to
//  capital A through capital Z.
public class CharSet
{
  // This is where the set is stored. The boolean is true if the
  //  character is in the set, false if it isn't.
  private boolean[]  Contents = new boolean[26];

  // The constructor. It initializes the set to be empty,
  // that is to have no characters in it.
  public CharSet()
  {
  	for(int i = 0; i <= 25; i++)
	{
		Contents[i] = false;
	}   
  };

  // Add a character to the set.
  // The corresponding boolean is set to true.
  public void Add(char Value)
  {
	Contents[Value - 'A'] = true;  
  };

  // Remove a character to from the set.
  // The corresponding boolean is set to false.
  public void Remove(char Value)
  {
  	Contents[Value - 'A'] = false;   
  };

  // Union the set passed a parameter into this set.
  public void Union(CharSet ASet)
  {
  	for (int i = 0; i <= 25; i++)
	{
		Contents[i] = (ASet.Contents[i] || Contents[i]);
	}	  
  };

  // Intersect the set passed a parameter with this set.
  // This set will contain the result of the intersection.
  public void Intersect(CharSet ASet)
  {
  	for (int i = 0; i <= 25; i++)
	{
		Contents[i] = (ASet.Contents[i] && Contents[i]);
	}
  };

  // Returns true if the character is a member of the set, false 
  // if it is not.
  public boolean Member(char Value)
  {
  	return Contents[Value - 'A'];
  };
};
