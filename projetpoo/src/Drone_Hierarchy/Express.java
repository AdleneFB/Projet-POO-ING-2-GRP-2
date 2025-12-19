package Drone_Hierarchy;
import geographical_method.position;

public class Express extends Drone{
	private static final double CONSUMPTION_RATE = 4.0;
	public Express(position position) {
		super(position,"Express", 45, 1.0);
	}
	@Override
    public double calculateConsumption(double distance) {
        return distance * CONSUMPTION_RATE;
    }

}
