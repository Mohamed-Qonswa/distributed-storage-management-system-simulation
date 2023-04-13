package Balancer;

import Store.Store;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Balancer extends UnicastRemoteObject implements BalancerInterface {
     static BalancerUI server_form = new BalancerUI(); 
    private List<Store> stores;
    private Map<String, Integer> storeUsage;
    private Map<String, List<String>> itemsByStore;
    private Random random;

    public static void main(String[] args) throws Exception {
        Balancer b = new Balancer ();
       Registry r = LocateRegistry.createRegistry(1099);
       r.rebind("Balancer", b);
       b.server_form.setVisible(true);
    }
    public Balancer(List<Store> stores) throws RemoteException {
        super();
        this.stores = stores;
        this.storeUsage = new HashMap<>();
        this.itemsByStore = new HashMap<>();
        this.random = new Random();
        for (Store store : stores) {
            storeUsage.put(store.getName(), 0);
            itemsByStore.put(store.getName(), new ArrayList<>());
        }
    }

    private Balancer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addItem(String item, int size) throws RemoteException {
        String id = generateId();
        String store = getLeastUsedStore();
        storeUsage.put(store, storeUsage.get(store) + size);
        itemsByStore.get(store).add(id);
        System.out.println("Item added. ID: " + id + ", size: " + size + " MB, assigned to store: " + store);
    }

    private String generateId() {
        return "item" + random.nextInt(1000); // Example ID generation
    }

    private String getLeastUsedStore() {
        String leastUsed = stores.get(0).getName();
        int leastUsage = storeUsage.get(leastUsed);
        for (int i = 1; i < stores.size(); i++) {
            String storeName = stores.get(i).getName();
            int currentUsage = storeUsage.get(storeName);
            if (currentUsage < leastUsage) {
                leastUsed = storeName;
                leastUsage = currentUsage;
            }
        }
        return leastUsed;
    }

}

