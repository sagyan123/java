
/**
 * Write a description of WhichCountriesExport here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class WhichCountriesExport {
    public void listExporters(CSVParser parser,String Export){
        for(CSVRecord record: parser){
            String export= record.get("Exports");
            if (export.contains(Export)){
                String country= record.get("Country");
                System.out.println(country);
                
            }
        }
        
    }
    public void Exportofcoffee(){
        FileResource fr= new FileResource();
        CSVParser parser= fr.getCSVParser();
        listExporters(parser,"coffee");
        
        
    }

}
