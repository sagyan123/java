
/**
 * Write a description of xuan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class xuan {
    public int findStopCodon(String dna, int startindex, String stopcodon){
        int currindex = dna.indexOf(stopcodon,startindex+3);
        while(currindex!=-1){
            int remainder = ((currindex-startindex)%3);
            if(remainder==0){
                return currindex;
            }
            else{
                currindex=dna.indexOf(stopcodon,startindex+3);
            }
            
            
        }
        return dna.length();
}
     public String findGene(String dna,int where){
         int startindex= dna.indexOf("ATG",where );
         if (startindex ==-1){
            return "";
            }
          int taaindex= findStopCodon(dna,startindex,"TAA");
          int tagindex= findStopCodon(dna,startindex,"TAG");
          int tgaindex= findStopCodon(dna,startindex,"TGA");
          int min= Math.min(taaindex,tagindex);
          int minindex= Math.min(min,tgaindex);
          if(minindex== dna.length()){
              return"";
            }
            return dna.substring(startindex,minindex+3);
            
            
         
         
         
        }
        public void findallGene(String dna){
            int startindex =0;

             int n=0;
            
            while(true){ 
                 String currentGene = findGene(dna,startindex);
                if(currentGene!=""){
                    n=n+1;
                }
              
                
                if (currentGene==""){
                    
                    break;
                    
                    
                }
                    
                
            
                startindex= dna.indexOf(currentGene,startindex)+currentGene.length();
                
               
            
            
                
            
            }
            
            System.out.println(Math.max(n,n));
            
            
        }
           
        public void testOn(String dna){
            
        
            System.out.println("The number of gene is:");
            findallGene(dna);
           
        }
        public void test(){
            testOn("ATGTHUYUZTAAATGHOPTGAIUMNIGBARTAG");
            testOn("");
            
        }
            

}
