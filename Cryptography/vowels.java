
/**
 * Write a description of vowels here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class vowels { 
   public boolean isVowel(char ch){
        if (ch=='A' || ch=='E'|| ch=='I'||ch=='O'||ch=='U'){
            return true;
            
        }
        else if (ch=='a' || ch=='e'|| ch=='i'||ch=='o'||ch=='u'){
           return true;
            
        }
        else{
            return false;
        }
        
    }
    public void test(){
        if(isVowel('a')){
            System.out.println("true");
           
        }
        else{
            System.out.println("false");
        }
    }
}
    
