
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class WordPlay {
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
    public void changeVowel(String phrase, char ch,char cha){
        StringBuilder newphrase= new StringBuilder(phrase);
        for (int i=0; i<phrase.length();i++){
            char currchar= newphrase.charAt(i);
            
             if (i%2==0){
                if (isVowel(currchar)){
                    newphrase.setCharAt(i,ch);
                }
                else{
                    newphrase.setCharAt(i,currchar);
                }
            }
            else{
            if (isVowel(currchar)){
                    newphrase.setCharAt(i,cha);
                }
                else{
                    newphrase.setCharAt(i,currchar);
                }
            }
    }
    System.out.println(newphrase);
}
public void test(){
    String Phrase= "Hello World";
    char ch= '#';
    char cha= '*';
    changeVowel(Phrase,ch,cha);
}
}
