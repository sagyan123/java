
/**
 * Write a description of MarkovOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
public class MarkovGeneral {
    private String myText;
	private Random myRandom;
	
	public MarkovGeneral() {
		myRandom = new Random();
	}
	
	public void setRandom(int seed){
		myRandom = new Random(seed);
	}
	
	public void setTraining(String s){
		myText = s.trim();
	}
	
	public String getRandomText(int numChars,int num){
		if (myText == null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length()-num);
			String key = myText.substring(index,index+num);
			sb.append(key);
		for(int k=0; k < numChars-num; k++){
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
	public ArrayList<String> getFollows(String key){
	       
        ArrayList<String> follows = new ArrayList<String>();
        
        int pos = 0;
        
        
        while (pos < myText.length()){
            int start = myText.indexOf(key,pos);
            
          
            if (start == -1) {
                break;
            }
            if (start + key.length() > myText.length() - 1){
                break;
            }
            int nextindx =start+key.length();
            
            String next = myText.substring(nextindx,nextindx+1);
            
            follows.add(next);
            pos = start + 1;
        }
        return follows;
    
	   
	   

}
}
