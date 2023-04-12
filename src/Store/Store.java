package Store;
import balancer.Balancer;
import java.io.Serializable;
import java.rmi.RemoteException;

public class Store implements Serializable {

  public double getStoreDet(balancer b) throws RemoteException;
  
}
