/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.rmi.RemoteException;

/**
 *
 * @author CESAR IVAN MTZ
 */
public interface InterfaceCliente {
     public void enviarMsg(String msg)throws RemoteException;
     public String getUsername()throws RemoteException;
}
