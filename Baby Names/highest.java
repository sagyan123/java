
/**
 * Write a description of highest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
public class highest {
    public int getRank(String Name, String Gender ){
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
    public int HighestRank(String Name, String Gender){
        int newRank= 0;
        int currentRank=0;
        DirectoryResource dr = new DirectoryResource();
        for(File F: dr.selectedFiles()  ){
            FileResource fr= new FileResource(F);
            currentRank= getRank(  Name,  Gender);
            if (newRank == 0){
                newRank= currentRank;
                
            }
            else{
                if (newRank>=currentRank && currentRank!=1){
                    newRank= currentRank;
                }
               
                    
            
              
                
            }
            
        }
        return newRank;
    }
    public void test(){
         int ans =HighestRank("Anna" ,"F");
         System.out.println( "The Highest rank is "+ans);
        
    }

}
