/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import interfaces.InterfaceCliente;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class ClienteAhorcado extends UnicastRemoteObject implements InterfaceCliente{
    
     private String nombre;
   // private ClienteGUI  gui;
    
    public ClienteAhorcado(String nombre)throws RemoteException{
        super();
        this.nombre = nombre;
    }

    @Override
    public void enviarMsg(String msg) throws RemoteException {
         //gui.actualizarArea(msg);
    }

    @Override
    public String getUsername() throws RemoteException {
      return this.nombre;
    }
    
//      public void setGUI(ClienteGUI cg){
//        this.gui = cg;
//       }
    
}
