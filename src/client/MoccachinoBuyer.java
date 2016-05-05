package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import server.Coffee;
import server.CoffeeCup;
import server.CoffeeOrder;
import server.ICoffeeMachine;
import server.Size;

public class MoccachinoBuyer implements ICoffeeBuyer{
	
	private CoffeeCup moccachino;
	
	public static void main(String[] args) {
	
		try {
			
			Registry registry = LocateRegistry.getRegistry("localhost", 1099);
			
			ICoffeeMachine coffeeServer = 
					(ICoffeeMachine) registry.lookup("CoffeeServer");
			CoffeeOrder order = new CoffeeOrder(new Date(2016, 5, 3),
					Coffee.MOCCACHINO, Size.LARGE, "Rachel");
			
			ICoffeeBuyer me = new MoccachinoBuyer();
			ICoffeeBuyer stub = 
					(ICoffeeBuyer) UnicastRemoteObject.exportObject(me, 0);
			
			
			coffeeServer.brew(order, me);
			
			UnicastRemoteObject.unexportObject(me, true);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void receiveCoffee(CoffeeCup coffee) throws RemoteException {
		this.moccachino = coffee;
		System.out.println("Coffee received from Server: " + coffee.toString());
	}
}
