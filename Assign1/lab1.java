public  class lab1
{
	 public static void main(String arg[]) throws java.io.IOException
	{		
		System.out.println(" Hi there, what is your name?");
		java.io.BufferedReader reader = new java.io.BufferedReader(
		new java.io.InputStreamReader(System.in));
		String userInput = reader.readLine();
		System.out.println("Hi there, " + userInput);
	}
}

