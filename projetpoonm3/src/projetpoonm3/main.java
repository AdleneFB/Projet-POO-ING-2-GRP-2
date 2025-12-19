package projetpoonm3;
import control.controlcenter;
import Drone_Hierarchy.Drone;
import Drone_Hierarchy.Standard;
import geographical_method.Mapc;
import geographical_method.position;
import sys_Order.Order;
import sys_Order.StandardPackage;
import simulation.simulator;

public class main {
	public static void Main(String[] args) {

        position base = new position(0, 0);
        Mapc map = new Mapc();

        controlcenter controlcenter = new controlcenter(base, map);

        controlcenter.addDrone(new Standard(base));

        Order order = new Order(
                "Client A",
                new StandardPackage(0.5, new position(10, 5)),
                "NORMAL",
                100
        );

        controlcenter.assignOrder(order);

        simulator simulator = new simulator(controlcenter);
        simulator.run();
    }
}