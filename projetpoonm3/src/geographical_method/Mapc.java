package geographical_method;
import java.util.ArrayList;
import java.util.List;
public class Mapc {
    private List<DeliveryZone> deliveryZones;
    private List<NoFlyZone> noFlyZones;
    
	public Mapc(){
		this.deliveryZones = new ArrayList<>();
        this.noFlyZones = new ArrayList<>();
	}

	public void addDeliveryZone(DeliveryZone zone) {
        deliveryZones.add(zone);
	}

	public List<DeliveryZone> getDeliveryZones() {
        return deliveryZones;
    }

	public void addNoFlyZone(NoFlyZone zone) {
        noFlyZones.add(zone);
    }

	public List<NoFlyZone> getNoFlyZones() {
        return noFlyZones;
    }

	public boolean isAllowed(position p) {
	        return !isForbidden(p);
	    }

	public boolean isForbidden(position p) {
	       for (NoFlyZone zone : noFlyZones) {
	           if (zone.contains(p)) {
	               return true;
	            }
	        }
	       return false;
	   }

	@Override
    public String toString() {
        return "Map{deliveryZones=" + deliveryZones + ", noFlyZones=" + noFlyZones + "}";
    }
}


