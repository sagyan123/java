
/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class WordFrequencies { 
    private ArrayList <String> myWords;
    private ArrayList <Integer> myFreqs;
    public WordFrequencies(){
        myWords= new ArrayList<String>();
        myFreqs= new ArrayList<Integer>();
        
    }
    public void findUnique() { 
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        for(String s: fr.words()){
            s=s.toLowerCase();
            int index= myWords.indexOf(s);
            if (index==-1){
                myWords.add(s);
                myFreqs.add(1);
                
            }
            else{
                int value = myFreqs.get(index);
                myFreqs.set(index,value+1);
                
            }
        }
        
        
    }
    public int indexOfMax(){
        int maxindex=-1;
        int max=0;
        for(int i=0; i < myFreqs.size() ;i++){
            
            if(myFreqs.get(i) >max){
                max= myFreqs.get(i);
                maxindex=i;
            }
            
        }
        return maxindex ;
        
    }
    public void tester(){
        findUnique();
        System.out.println("The no. of unique words: "+ myWords.size());
        for(int k=0; k<myWords.size(); k++){
            System.out.println(myFreqs.get(k) +"\t"+ myWords.get(k));
            
        }
        int max =indexOfMax();
        String maa = myWords.get(max);
        int mx = myFreqs.get(max);
        System.out.println("The count of most occuring words is " + maa +"\t" + mx +" times" ); 
        
    }
    

}
