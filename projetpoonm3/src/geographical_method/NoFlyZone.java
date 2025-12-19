package geographical_method;

public class NoFlyZone {
	private position center;
	private double radius;
	public NoFlyZone(position center, double radius) {
		this.center=center;
		this.radius=radius;
	}
	public boolean contains(position p) {
		return center.distance(p) <= radius;
	}
	public position getCenter() {
        return center;
    }

    public void setCenter(position center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public String tostring() {
    	return "this is a NoFlyZone, center is" +center+ "and it has a radius of"+radius+" GET OUT";
    }


}
