
/**
 * Write a description of MarkovWord here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MarkovWord implements IMarkovModel {
     private String[] myText;
     private Random myRandom;
     private int myOrder; 
     public MarkovWord(int order) {
        myRandom = new Random();
        myOrder= order;
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
		myText = text.split("\\s+");
	}
	
	public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-myOrder);  // random word to start with
        WordGram kGram = new WordGram(myText, index, numWords);
        sb.append(kGram);
        sb.append(" ");
        for(int k=0; k < numWords-myOrder; k++){
            ArrayList<String> follows = getFollows(kGram);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            kGram = kGram.shiftAdd(next);
        }
        return sb.toString().trim();
    }
	  private int  indexOf(String[] Words,WordGram Target,int start){
	    for (int k =start;k< Words.length; k++){
	        if (Words[k].equals(Target)){
	            return k;
	           }
	       }
	    return -1;  
    }
	private ArrayList<String> getFollows(WordGram kgram) {
	    ArrayList<String> follows = new ArrayList<String>();
	    
	       
        
        
        int pos = 0;
        
        
        while (pos < myText.length){
            int start = indexOf(myText,kgram,pos);
            
          
            if (start == -1) {
                break;
            }
            if (start + kgram.length() > myText.length - 1){
                break;
            }
            int nextindx =start+kgram.length();
            
            String next = myText[start+1];
            
            follows.add(next);
            pos = start + 1;
        }
        
    
	   
	    return follows;
    }

}

    

