package Store;

import Balancer.BalancerInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Store extends UnicastRemoteObject implements StoreInterface {

    private String name;
    private int capacity;
    private int used;

    public Store(String name, int capacity) throws RemoteException {
        super();
        this.name = name;
        this.capacity = capacity;
        this.used = 0;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getUsed() {
        return used;
    }

    @Override
    public void connectToBalancer(BalancerInterface balancer) throws RemoteException {
        // TODO: Implement connection to balancer
    }

}
