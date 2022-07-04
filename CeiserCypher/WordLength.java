
/**
 * Write a description of WordLength here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class WordLength {
    public int indexOfmax(int[] counts){
        int index=0;
        for (int i=1; i<counts.length;i++){
            if ( counts[i]> counts[index]){
                index=i;
            } 
            
            
        }
        return index;
    }
    public boolean CharisLetter(char ch){
        String alphabet= "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOP";
        int idx =alphabet.indexOf(ch);
        if(idx!=-1){
            return true;
        }
        else{
            return false;
        }
    }
    public int[] countOfWords(FileResource resource, int[] counts){
        for(String s: resource.words()){
            if (CharisLetter(s.charAt(s.length()-1))&&(CharisLetter(s.charAt(0)))){
            counts[s.length()]++;
        }
        else{
            counts[s.length() - 1]++;
        }
    }
    for(int k=0;k<counts.length;k++){
            if (counts[k]!=0){
                System.out.println("the count of lentgth "+k+ "is "+ counts[k]);
                
            }
        }
        
        return counts;
        }
    
    
       public void test(){
          FileResource fr= new FileResource();
          int[] counts= new int[31];
          
          
          int[] result=countOfWords(fr, counts);
          int max= indexOfmax(result);
          System.out.println("The position of largest element in values is at length "+max);
          
    }

}

