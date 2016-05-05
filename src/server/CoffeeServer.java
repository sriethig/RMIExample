package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CoffeeServer implements ICoffeeMachine {

	public static void main(String[] args) throws RemoteException {

		try {
			
			ICoffeeMachine server = new CoffeeServer();
			ICoffeeMachine stub = 
					(ICoffeeMachine) UnicastRemoteObject.exportObject(server, 0);
			
			LocateRegistry.createRegistry(1099);
			Registry coffeeRegistry = LocateRegistry.getRegistry("localhost", 1099);
			coffeeRegistry.bind("CoffeeServer", stub);
			
			System.out.println("CoffeeServer is up and running");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ICoffeeCup brew(ICoffeeOrder order) throws RemoteException {
		
		System.out.println(order.coffeeToString());
		ICoffeeCup orderedCoffee = new CoffeeCup(
				order.getType(), order.getSize(), order.getBuyer());
		
		ICoffeeCup stub = 
				(ICoffeeCup) UnicastRemoteObject.exportObject(orderedCoffee, 0);
		return stub;
	}

}
