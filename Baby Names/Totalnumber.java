
/**
 * Write a description of Totalnumber here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;

public class Totalnumber {
    public void PrintNames(){
        FileResource fr = new FileResource();
        for(CSVRecord rec : fr.getCSVParser(false)){
            System.out.println ( "Name: "+ rec.get(0)+ " Gender: "+ rec.get(1) +" Number: " + rec.get(2));
                                  
        }
        
    }
    public void Totalnumber( FileResource fr){
        int totalborn=0;
        int totalmale=0;
        int totalfemale=0;
        for( CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            totalborn += numBorn;
            if( rec.get(1).equals("M")){
                totalmale += numBorn;
            }
            else{
                totalfemale += numBorn;
            }
        }
        
        System.out.println("The total births are: " + totalborn);
        System.out.println("The total male births are: " + totalmale);
        System.out.println("The total female births are: " + totalfemale);
        
    }
    public void Totalnumber(){
        FileResource f = new FileResource();
        Totalnumber(f);
    }

}
