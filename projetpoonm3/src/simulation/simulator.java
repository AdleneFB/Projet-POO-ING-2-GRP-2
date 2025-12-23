package simulation;
import control.controlcenter;
import Drone_Hierarchy.Drone;
import geographical_method.Mapc;
import geographical_method.position;
import sys_Order.Order;

public class simulator {
	private static final int SIMULATION_DURATION = 480;
	private controlcenter controlcenter;
	public simulator(controlcenter controlcenter) {
		this.controlcenter = controlcenter;
    for (int minute = 0; minute < SIMULATION_DURATION; minute++) {

        for (Order order : controlcenter.getPendingOrders()) {
        	controlcenter.assignOrder(order);
        }
        for (Drone drone : controlcenter.getFleet()) {

            if (drone.getStatus().equals("IN DELIVERY")) {

                drone.setStatus("RETURN TO BASE");
            }

            else if (drone.getStatus().equals("RETURN TO BASE")) {

                drone.flyTo(new position(0, 0));
                drone.setStatus("AVAILABLE");
            }}}
        
    }
    public void run() {
        for (int minute = 0; minute < SIMULATION_DURATION; minute++) {
        }
        
    printstats();}

    private void printstats() {
    	System.out.println("=== SIMULATION RESULTS ===");
    	System.out.println("Total deliveries: "+ control.controlcenter.totalDeliveries());
    	for(Drone drone : controlcenter.getFleet()) {
    		System.out.println(drone);
    	}}	
	}

