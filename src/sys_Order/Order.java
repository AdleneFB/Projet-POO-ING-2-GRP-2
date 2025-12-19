package sys_Order;
import geographical_method.position;

public class Order {
	private int id;
    private String client;
    private Deliverable deliverable;
    private double cost;
    private String urgency;
    private String status;
    private static int counter = 0;
    
    public Order(String client, Deliverable deliverable, String urgency, double cost) {
        this.id = ++counter;
        this.client = client;
        this.deliverable = deliverable;
        this.urgency = urgency;
        this.cost = cost;
        this.status = "PENDING";
    }
    public int getId() {
        return id;
    }

    public Deliverable getDeliverable() {
        return deliverable;
    }

    public double getCost() {
        return cost;
    }

    public String getUrgency() {
        return urgency;
    }

    public String getStatus() {
        return status;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setStatus(String status) {
        this.status = status;}
    @Override
    public String toString() {
        return "Order{id=" + id +
               ", client='" + client + '\'' +
               ", urgency=" + urgency +
               ", status=" + status +
               ", cost=" + cost + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Order)) return false;
        Order other = (Order) obj;
        return this.id == other.id;
    }


}
