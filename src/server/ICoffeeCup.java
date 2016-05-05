package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICoffeeCup extends Remote {

	public void drink() throws RemoteException;
	
	//toString method and RemoteException don't go together
	//https://docs.oracle.com/javase/7/docs/platform/rmi/spec/rmi-objmodel5.html
	public String coffeeToString() throws RemoteException;

	/*public Coffee getType() throws RemoteException;
	public Size getSize() throws RemoteException;
	public String getName() throws RemoteException;*/
}
