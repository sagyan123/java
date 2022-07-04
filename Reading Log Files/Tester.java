


/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method'
        
        LogAnalyzer lg= new LogAnalyzer();
        lg.readFile();
        lg.printAll();
        
        
        
    }
    public void testUniqueIp(){
        LogAnalyzer lg = new LogAnalyzer();
        lg.readFile();
         int Ips = lg.CountUniqueIps();
         System.out.println("The no. of Ips is " + Ips);
    }
    public void testPrintHigherThan(){
        LogAnalyzer lg = new LogAnalyzer();
        lg.readFile();
        lg.PrintAllHigherThan( 400);
        
    }
    public void testIpOfDay(){
        LogAnalyzer lg = new LogAnalyzer();
        lg.readFile();
        ArrayList<String> list = lg.uniqueIPVisitsOnDay("Mar 24");
        int total = list.size();
        System.out.println(total);
        
        
        
    }
    public void testPrintBetween(){
        LogAnalyzer lg = new LogAnalyzer();
        lg.readFile();
        lg.PrintAllBetween( 300,399);
        
    }
    public void perIp(){
        LogAnalyzer lg = new LogAnalyzer();
        lg.readFile();
        HashMap <String,Integer> count = lg.CountVisitsPerIp();
        System.out.println(count);
    }
    public void maxIp(){
        LogAnalyzer lg = new LogAnalyzer();
        lg.readFile();
        int max = lg.HighVisitsPerIp();
        System.out.println("The Ip was shown " + max+ " times");
    }
    public void maxIpname(){
        LogAnalyzer lg = new LogAnalyzer();
        lg.readFile();
        HashMap <String,Integer>count = lg.CountVisitsPerIp();
        ArrayList< String> name = lg.IpMostVisit(count);
        System.out.println(name);
    }
    public void testforDays(){
         LogAnalyzer lg = new LogAnalyzer();
        lg.readFile();
        HashMap<String, ArrayList<String>> Ip = lg.iPsForDays();
        System.out.println(Ip);
    }
    public void highestIp(){
         LogAnalyzer lg = new LogAnalyzer();
        lg.readFile();
        HashMap<String, ArrayList<String>> Ip = lg.iPsForDays();
        System.out.println(lg.MostIpDay( Ip));
    }
    public void highestofIp(){
         LogAnalyzer lg = new LogAnalyzer();
        lg.readFile();
        HashMap<String, ArrayList<String>> Ip = lg.iPsForDays();
        System.out.println(lg.MostIpDay( Ip));
    }
    public void highestipprint(){
         LogAnalyzer lg = new LogAnalyzer();
        lg.readFile();
        HashMap<String, ArrayList<String>> Ip = lg.iPsForDays();
        System.out.println(lg.MosTIpsofDay(Ip, "Sep 30"));
    }
   
}
