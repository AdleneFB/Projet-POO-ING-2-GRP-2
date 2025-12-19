package control;
import java.util.ArrayList;
import java.util.List;

import Drone_Hierarchy.Drone;
import geographical_method.Mapc;
import geographical_method.position;
import sys_Order.Order;

public class controlcenter {
	private List<Drone> fleet;
    private List<Order> pendingOrders;
    private List<Order> processedOrders;
    private position base;
    private Mapc map;
    private static int totalDeliveries = 0;
    private static double totalDistance = 0.0;
    public controlcenter(position base, Mapc map) {
        this.base = base;
        this.map = map;
        this.fleet = new ArrayList<>();
        this.pendingOrders = new ArrayList<>();
        this.processedOrders = new ArrayList<>();
    }
    public void addDrone(Drone drone) {
        fleet.add(drone);
    }
    public Drone findDroneForOrder(Order order) {
        for (Drone drone : fleet) {

            boolean capacityOK =
                drone.getCapacity() >= order.getDeliverable().getWeight();

            boolean allowedDestination =
                map.isAllowed(order.getDeliverable().getDestination());

            boolean batteryOK =
                drone.canFlyTo(order.getDeliverable().getDestination());

            boolean available =
                drone.getStatus().equals("AVAILABLE");

            if (capacityOK && allowedDestination && batteryOK && available) {
                return drone;
            }
        }
        return null;
    }

    public boolean assignOrder(Order order) {
        Drone drone = findDroneForOrder(order);

        if (drone != null) {
            double cost = calculateDeliveryCost(order, drone);
            order.setCost(cost);

            order.setStatus("IN PROGRESS");
            drone.setStatus("IN DELIVERY");

            processedOrders.add(order);
            totalDeliveries++;

            return true;
        } else {
            pendingOrders.add(order);
            return false;
        }
    }
    public double calculateDeliveryCost(Order order, Drone drone) {
        double distance =
            base.distance(order.getDeliverable().getDestination()) * 2;

        double consumption =
            drone.calculateConsumption(distance);

        double operationCost =
            (distance * 0.1) + (consumption * 0.02) + 20;

        double insurance =
            Math.max(order.getCost() * 0.02, 10);

        if (order.getUrgency().equals("EXPRESS")) {
            insurance += 20;
        }

        return operationCost + insurance;
    }
    public List<Order> getPendingOrders() {
        return pendingOrders;
    }

    public List<Drone> getFleet() {
        return fleet;
    }
    public static int totalDeliveries() {
    	return totalDeliveries;
    }

    public static double getTotalDistance() {
        return totalDistance;
    }
}

