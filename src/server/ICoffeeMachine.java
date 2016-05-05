package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICoffeeMachine extends Remote{

	public ICoffeeCup brew(ICoffeeOrder order) throws RemoteException;
}
