package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import server.Coffee;
import server.CoffeeOrder;
import server.ICoffeeCup;
import server.ICoffeeMachine;
import server.ICoffeeOrder;
import server.Size;

public class MoccachinoBuyer {
	
	public static void main(String[] args) {
	
		try {
			
			Registry registry = LocateRegistry.getRegistry("localhost", 1099);
			
			ICoffeeMachine coffeeServer = 
					(ICoffeeMachine) registry.lookup("CoffeeServer");
			ICoffeeOrder order = new CoffeeOrder(new Date(2016, 5, 3),
					Coffee.MOCCACHINO, Size.LARGE, "Rachel");
			
			ICoffeeOrder stub = 
					(ICoffeeOrder) UnicastRemoteObject.exportObject(order, 0);
			
			ICoffeeCup myMoccachino = coffeeServer.brew(stub);
			
			System.out.println("Coffee received from Server: " + 
					myMoccachino.coffeeToString());
			myMoccachino.drink();
			
			UnicastRemoteObject.unexportObject(order, true);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
	}
}
