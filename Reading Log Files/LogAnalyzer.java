
/**
 * Write a description of LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records= new ArrayList<LogEntry>();
     }
        
     public void readFile() {
         // complete method
         FileResource fr = new FileResource();
         for (String line: fr.lines()){
             WebLogParser Parser = new WebLogParser();
             LogEntry pr = Parser.parseEntry(line);
             records.add(pr);
             
             
             
             
            }
     }
     public int CountUniqueIps(){
         ArrayList<String> UniqueIps = new ArrayList <String>();
         
         for (LogEntry le : records){
             
             String ipAddr = le.getIpAddress();
             if (!UniqueIps.contains(ipAddr)){
                 UniqueIps.add(ipAddr);
                }
             
             
             
            } 
            return UniqueIps.size();
        }
         public void PrintAllHigherThan( int num){
             ArrayList<String> UniqueIps = new ArrayList <String>();
             ArrayList <Integer> unique = new ArrayList <Integer> ();
             for (LogEntry le: records){
                 int Status = le.getStatusCode();
                 String IpAddr = le.getIpAddress();
                 
                 if (Status> num && !UniqueIps.contains(IpAddr)){
                     UniqueIps.add(IpAddr);
                     
                     if (!unique.contains(Status)){
                     System.out.println(Status);
                    }
                    }
                }
             
              System.out.println(UniqueIps);
    }
    public ArrayList<String> uniqueIPVisitsOnDay(String Someday){
        ArrayList <String> IpOfDay = new ArrayList <String>();
        for (LogEntry le: records){
            Date d = le.getAccessTime();
            String di = d.toString();
             di= di.substring(4,10);
            String IpAddr = le.getIpAddress();
            if (di.equals(Someday)&& !IpOfDay.contains(IpAddr)){
                IpOfDay.add(IpAddr);
            }
            
            
        }
        
        return IpOfDay;
        
    }
    public void PrintAllBetween( int num,int nu){
             ArrayList<String> UniqueIps = new ArrayList <String>();
             for (LogEntry le: records){
                 int Status = le.getStatusCode();
                 String IpAddr = le.getIpAddress();
                 if(!UniqueIps.contains(IpAddr)){
                 if (Status>= num && Status<=nu){
                     UniqueIps.add(IpAddr);
                    }
                }
                }
             
              System.out.println(UniqueIps.size());
    }
    public HashMap<String,Integer> CountVisitsPerIp(){
        HashMap<String,Integer> counts= new HashMap<String,Integer>();
        for (LogEntry le: records){
            String ip = le.getIpAddress();
            if (!counts.containsKey(ip)){
                counts.put(ip,1);
            }
            else{
                int value =counts.get(ip);
                counts.put(ip, value+1);
                
            }
        }
        return counts;
    }
    public int HighVisitsPerIp(){
        HashMap<String,Integer> counts= CountVisitsPerIp();
        int maxCount=0;
        for (String max: counts.keySet()){
           int curr = counts.get(max);
            if (curr>maxCount){
                maxCount= curr;
                
            }
            
        }
        return maxCount;
    }
    public ArrayList <String> IpMostVisit(HashMap<String,Integer> counts){
        int maxCount=0;
        ArrayList<String> ip = new ArrayList<String>();
        for (String max: counts.keySet()){
           int curr = counts.get(max);
            if (curr>maxCount){
                maxCount= curr;
                
            }
            
        }
        for (String max: counts.keySet()){
            int curr = counts.get(max);
            if (curr==maxCount){
                ip.add(max);
            }
        }
        return ip;
    }
    public HashMap<String,ArrayList<String>> iPsForDays(){
        HashMap <String,ArrayList<String>> ip = new HashMap<String, ArrayList<String>>();
        
        for(LogEntry le: records){
         Date d = le.getAccessTime();
            
            String date= d.toString().substring(4,10);
            
            
         if(!ip.containsKey(date)){
             ArrayList<String> myname= new ArrayList<String>();
             
             myname.add(le.getIpAddress());
             
             ip.put(date,myname);
            }
         else{
              ArrayList <String> Myname= ip.get(date);
             Myname.add(le.getIpAddress());
             ip.put(date,Myname);
             
             
             
            }
            
    }
    return ip;
    }
        public String MostIpDay(HashMap<String, ArrayList<String>> ip){
            int maxCount= 0;
            String ate= "";
             for(LogEntry le: records){
         Date d = le.getAccessTime();
            
            String date= d.toString().substring(4,10);
            
            
         if(!ip.containsKey(date)){
             ArrayList<String> myname= new ArrayList<String>();
             
             myname.add(le.getIpAddress());
             
             ip.put(date,myname);
            }
         else{
              ArrayList <String> Myname= ip.get(date);
             Myname.add(le.getIpAddress());
             ip.put(date,Myname);
             
             
             
            }
            
    }
     for (String s : ip.keySet()){
         int curr= ip.get(s).size();
         if (curr>maxCount){
             maxCount= curr;
               ate=s;
            }
        }       
     
            
            
       return ate;     
 }
 public ArrayList<String> MosTIpsofDay(HashMap<String, ArrayList<String>> map, String Day){
     
    
        
        ArrayList<String> allIPs = map.get(Day);
        HashMap<String,Integer> visiterPerIP = new HashMap<String, Integer>();
        for (String s : allIPs) {
            
            
              if(!visiterPerIP.containsKey(s)) {
                visiterPerIP.put(s,1);
              }
              else {
                visiterPerIP.put(s, visiterPerIP.get(s)+1);
              }
        }
        
        return IpMostVisit(visiterPerIP);
    }
        
 
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
     
}



