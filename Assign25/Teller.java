public class Teller
{
  public static void  main(String arvg[]) throws java.io.IOException
  {
    Bank myBank = new Bank();
    String userInput;
    String customerName;
    int accountID;
    double amount;
    java.io.BufferedReader br = new java.io.BufferedReader(
      new java.io.InputStreamReader(System.in));

    do
    {
      System.out.println(
      "1)add account 2)delete account 3)deposit 4)withdraw 5)balance 6)name 7)report q)quit");
      System.out.print("enter choice: ");
      userInput = br.readLine();
      try
      {
        switch (userInput.charAt(0))
        {
          case '1' :
            System.out.print("Enter account id ");
            userInput = br.readLine();
            accountID = Integer.parseInt(userInput);
            System.out.print("Enter customer name ");
            customerName = br.readLine();
            myBank.AddAccount(accountID,customerName);
            break;
          case '2' :
            System.out.print("Enter account id ");
            userInput = br.readLine();
            accountID = Integer.parseInt(userInput);
            myBank.RemoveAccount(accountID);
            break;
          case '3' :
            System.out.print("Enter account id ");
            userInput = br.readLine();
            accountID = Integer.parseInt(userInput);
            System.out.print("Enter amount ");
            userInput = br.readLine();
            amount = Float.parseFloat(userInput);
            myBank.Deposit(accountID, amount);
            break;
          case '4' :
            System.out.print("Enter account id ");
            userInput = br.readLine();
            accountID = Integer.parseInt(userInput);
            System.out.print("Enter amount ");
            userInput = br.readLine();
            amount = Float.parseFloat(userInput);
            myBank.Withdraw(accountID, amount);
            break;
          case '5' :
            System.out.print("Enter account id ");
            userInput = br.readLine();
            accountID = Integer.parseInt(userInput);
            amount = myBank.Balance(accountID);
            System.out.println("Account balance: " +  amount);
            break;
          case '6' :
            System.out.print("Enter account id ");
            userInput = br.readLine();
            accountID = Integer.parseInt(userInput);
            customerName = myBank.CustomerName(accountID);
            System.out.println("Customer name: " + customerName);
            break;
          case '7' :
            myBank.Report();
            break;
          case 'q' :
            break;
          default :
            System.out.print("Unrecognized option");
            break;
        }
      }
      catch (Exception e)
      {
        System.out.println("Account not found");
      };
    } while (userInput.charAt(0) != 'q');
  };
};
