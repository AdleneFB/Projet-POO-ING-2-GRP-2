package Drone_Hierarchy;
import geographical_method.position;

public class Heavy extends Drone{
	private static final double CONSUMPTION_RATE = 5.0;
	public Heavy(position position) {
		super(position,"Heavy", 20, 3.0);
	}
	@Override
    public double calculateConsumption(double distance) {
		if (battery < 20) {
            this.speed = 16.0;
        } else {
            this.speed = 20.0;
        }
        return distance * CONSUMPTION_RATE;
    }
	}
}
