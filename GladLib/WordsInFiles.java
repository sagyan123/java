
/**
 * Write a description of WordsInFiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
import java.io.File;
public class WordsInFiles { 
    private HashMap<String, ArrayList<String>> map = new HashMap< String, ArrayList<String> >();
    public WordsInFiles(){
        map = new HashMap<String,ArrayList<String>>();
        
    }
    private void addWordsFromFile(File f) {
        FileResource fr = new FileResource(f);
        
        
        for (String sKey : fr.words()) {
            
            ArrayList<String> alfilename;
            if (map.containsKey(sKey)) {
                alfilename = map.get(sKey);
                if (!alfilename.contains(f.getName())) {
                    alfilename.add(f.getName());
                }
            }
            else {
                alfilename = new ArrayList<String>();
                alfilename.add(f.getName());
            }
            
            map.put(sKey, alfilename);
           
        }
    }
    public void BuildWorldFileMap(){
        map.clear();
        DirectoryResource dr= new DirectoryResource();
        for ( File f : dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }
    public int maxNumber(){
        int maxCount=0;
        for (String word : map.keySet()){
            ArrayList<String> CurrentList = map.get(word);
            int curr =CurrentList.size();
            if (curr>maxCount){
                maxCount= curr;
                
            }
           }
           return maxCount;
      }
      public ArrayList <String> wordInNumFiles(int num){
          ArrayList <String> ReturnList = new ArrayList<String>();
          for ( String word: map.keySet()){
              ArrayList<String> CurrentList = map.get(word);
              int Currnum= CurrentList.size();
              if ( Currnum== num){
                  
                  ReturnList.add(word);
                }
              
              
            }
            return ReturnList;
        }
        public void printFilesName(String Word){
            for (String s: map.keySet()){
                if (s== Word){
                    System.out.println( Word+ "\t" + map.get(s));
                }
                
            }
            }
      public void tester(){
          BuildWorldFileMap();
          int maxnumber = maxNumber();
          ArrayList <String> Maxword = wordInNumFiles(2);
          System.out.println("The word appears in "+ maxnumber + " files" );
          System.out.println(Maxword);
          
          for (int k=0; k< Maxword.size(); k++){
              printFilesName(Maxword.get(k));
              
            }
          
          
          
          
        }
  }

