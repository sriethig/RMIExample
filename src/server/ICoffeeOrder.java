package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface ICoffeeOrder extends Remote {
	
	//only those methods, that should be called by the client
	public String coffeeToString() throws RemoteException;

	public Date getDate() throws RemoteException;
	public Coffee getType() throws RemoteException;
	public Size getSize() throws RemoteException;
	public String getBuyer() throws RemoteException;
}
