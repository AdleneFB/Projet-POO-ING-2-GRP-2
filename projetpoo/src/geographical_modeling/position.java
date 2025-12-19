package geographical_modeling;

public class position {
	private double x;
	private double y;
	public position(double x, double y) {
		this.x=x;
		this.y=y;
	}
	public double distance(position other) {
		double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
	}
	public double getx() {
		return x;
	}
	public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    @Override
    public String toString() {
        return "Position(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
    	if (this==obj) return true;
    	if (!(obj instanceof position)) return false;
    	position other = (position) obj;
    	return this.x == other.x && this.y == other.y;
    }

}
