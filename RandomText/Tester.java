
/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class Tester {
 public void testGetFollows(){
     
     String key = "this is a test yes this is a test.";
     
     MarkovGeneral Markov= new MarkovGeneral();
     		Markov.setTraining(key);
     ArrayList<String> list = Markov.getFollows("es");
     System.out.println(list.size());
     System.out.println(list);
     
     
    }
}
