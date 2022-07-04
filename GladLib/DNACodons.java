
/**
 * Write a description of DNACodons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class DNACodons {
      HashMap <String,Integer> map = new HashMap<String,Integer>() ;
     public DNACodons(){
         map = new HashMap<String,Integer>();
        }
      public void buildCodonMap(String codon,int Start){
          map.clear();
          for (int i = Start; i< codon.length()-3;i+=3){
              String dna = codon.substring(i,i+3);
              if (!map.containsKey(dna)){
                  map.put(dna,1);
                }
                else{
                    int value= map.get(dna);
                    map.put(dna,value+1);
                }
                
            }
           
        }
        public String getMostCommonCodon(){
            int maxIndex=0;
            String mostCommon = "";
            for (String s: map.keySet()){
                int index=map.get(s);
                if(index>maxIndex){
                    maxIndex=index;
                    mostCommon= s;
                    
                }
            }
            return mostCommon;
        }
        public void printCodonCounts(int start, int end){
            
            
             for (String s : map.keySet()){
                 if (map.get(s)>=start && map.get(s)<=end){ 
                System.out.println( s +"\t"+ ":"+ map.get(s));
            }
            }
            
            String common = getMostCommonCodon();
            System.out.println("The most common Codon is "+ common);
        }
        public void test(){
             FileResource fr = new FileResource();
             String Codon= fr.asString();
             int i= 2;
             buildCodonMap(Codon,i);
             printCodonCounts(1,5);
            
        }
    
    
    

}
