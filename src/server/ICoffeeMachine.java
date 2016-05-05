package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICoffeeMachine extends Remote{

	public CoffeeCup brew(CoffeeOrder order) throws RemoteException;
}
