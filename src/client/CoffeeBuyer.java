package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

import server.Coffee;
import server.CoffeeCup;
import server.CoffeeOrder;
import server.ICoffeeMachine;
import server.Size;

public class CoffeeBuyer {
	
	public static void main(String[] args) {

		try {
			Registry registry = LocateRegistry.getRegistry("localhost", 1099);
			
			ICoffeeMachine coffeeServer = (ICoffeeMachine) registry.lookup("CoffeeServer");
			CoffeeOrder order = new CoffeeOrder(new Date(2016, 5, 3), 
					Coffee.COFFEE, Size.MEDIUM, "Monica");
			
			CoffeeCup myCoffee = coffeeServer.brew(order);
			
			System.out.println("Coffee received from Server: " + myCoffee.toString());
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

}
