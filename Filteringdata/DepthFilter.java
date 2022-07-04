
/**
 * Write a description of DepthFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DepthFilter implements Filter
 {
     private double maxDepth;
     private double minDepth;
     public DepthFilter(double max,double min){
         maxDepth= max;
         minDepth= min;
        }
     public boolean satisfies(QuakeEntry qe){
         return qe.getDepth()<=minDepth && qe.getDepth()>=maxDepth;
        

    }
}
