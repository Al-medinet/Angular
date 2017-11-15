package org.musql.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.musql.entities.Comptes;

public interface RmiRemoteService extends Remote{

	public Comptes saveCompte(Comptes cp) throws RemoteException;
	public Comptes getCompte(String code) throws RemoteException;
}
