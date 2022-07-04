
/**
 * Write a description of rank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
public class getrank {
    
    public int Ranking(int year,String Name, String Gender ){
        int boysrank=0;
        int girlsrank=0;
        int rank=-1;
       
        FileResource fr= new FileResource();
        for (CSVRecord rec:fr.getCSVParser(false)){
            
            if(rec.get(1).equals("F")){
                girlsrank +=1;
                if(rec.get(0).equals(Name)){
                    rank=girlsrank;
                    
                }
               
            }
            else if(rec.get(1).equals("M")){
                boysrank +=1;
                if (rec.get(0).equals(Name)){
                   rank=boysrank;
                  
                }
            }
            else{
              rank = -1;
            }
            
            
        }
        return rank;
}
 public void test(){
            String name = "Liam";
            int year = 2014;
            String Gender= "M";
            
            int rank= Ranking(year,name,Gender);
             System.out.println(rank);
             
        
           
        }

}

