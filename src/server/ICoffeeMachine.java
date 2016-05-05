package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client.ICoffeeBuyer;

public interface ICoffeeMachine extends Remote{

	public void brew(CoffeeOrder order, ICoffeeBuyer buyer) throws RemoteException;
}
