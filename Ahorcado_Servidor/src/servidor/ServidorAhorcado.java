/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import interfaces.InterfaceCliente;
import interfaces.InterfaceServidor;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class ServidorAhorcado extends UnicastRemoteObject implements InterfaceServidor{
    
    private Vector listaClientes;
    
   public ServidorAhorcado() throws RemoteException{
        super();
        listaClientes = new Vector();
    }

    @Override
    public void registrar(InterfaceCliente cliente) throws RemoteException {
        if(cliente!=null) 
            this.listaClientes.add(cliente);
    }

    @Override
    public void publicar(String msg) throws RemoteException {
         for(int i=0;i<this.listaClientes.size();i++){
            InterfaceCliente icl = (InterfaceCliente) this.listaClientes.get(i);
            icl.enviarMsg(msg);
       }
    }

    @Override
    public Vector obtenerJugadoresActivos() throws RemoteException {
        return listaClientes;
    }
    
    public static void main(String args[]){   
        try{
            ServidorAhorcado serv= new ServidorAhorcado();
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("servidor", serv);
            System.out.println("Servidor Ahorcado Activo.....");
        }catch(RemoteException e){
         e.printStackTrace();
        }
    }
}
