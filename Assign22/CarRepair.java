public class CarRepair
{

  // The class Car  is public because the tester does "new"s on it. That way
  // you don't have to make copies of Cars in this class. The copy constructor
  // is for a later assignment.

  public static class Car
  {
    public int CarID;
    public float Cost;
  };

  // Accepts a car and places it in a repair queue.
  public void AcceptHighPriorityCar(Car newcar)
  {
    High.Store(newcar);
  };
  public void AcceptMediumPriorityCar(Car newcar)
  {
    Med.Store(newcar);
  };
  public void AcceptLowPriorityCar(Car newcar)
  {
    Low.Store(newcar);
  };

  // Returns true if all three queues are empty.
  // (HighPriority AND MedimumPriority AND LowPriority)
  public boolean NoCars()
  {
    if(High.Empty() && Med.Empty() && Low.Empty()) 
	return true; 
    return false;
  };

  // Repairs (returns) a car.
  // If there are cars in the HighPriority Queue
  //   It returns the first car in that queue (and removes
  //   it from the queue.
  // If there are no cars in the HighPriority Queue
  // and if there are cars in the MediumPriority Queue
  //   It returns the first car in that queue (and removes
  //   it from the queue.
  // If there are no cars in the HighPriority Queue
  // and if there are no cars in the MediumPriority Queue
  // and if there are cars in the LowPriority Queue
  //   It returns the first car in that queue (and removes
  //   it from the queue.
  // if there are no cars in any queue it throws Exception

  public Car RepairCar() throws Exception
  {
    Car C;
    if (!High.Empty()) 
    {	
	C = High.Retrieve();
        High.Delete();
    }
    else if (!Med.Empty())
    {
	C = Med.Retrieve();
	Med.Delete();
    }
    else if (!Low.Empty())
    {
	C = Low.Retrieve();
	Low.Delete();
    } 	
    else throw new Exception();	
    return C;
  };

  // YOU fill in
  // Three queues of cars (variables) should be declared here, 
  // high  priority, medimum priority, low priorty.
  // These should be private.
  // You may initialize the variables here (i.e., create the
  // queues or you may add a constructor to the class to
  // initialize them.
  private Queue<Car> High = new Queue<Car>();
  private Queue<Car> Med = new Queue<Car>();	
  private Queue<Car> Low = new Queue<Car>();  
};
