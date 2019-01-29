public class Bank
{

   // Add the class AccountID here as a private static class.
   // It should be similar to StudentKey
   private static class AccountID implements Comparable<AccountID>, HasClone<AccountID>
   {
	public AccountID Clone()
    	{
    		return new AccountID(this);
    	};
    	public int compareTo(AccountID S)
   	{
		return ID - S.ID;
    	};	
    	public AccountID(AccountID Item)
    	{
      		ID = Item.ID;
    	};
    	public AccountID(int iID)
    	{	
      		ID = iID;
    	};
   	public AccountID()
    	{
    	};
    	
    	public int ID;
   };		 	

   // Add the class Customer here as a private static class.
   // It should be similar to StudentInfo
   private static class Customer implements HasVisit, HasClone<Customer>
   {
	public Customer Clone()
    	{
    		return new Customer(this); 
    	}

    	public Customer(Customer Item)
    	{
      		CustomerName = Item.CustomerName;
      		AccountBalance = Item.AccountBalance;
    	};
    	public Customer(String iName)
    	{
      		CustomerName = iName;
      		AccountBalance = 0;
    	}
    	public Customer()
    	{
		//AccountBalance = 0;
		//CustomerName = " ";	
    	};
    	public void Visit()
    	{
		System.out.println(CustomerName + " " + AccountBalance);
    	}

    	public String CustomerName;
    	public double AccountBalance;
   }; 
   
   // YOU fill in the method bodies.

   // Add a customer record to the tree
   public void AddAccount(int accountID, String customerName) throws Exception
   {
	AccountID myAccountID = new AccountID(accountID);
	Customer myCustomer = new Customer(customerName);
	//Customer myCustomer = myTree.Find(myAccountID);
	myTree.Insert(myAccountID, myCustomer);
   };

   // Remove a customer record from the tree
   public void RemoveAccount(int accountID) throws Exception
   {
	AccountID myAccountID = new AccountID(accountID);
	myTree.Delete(myAccountID);
   };

   // Modify a customer record in the tree. Increase the account balanace
   public void Deposit(int accountID, double amount) throws Exception
   {
	AccountID myAccountID = new AccountID(accountID);
	Customer myCustomer = myTree.Find(myAccountID);
	myCustomer.AccountBalance = myCustomer.AccountBalance +amount;
	myTree.Update(myAccountID, myCustomer);
   };

   // Modify a customer record in the tree. Reduce the account balanace
   public void Withdraw(int accountID, double amount) throws Exception
   {
	AccountID myAccountID = new AccountID(accountID);
	Customer myCustomer = myTree.Find(myAccountID);
	myCustomer.AccountBalance = myCustomer.AccountBalance - amount;
	myTree.Update(myAccountID, myCustomer);
   };

   // Report (return) the account balance
   public double Balance(int accountID) throws Exception
   {
	AccountID myAccountID = new AccountID(accountID);
	Customer myCustomer = myTree.Find(myAccountID);
     	return myCustomer.AccountBalance;
   };

   // Report (return) the customer's name
   public String CustomerName(int accountID) throws Exception
   {
     	AccountID myAccountID = new AccountID(accountID);
	Customer myCustomer = myTree.Find(myAccountID);
     	return myCustomer.CustomerName;
   };

   // Print the information for all customers with bank accounts.
   public void Report()
   {
	myTree.Report();
   };

   // YOU Add the tree here
   SearchTree<AccountID, Customer> myTree = new SearchTree<AccountID, Customer>(); 	
};
