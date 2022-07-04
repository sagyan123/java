
/**
 * Write a description of MarkovWordTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MarkovWordTwo implements IMarkovModel {
    

    private String[] myText;
    private Random myRandom;
    
    public MarkovWordTwo() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
		myText = text.split("\\s+");
	}
	
	public String getRandomText(int numWords){
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length-2);
		
		String key1 = myText[index];
		String key2 = myText[index+1];
		sb.append(key1);
		sb.append(" ");
		sb.append(key2);
		sb.append(" ");
		for(int k=0; k < numWords-2; k++){
		    ArrayList<String> follows = getFollows(key1,key2);
		    if (follows.size() == 0) {
		        break;
		    }
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			sb.append(" ");
			key1 = key2;
			key2=next;
		}
		
		return sb.toString().trim();
	}
	
	private int  indexOf(String[] Words,String Target1,String Target2,int start){
	    for (int k =start;k< Words.length; k++){
	        if (Words[k].equals(Target1)&& Words[k+1].equals(Target2)){
	            return k;
	           }
	       }
	    return -1;
	   }
	private ArrayList<String> getFollows(String key1,String key2) {
	    ArrayList<String> follows = new ArrayList<String>();
	    
	       
        
        /*for (int i = 0; i < myText.length - 2; i++) {
            if (myText[i].equals(key1) && myText[i+1].equals(key2)){
                String next = myText[i+2];
                follows.add(next);
            }
        }
        return follows;*/
        int pos = 0;
        
        
        while (pos < myText.length){
            int start = indexOf(myText,key1,key2,pos);
            
          
            if (start == -1) {
                break;
            }
            if (start + key2.length() > myText.length - 2){
                break;
            }
            int nextindx =start+key2.length();
            
            String next = myText[start+2];
            
            follows.add(next);
            pos = start + 2;
        }
        
    
	   return follows;
    }
    

}



