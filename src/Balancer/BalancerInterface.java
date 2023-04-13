// BalancerInterface.java
package Balancer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BalancerInterface extends Remote {
    public void addItem(String item, int size) throws RemoteException;
}
