
/**
 * Write a description of Cypher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Cypher { 
    public String Encrypt(String input, int key,int ke){
        StringBuilder encrypted= new StringBuilder(input);
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String ShiftedAlphabet= alphabet.substring(key)+ alphabet.substring(0,key);
        String NextShift=  alphabet.substring(ke)+ alphabet.substring(0,ke);
        String small= alphabet.toLowerCase();
        String smallshift= ShiftedAlphabet.toLowerCase();
        String smallnext= NextShift.toLowerCase();
       for(int i=0;i < encrypted.length();i++){
           char currChar=encrypted.charAt(i);
           int idx= alphabet.indexOf(currChar);
            int idn= small.indexOf(currChar);
            if (i%2==0){
           if (idx!=-1){
               char newChar= ShiftedAlphabet.charAt(idx);
               
               encrypted.setCharAt(i,newChar);
            }
            else{
                if (idn!=-1){
                    char Char= smallshift.charAt(idn);
                    encrypted.setCharAt(i,Char);
                }
            }
        }
        else{
                       if (idx!=-1){
               char newChar= NextShift.charAt(idx);
               
               encrypted.setCharAt(i,newChar);
            }
            else{
                if (idn!=-1){
                    char Char= smallnext.charAt(idn);
                    encrypted.setCharAt(i,Char);
                }
            }
            
        }
           
        }
        
        return encrypted.toString();
    } 
    public void test(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        int key = 2;
        int ke=20;
        String encrypted = Encrypt("Top ncmy qkff vi vguv vbg ycpx", key,ke);
        System.out.println("key is " + key + "\n" + encrypted);
        String decrypted= Encrypt("Top ncmy qkff vi vguv vbg ycpx",26-key,26-ke);
        System.out.println(decrypted);
        
    }

}
