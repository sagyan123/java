
/**
 * Write a description of PArt1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    
    public String Gene(String DNA){
        String result="";
        String dna = DNA.toUpperCase();
        
 
        
        int startcodon= dna.indexOf("ATG");
        if (startcodon == -1){
            result="";
            return result;
        }
        int stopcodon = dna.indexOf("TAA",startcodon+3);
        if (stopcodon==-1){
            result="";
            return result;
        }
        if ((stopcodon-startcodon)%3 ==0){
            result= dna.substring(startcodon,stopcodon+3);
            return result;
        }
        else {
            result="";
            return result;
        }
        
        
        
        
    }
    public void testGene(){
        String DNA = " ATGTAMAMAKAHYAUTAAKALAL";
        System.out.println("The DNA is" + DNA);
        String gene = Gene(DNA);
        System.out.println("The gene is"+gene);
        
        DNA = " TAAMANCITYLOSE";
        System.out.println("The DNA is" + DNA);
         gene = Gene(DNA);
        System.out.println("The gene is"+gene);
         DNA = " ATGTAMAMAKAHYAAAUTAAKALAL";
        System.out.println("The DNA is" + DNA);
         gene = Gene(DNA);
        System.out.println("The gene is"+gene);
        DNA = " atgismhijriptaa";
        System.out.println("The DNA is" + DNA);
        gene= Gene(DNA);
        System.out.println("The gene is" + gene);
        
    }
 }

    
