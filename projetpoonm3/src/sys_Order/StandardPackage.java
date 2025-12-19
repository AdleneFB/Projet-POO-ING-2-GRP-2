package sys_Order;
import geographical_method.position;

public class StandardPackage implements Deliverable {
	private double weight;
	private position destination;
	 
	public StandardPackage(double weight, position destination) {
	        this.weight = weight;
	        this.destination = destination;
	   }
	 @Override
	  public double getWeight() {
	      return weight;
	    }

	  @Override
	  public position getDestination() {
	        return destination;
	    }
	  @Override
	  public String toString() {
	      return "StandardPackage(weight=" + weight +
	             ", destination=" + destination + ")";
	  }
	

}
