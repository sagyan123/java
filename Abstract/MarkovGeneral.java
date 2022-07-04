
/**
 * Write a description of MarkovOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
public class MarkovGeneral extends AbstractMarkovModel {
    
	private int numb;
	
	public MarkovGeneral( int num) {
		myRandom = new Random();
		numb=num;
		System.out.println( "The model is " + num);
		
	}
	
	public void setRandom(int seed){
		myRandom = new Random(seed);
	}
	
	public void setTraining(String s){
		myText = s.trim();
	}
	
	public String getRandomText(int numChars){
		if (myText == null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length()-numb);
			String key = myText.substring(index,index+numb);
			sb.append(key);
		for(int k=0; k < numChars-numb; k++){
		    ArrayList <String> follows = getFollows(key);
		      if(follows.size()==0){
		        break;
		      }
		      index =myRandom.nextInt(follows.size());
		      String next = follows.get(index);
		      sb.append(next);
		      key= key.substring(1)+next;
		  }
		
		return sb.toString();
	}

}
