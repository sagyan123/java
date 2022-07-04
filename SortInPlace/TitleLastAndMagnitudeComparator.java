
/**
 * Write a description of TitleLastAndMagnitudeComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {
 public int compare (QuakeEntry q1, QuakeEntry q2){
     String q1Word = q1.getInfo().substring(q1.getInfo().lastIndexOf(" ") + 1); 
	String q2Word = q2.getInfo().substring(q2.getInfo().lastIndexOf(" ") + 1);
      if (q1Word.compareTo(q2Word)==0){
             return Double.compare(q1.getMagnitude(),q2.getMagnitude());
        }
        if(q1Word.compareTo(q2Word)<0) {
            return -1;
        }
       
        else{
     return  1;
    }
    }
}

