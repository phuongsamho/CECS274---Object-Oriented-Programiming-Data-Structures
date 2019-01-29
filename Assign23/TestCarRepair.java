public class TestCarRepair
{
  public static void  main(String arvg[]) throws java.io.IOException
    // , DidntHaveCar
  {
    CarRepair myShop = new CarRepair();
    String userInput;
    CarRepair.Car aCar = null;
    java.io.BufferedReader br = new java.io.BufferedReader(
      new java.io.InputStreamReader(System.in));
    do
    {
      System.out.println(
        "1)accept high, 2)accept medium, 3)accept low, 4)repair 5) throw test q)quit");
      System.out.print("enter choice: ");
      userInput = br.readLine();
      try
      {
        switch (userInput.charAt(0))
        {
          case '1' :
            aCar = new CarRepair.Car();
            System.out.print("Enter car id ");
            userInput = br.readLine();
            aCar.CarID = Integer.parseInt(userInput);
            System.out.print("Enter repair cost ");
            userInput = br.readLine();
            aCar.Cost = Float.parseFloat(userInput);
            myShop.AcceptHighPriorityCar(aCar);
            break;
          case '2' :
            aCar = new CarRepair.Car();
            System.out.print("Enter car id ");
            userInput = br.readLine();
            aCar.CarID = Integer.parseInt(userInput);
            System.out.print("Enter repair cost ");
            userInput = br.readLine();
            aCar.Cost = Float.parseFloat(userInput);
            myShop.AcceptMediumPriorityCar(aCar);
            break;
          case '3' :
            aCar = new CarRepair.Car();
            System.out.print("Enter car id ");
            userInput = br.readLine();
            aCar.CarID = Integer.parseInt(userInput);
            System.out.print("Enter repair cost ");
            userInput = br.readLine();
            aCar.Cost = Float.parseFloat(userInput);
            myShop.AcceptLowPriorityCar(aCar);
            break;
          case '4' :
            if (myShop.NoCars())
            {
              System.out.println("No cars to repair");
              break;
            };
            aCar = myShop.RepairCar();
            System.out.println("Repaired: Car ID " + aCar.CarID + " cost " +
               aCar.Cost);
            break;
          case '5' :
            try
            {
               CarRepair ThrowTester = new CarRepair();
               ThrowTester.RepairCar();
               System.out.println("A throw was expected");
            }
            catch (Exception e)
            {
               System.out.println("The expected throw happened");
            };
          case 'q' :
            // do nothing, we will leave the loop at the bottom
            break;
          default :
            System.out.println("Unrecognized option");
            break;
        }
      }
      catch (Exception e)
      {
        System.out.println("If this happens you goofed");
      };
    } while (userInput.charAt(0) != 'q');
  };
};
