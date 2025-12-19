package geographical_method;

public class DeliveryZone {
	private position center;
	private double radius;
	public DeliveryZone(position center, double radius) {
		this.center = center;
		this.radius = radius;
	}
	public boolean contain(position p)	{
		return center.distance(p) <=radius;
	}
	public position whatcenter() {
		return center;
	}
	public void setcenter(position center) {
		this.center = center;
	}
	public double whatradius() {
		return radius;
	}
	public void setradius(double radius) {
		this.radius = radius;
	}
	public String tostring() {
		return "deliverance zone: center is " + center + "and the radius is " + radius;
	}
}
