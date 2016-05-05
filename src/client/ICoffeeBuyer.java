package client;

import java.rmi.Remote;
import java.rmi.RemoteException;

import server.CoffeeCup;

public interface ICoffeeBuyer extends Remote{
	public void receiveCoffee(CoffeeCup coffee) throws RemoteException;
}
