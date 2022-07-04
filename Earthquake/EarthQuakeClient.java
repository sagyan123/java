
/**
 * Write a description of EarthQuakeClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;

public class EarthQuakeClient {
    public EarthQuakeClient() {
        // TODO Auto-generated constructor stub
    }
    
    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData,
    double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for(QuakeEntry qe: quakeData){
            if(qe.getMagnitude()>magMin){
                answer.add(qe);
            }
        }

        return answer;
    }

    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData,
    double distMax,
    Location from) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
        // TODO
        
        for (QuakeEntry qe: quakeData){
        for (int i=1; i<copy.size();i++){
            QuakeEntry quake = copy.get(i);
            Location loc = quake.getLocation();
            if((loc.distanceTo(from)/1000) > distMax){
                answer.add(quake);
                copy.remove(i);
                
            }
        }
        
    }
          
        return answer;
    }

     public void dumpCSV(ArrayList<QuakeEntry> list){
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }

    }

    public void bigQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        ArrayList <QuakeEntry> Quakes = filterByMagnitude(list,5.0);
        for (int i=0;i<Quakes.size(); i++){
            System.out.println(Quakes.get(i));
        }
        System.out.println("read data for "+list.size()+" quakes");

    }

    public void closeToMe(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source ="data/nov20quakedatasmall.atom" ;
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        // This location is Durham, NC
        //Location city = new Location(35.988, -78.907);
        Location city =  new Location(38.17, -118.82);
         ArrayList<QuakeEntry>list2 = filterByDistanceFrom(list, 1000.0,city);
         
          for(int i=0; i<list2.size(); i++){
             
             QuakeEntry entry = list2.get(i);
             double distance = city.distanceTo(entry.getLocation());
             System.out.println(distance/1000 +" \t" +entry);
            }
        // This location is Bridgeport, CA
        

        // TODO
    }

     public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }
    }
    public ArrayList<QuakeEntry> filterByDepth (ArrayList<QuakeEntry> quakeData, double max , double  min){
        
        // TODO
                ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        
        // TODO
        
        for (QuakeEntry qe: quakeData){
            if (qe.getDepth()<min &&qe.getDepth()>max){
                answer.add(qe);
            }
        }
          
          return answer;
      }
     public void filterByDepth(){
        
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        ArrayList <QuakeEntry> Quakes = filterByDepth(list,-10000.0,-5000.0);
        
        for (int i=0;i<Quakes.size(); i++){
            System.out.println(Quakes.get(i));
        }
        System.out.println("read data for "+list.size()+" quakes");
        System.out.println("list size is " + Quakes.size());

    }
    public ArrayList<QuakeEntry> filterByPhrase(ArrayList <QuakeEntry> quakeData, String name,String phrase){
           ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        
        // TODO
        
        for (QuakeEntry qe: quakeData){
            String title= qe.getInfo();
            if (qe.getInfo().indexOf(phrase)!=-1){
                if (name=="any"){
                    answer.add(qe);
                }
                if (name=="start"&&title.startsWith(phrase)){
                    
                        answer.add(qe);
                    
                }
                if (name== "end" && title.endsWith(phrase)){
                    answer.add(qe);
                }
            }
        }
        return answer;
    }
    public void quakesByPhrase(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        ArrayList <QuakeEntry> Quakes = filterByPhrase(list, "start" , "Explosion");
        
        for (int i=0;i<Quakes.size(); i++){
            System.out.println(Quakes.get(i));
        }
        System.out.println("read data for "+list.size()+" quakes");
        System.out.println("list size is " + Quakes.size());
    }
          
          
    }
    
    


