
/**
 * Write a description of getyearname here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
public class getyearname {
    public int Ranking(int year,String Name, String Gender ){
        int boysrank=0;
        int girlsrank=0;
         int rank = 0;
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
                   rank= boysrank;
                  
                }
            }

        }
        
        return rank;
       
}
public String getName(int year,int rank, String Gender ){
        int boysrank=0;
        int girlsrank=0;
        String Name="";
       
        FileResource fr= new FileResource();
        for (CSVRecord rec:fr.getCSVParser(false)){
            
            if(rec.get(1).equals(Gender)){
                girlsrank +=1;
                if(rank== girlsrank){
                    Name = rec.get(0);
                    
                }
                
            }
            else if(rec.get(1).equals(Gender)){
                boysrank +=1;
                if (rank== boysrank){
                   Name=rec.get(0);
                  
                }
            }
            
            
        }
        return Name;
       
    }
    public void WhatName(String name,int year,int newyear,String Gender){
        int rank=0;
        String newname="";
        DirectoryResource dr= new DirectoryResource();
        for (File f: dr.selectedFiles()){
            FileResource fr= new FileResource(f);
            if (rank==0){
                rank = Ranking( year,name, Gender);
                
            
            
                newname= getName(newyear,rank, Gender);
            }
        }
        System.out.println(newname);
    }
    
    public void test(){
        String name = "Olivia";
        int year= 2013;
        int newyear= 2014;
        String Gender="F";
        WhatName( name, year,newyear, Gender);
        
        
    }
    

}
