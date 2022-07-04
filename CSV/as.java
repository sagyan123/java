
/**
 * Write a description of as here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

/**
 * Write a description of LearningCSV here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
public class as {
    public void listcountries(CSVParser parser,String listcountry){
        
        for(CSVRecord record: parser){
            String country= record.get("Country");
            if (country.contains(listcountry)){
                
                String export = record.get("Exports");
                
                String amount=record.get ("Value (dollars)");
                System.out.println(country+": "+ export+ ": "+ amount);
                
                
                
            }
            }
            else{
                print ("Not 
            }
            

        }
        public void Exportofcoffee(){
        FileResource fr= new FileResource();
        CSVParser parser= fr.getCSVParser();
        listcountries(parser,"Cyprus");
        
        
    }
        
        
            
     
        
    }
   



