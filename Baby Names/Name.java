
/**
 * Write a description of Name here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;

public class Name {
    public void Ranking(int year,int rank, String Gender ){
        int boysrank=0;
        int girlsrank=0;
       
        FileResource fr= new FileResource();
        for (CSVRecord rec:fr.getCSVParser(false)){
            
            if(rec.get(1).equals(Gender)){
                girlsrank +=1;
                if(rank== girlsrank){
                    System.out.println("The name is: "+ rec.get(0));
                    
                }
                
            }
            else if(rec.get(1).equals(Gender)){
                boysrank +=1;
                if (rank== boysrank){
                   System.out.println("The name is: "+ rec.get(0));
                  
                }
            }
            
            
        }
       
    }
     public void test(){
         Ranking(2012,5,"M");
        }
}
