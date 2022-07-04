
/**
 * Write a description of decrypt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class decrypt {
    public String halfOfString(String message, int start){
        StringBuilder h1= new StringBuilder();
        StringBuilder h2= new StringBuilder();
        for (int i=0; i<message.length(); i++){
            if (i%2==0){
                h1.append(message.charAt(i));
            }
            else{
                h2.append(message.charAt(i));
            }
            
            
    }
    String half="";
     if(start==0){
         half= h1.toString();
         
        }
      else if (start==1){
           half = h2.toString();
        }
       
        return half;
        
        
}
    public int[] countLetters(String message){
        String alpha="abcdefghijklmnopqrstuvwxyz";
        int[] counts= new int[26];
        for (int i=0; i<message.length();i++){
            char ch = Character.toLowerCase(message.charAt(i));
            int dex= alpha.indexOf(ch);
            if(dex!=-1){
                counts[dex]++;
            }
            
        }
        return counts;
    }
    public int indexOfMax(int[] counts){
        int index=0;
        for(int i=0;i<counts.length;i++){
            if(counts[i]>counts[index]){
                index=i;
            }
            
        }
        return index;
        
    }
    public int getKey(String encrypted){
        int[] freqs = countLetters(encrypted);
        
        int maxDex = indexOfMax(freqs);
        
        int dkey= maxDex-4;
        if(maxDex <4) {
            
             dkey = maxDex-4+26;
            
        }
        
        
        return dkey;
    }
    public String decryptTwoKeys(String encrypted) {
        
        Cypher cc = new Cypher(); 
        String firsthalf= halfOfString(encrypted,0);
        String secondhalf= halfOfString(encrypted,1);
        int dkey= getKey(firsthalf);
        int d1key= getKey(secondhalf);
        System.out.println(encrypted);
        System.out.println("the Keys are "+ dkey +" and " + d1key);
        
        return cc.Encrypt(encrypted,26-dkey,26-d1key);
        
    }
    public void test(){
        FileResource fr= new FileResource();
        String message= fr.asString();
        String m= decryptTwoKeys(message);
        System.out.println(m);
        
    }

}
