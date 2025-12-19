package Drone_Hierarchy;
import geographical_method.position;
import java.util.ArrayList;
import java.util.List;

public abstract class Drone {
	protected int id;
	protected position position;
	protected double battery;
	protected String model;
	protected double speed;
	protected double capacity;
	protected String stat;
	protected double distance;
	protected List<Position> positionHistory;
	private static int counter = 0;
	
	public Drone(Position position, String model, double speed, double capacity) {
        this.id = ++counter;
        this.position = position;
        this.model = model;
        this.speed = speed;
        this.capacity = capacity;
        this.battery = 100.0;
        this.status = "AVAILABLE";
        this.totalDistance = 0.0;
        this.positionHistory = new ArrayList<>();
        this.positionHistory.add(position);
    }
	
	 public abstract double calculateConsumption(double distance);
	 
	 public boolean canFlyTo(Position destination) {
	        double distance = position.distanceTo(destination) * 2; // round trip
	        double consumptionNeeded = calculateConsumption(distance);
	        return battery >= consumptionNeeded;
	    }
	 public void flyTo(Position destination) {
	        double distance = position.distanceTo(destination);
	        double consumption = calculateConsumption(distance);

	        battery -= consumption;
	        totalDistance += distance;
	        position = destination;
	        positionHistory.add(destination);
	    }
	 public void recharge(double percentage) {
	        battery += percentage;
	        if (battery > 100) {
	            battery = 100;
	        }
	    }
	 public int getId() {
	        return id;
	    }

	    public Position getPosition() {
	        return position;
	    }

	    public double getBattery() {
	        return battery;
	    }

	    public double getCapacity() {
	        return capacity;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public double getTotalDistance() {
	        return totalDistance;
	    }
	    
	    public void setStatus(String status) {
	        this.status = status;
	    }
	    @Override
	    public String toString() {
	        return "Drone{id=" + id +
	               ", model=" + model +
	               ", battery=" + battery +
	               ", status=" + status +
	               ", distance=" + totalDistance + "}";
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (!(obj instanceof Drone)) return false;
	        Drone other = (Drone) obj;
	        return this.id == other.id;
	    }
}
