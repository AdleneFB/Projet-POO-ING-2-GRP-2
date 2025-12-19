package geographical_modeling;

public class NoFlyZone {
	private position center;
	private double radius;
	public NoFlyZone(position center, double radius) {
		this.center=center;
		this.radius=radius;
	}
	public boolean contains(position p) {
		return center.distanceTo(p) <= radius;
	}
	public Position getCenter() {
        return center;
    }

    public void setCenter(Position center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
	@Override
    public string tostring() {
    	return "this is a NoFlyZone, center is" +center+ "and it has a radius of"+radius+" GET OUT";
    }


}
