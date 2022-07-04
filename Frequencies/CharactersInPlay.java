
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class CharactersInPlay {
    private ArrayList <String> CharacterName;
    private ArrayList <Integer> CharFreq;
    public CharactersInPlay(){
        CharacterName = new ArrayList <String>();
        CharFreq = new ArrayList <Integer>();
    }
    
    public void FindAllCharacter(){
        CharacterName.clear();
        CharFreq.clear();
        FileResource fr= new FileResource();
        for(String line: fr.lines()){
            int endex= line.indexOf(".");
            if (endex!=-1){
                String name= line.substring(0,endex);
                update(name);
            }
            
        }
    }
    public void update(String Name){
        String name= Name;
        int index= CharacterName.indexOf(name);
        if (index==-1){
            CharacterName.add(name);
            CharFreq.add(1);
            
        }
        else{
            int val = CharFreq.get(index);
            CharFreq.set(index,val+1);
        }
        
        
        
     
        
    }
    public int indexOfMax(){
        int maxindex=-1;
        int max=0;
        for(int i=0; i < CharFreq.size() ;i++){
            
            if(CharFreq.get(i) >max){
                max= CharFreq.get(i);
                maxindex=i;
            }
            
        }
        return maxindex ;
        
    }
        public void tester(){
           FindAllCharacter();
           for( int i=0; i< CharacterName.size(); i++){
               String name= CharacterName.get(i);
               int num = CharFreq.get(i);
               
               
            
              
            if (num>10 && num<15){
            ;
            System.out.println( name+ "\t" + num);
              }
        }
    }
    

}
