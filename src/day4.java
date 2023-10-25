import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class day4 {
   public static ArrayList<String[]> pairs = new ArrayList<>();
   public static void main(String[] args) {
      fileIntake("cleaning-zones.txt");
      printPairs();
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
}
