
/**
 * Write a description of CieserCypher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CieserCypher {
    private String alphabet;
    private String shiftedAlphabet;
    private String smallAlphabet;
    private String smallShift;
    private int mainKey;
    public CieserCypher(int key){
        mainKey= key;
        alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        smallAlphabet="abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabet= alphabet.substring(key)+ alphabet.substring(0,key);
        smallShift= smallAlphabet.substring(key)+ smallAlphabet.substring(0,key);
    }
    public String Encrypt(String message){
        StringBuilder sb= new StringBuilder(message);
        for (int i=0; i<sb.length();i++){
            char c=sb.charAt(i);
            int idx= alphabet.indexOf(c);
            int idn= smallAlphabet.indexOf(c);
            if (idx!=-1){
                char ch= shiftedAlphabet.charAt(idx);
                sb.setCharAt(i,ch);
        }
        else if(idn!=-1){
             char ch= smallShift.charAt(idn);
            sb.setCharAt(i,ch);
        }
        else {
            sb.setCharAt(i,c);
        }
    }
    return sb.toString();
    

    }
    
    public String Decrypt(String input){
        CieserCypher cc= new CieserCypher(26-mainKey);
        
         return cc.Encrypt(input);
    }
    
   }

