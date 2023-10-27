import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class day4 {
   public static ArrayList<String[]> pairs = new ArrayList<>();
   public static ArrayList<Integer[]> intRanges = new ArrayList<>();
   public static int overlaps = 0;
   public static void main(String[] args) {
      fileIntake("cleaning-zones.txt");
      for (String[] pair : pairs) {
         extractRangesAsInt(pair);
      }     
      for(int i = 0; i < intRanges.size(); i+=2){
         checkAnyOverlap(intRanges.get(i), intRanges.get(i+1));
      }
      System.out.println(overlaps);
   }

   public static void fileIntake(String fileName) {
      try {
         BufferedReader reader = new BufferedReader(new FileReader(fileName));
         String line = reader.readLine();
         while (line != null) {
            //split the line into an array of strings
            String[] splitLine = line.split(",");
            pairs.add(splitLine);
            //go to next line (reasssign the next line as line to read)
            line = reader.readLine();
         }
         reader.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }  
   
   public static void printPairs() {
      for (String[] array : pairs) { 
         for (String s : array) { 
            System.out.println(s); 
         }
         //Print blank line in between pairs
         System.out.println(); 
      }
   }

   public static void extractRangesAsInt(String[] pair){
      //split into two strings 
      String[] firstString = pair[0].split("-");
      String[] secondString = pair[1].split("-");
      //convert to int
      Integer[] first = new Integer[2];
      Integer[] second = new Integer[2];
      for(int i = 0; i < firstString.length; i++){
         first[i] = Integer.parseInt(firstString[i]);
      }
      for(int i = 0; i < secondString.length; i++){
         second[i] = Integer.parseInt(secondString[i]);
      }     
      //add to intRanges
      intRanges.add(first);
      intRanges.add(second);
   }

   public static void checkAnyOverlap(Integer[] first, Integer[] second){
      Integer[] earliest = new Integer[2];
      Integer[] latest = new Integer[2];
      if(first[0]>second[0]){
         earliest[0] = second[0];
         earliest[1] = second[1];
         latest[0] = first[0];
         latest[1] = first[1];
      }else{
         earliest[0] = first[0];
         earliest[1] = first[1];
         latest[0] = second[0];
         latest[1] = second[1];
      }

      if( latest[0] <= earliest[1]){
        for(int i : latest){
         System.out.println(i);
        }
        for(int i : earliest){
         System.out.println(i);
        }
         System.out.println(" Overlap");
         overlaps++;
      }
   }

   public static void checkForOverlap(Integer[] first, Integer[] second){
      //find short ranger
      Integer[] shortRange = new Integer[2];
      Integer[] longRange = new Integer[2];
      if((first[1] - first[0])<(second[1] - second[0])){
         shortRange = first;
         longRange = second;
      } else {
         shortRange = second;
         longRange = first;
      }
      if(shortRange[0] >= longRange[0] && shortRange[1] <= longRange[1]){
         System.out.println("Overlap");
         overlaps++;
      } else {
         //print shortRange and longRange
         for(int i = 0; i < shortRange.length; i++){
            System.out.print(shortRange[i] + " ");
         }
         for(int i = 0; i < longRange.length; i++){
            System.out.print(longRange[i] + " ");
         }
         System.out.println("No overlap");
      }
   }  
}
