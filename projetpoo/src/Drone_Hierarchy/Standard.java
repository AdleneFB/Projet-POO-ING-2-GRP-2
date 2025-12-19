package Drone_Hierarchy;
import geographical_method.position;

public class Standard extends Drone{
	 private static final double CONSUMPTION_RATE = 3.0;
	 public Standard(position position) {
	        super(position, "StandardDrone", 30.0, 1.0);
	    }
	 @Override
	    public double calculateConsumption(double distance) {
	        return distance * CONSUMPTION_RATE;
	    }

}
