package projetpoo;
import geographical_method.position;

public class StandardPackage implements Deliverable {
	private double weight;
	private position destination;
	 
	public StandardPackage(double weight, Position destination) {
	        this.weight = weight;
	        this.destination = destination;
	   }
	 @Override
	  public double getWeight() {
	      return weight;
	    }

	  @Override
	  public Position getDestination() {
	        return destination;
	    }
	  @Override
	  public String toString() {
	      return "StandardPackage(weight=" + weight +
	             ", destination=" + destination + ")";
	  }
	

}
