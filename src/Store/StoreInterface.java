
package Store;

import Balancer.BalancerInterface;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StoreInterface extends Remote {
    public void connectToBalancer(BalancerInterface balancer) throws RemoteException;
}
