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

public class MoccachinoBuyer {
	
	public static void main(String[] args) {
	
		try {
			
			Registry registry = LocateRegistry.getRegistry("localhost", 1099);
			
			ICoffeeMachine coffeeServer = 
					(ICoffeeMachine) registry.lookup("CoffeeServer");
			CoffeeOrder order = new CoffeeOrder(new Date(2016, 5, 3),
					Coffee.MOCCACHINO, Size.LARGE, "Rachel");
			
			CoffeeCup myMoccachino = coffeeServer.brew(order);
			
			System.out.println("Coffee received from Server: " + myMoccachino.toString());
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
	}
}
