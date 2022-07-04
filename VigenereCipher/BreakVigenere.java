
/**
 * Write a description of sc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
import java.io.File;
public class BreakVigenere{
   


    CaesarCracker cc = new CaesarCracker();
    
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder sb = new StringBuilder(message);
        String slicedString = "";
        for(int i=whichSlice; i < sb.length();i+=totalSlices){
            char c = sb.charAt(i);
            slicedString = slicedString + c;
        }       
        return slicedString;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];     
        for(int i=0;i<key.length;i++){
            String sliced = sliceString(encrypted, i, klength);
            int k = cc.getKey(sliced);
            key[i] = k;
        }
        return key;
    }

    public void breakVigenere () {
        HashMap<String, HashSet<String>> language = new HashMap();
        DirectoryResource dr = new DirectoryResource();
       for (File f: dr.selectedFiles()){
           String name = f.getName();
           FileResource fr =new  FileResource(f);
           HashSet<String> Dictionary = readDictionary(fr);
           language.put(name, Dictionary);
        }
       FileResource fr = new FileResource();
        String encrypted = fr.asString();
        
       String right= breakForAllLang(encrypted,language);
       System.out.println(right);
    }
    
    public HashSet<String> readDictionary(FileResource fr){
        
        HashSet<String> words = new HashSet<String>();
        for (String word:fr.lines()){
            String w = word.toLowerCase();
            words.add(w);
    }
      return words;  
    }
    
    public int countWords(String message, HashSet<String> dictionary){
        int count = 0;
        for (String word: message.split("\\W+")){
            word = word.toLowerCase();
            if(dictionary.contains(word)){
                count++;
            }       
        }
        
        return count;
    }
    
    public String breakForLanguage(String encrypted, HashSet<String> dictionary){
        VigenereCipher vc; 
        String decryption = "";
        char most = mostCommonChar(dictionary);
        int keyLength = 0;
        for (int i = 1; i < 101; i++){
            int[] key = tryKeyLength(encrypted,i,most);
            
            vc = new VigenereCipher(key);
            String decrypt = vc.decrypt(encrypted);
            int length = countWords(decrypt,dictionary);
            if (length > keyLength){
                keyLength = length;
                decryption = decrypt;
            }    
    }
   
    return decryption; 
    }
    public char mostCommonChar(HashSet<String> Dictionary){
   HashMap<Character, Integer> common= new HashMap<Character,Integer>();
   int maxCount=0;
   int currCount=0;
   char most='e';
   for (String word: Dictionary){
       for (char letter : word.toCharArray()){
           if (common.keySet().contains(letter)){
               int value= common.get(letter)+1;
               
               common.put(letter,value);
            }
            else{
                common.put(letter,1);
            }
           
        }
    }
    for(char letter: common.keySet()){
        currCount= common.get(letter);
        if(currCount>maxCount){
            maxCount= currCount;
            most = letter;
        }
        
        
    }
    
    return most;
   }
   public String breakForAllLang(String encrypted,HashMap<String, HashSet<String>>language){
       int maxCount= 0;
       String bestText="";
       
       
        
        
        for(String lang: language.keySet()){
            HashSet<String> currdict = language.get(lang);
            String currDec= breakForLanguage(encrypted,currdict);
            int currCount= countWords(currDec,currdict);
            System.out.println("The no. of words in lang " + lang +"is"+currCount);
            if (currCount > maxCount){
                System.out.print( "The best language " + lang);
                maxCount= currCount;
                bestText= currDec;
                
            }
            currdict.clear();
        }
        
        System.out.println(maxCount);
        
        
        return bestText;
    }

}


