
/**
 * Write a description of DistanceFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DistanceFilter implements Filter {
 private Location loc;
 private double distance;
 public DistanceFilter(Location l , Double maxDis){
     loc= l;
     distance= maxDis;
    }
    public boolean satisfies(QuakeEntry qe){
        Location quakeLocation= qe.getLocation();
        return loc.distanceTo(quakeLocation)<=distance;
    }
}
