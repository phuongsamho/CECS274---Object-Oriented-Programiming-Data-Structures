class Recursion
{
	public static void main(String arvg[]) throws java.io.IOException
	{
		System.out.println("Enter a number: ");
		java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		int userInput = Integer.parseInt(reader.readLine());
		do
		{
			PrintIt(userInput);
			userInput = Integer.parseInt(reader.readLine());
		}
		while (userInput > 0);
				
	};

	public static void PrintIt(int value)
	{
		if (value == 0) 
		System.out.println(); 
		else
		{
		System.out.print(value % 10);
		PrintIt(value / 10);
		} 
	};	
};
