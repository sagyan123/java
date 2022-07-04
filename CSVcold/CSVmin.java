
/**
 * Write a description of CSVmin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
public class CSVmin {
    public CSVRecord Coldestoftheday(CSVParser parser){
        CSVRecord Smallestsofar=null;
        
        for(CSVRecord currentrow: parser){
            if (Smallestsofar == null){
                Smallestsofar= currentrow;
            
            }
            else{
                double currentTemp = Double.parseDouble(currentrow.get("TemperatureF"));
                double smallestTemp = Double.parseDouble(Smallestsofar.get("TemperatureF"));
                if( smallestTemp > currentTemp){
                    Smallestsofar= currentrow;
                }
                
            }
            
        }
        
        return Smallestsofar;
    }
    public CSVRecord ColdestDay(){
        CSVRecord Smallestsofar=null;
        DirectoryResource dr= new DirectoryResource();
        for( File f : dr.selectedFiles()){
            FileResource fr =new FileResource(f);
            CSVRecord currentrow = Coldestoftheday(fr.getCSVParser());
            if (Smallestsofar == null){
                Smallestsofar= currentrow;
            
            }
            else{
                double currentTemp = Double.parseDouble(currentrow.get("TemperatureF"));
                double smallestTemp = Double.parseDouble(Smallestsofar.get("TemperatureF"));
                if( smallestTemp > currentTemp){
                    Smallestsofar= currentrow;
                }
                
            }
            
            }
            return Smallestsofar;
    }
        
        
    
    public void ColdestinDay(){
        FileResource fr= new FileResource();
        CSVRecord largest= Coldestoftheday(fr.getCSVParser());
        System.out.println("Coldest in the day was"+ largest.get("TemperatureF")+ " at "+largest.get("TimeEST"));
        
    }

}
