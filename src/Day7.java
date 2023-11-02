import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Day7 {

   public static ArrayList<String> directories = new ArrayList<String>();
   public static ArrayList<Integer> fileSizes = new ArrayList<Integer>();
   public static int lineCount = 0;
   public static Map<Integer, String> lineMap = new HashMap<Integer, String>();

   public static void main(String[] args){

      readFile("day7.txt");
      printDirectories();
      printFileSizes();
      printLineMap(lineMap);
   }

   public static void readFile(String fileName){
      BufferedReader reader = null;
      try{
         reader = new BufferedReader(new FileReader(fileName));
         String line;
         while((line = reader.readLine()) != null){
            lineCount++;
            // Identify files: If line begins with a number, it is a file
            if(line.charAt(0) >= '0' && line.charAt(0) <= '9'){
               //parse the number for an integer
               int filesize = Integer.parseInt(line.substring(0, line.indexOf(" ")));
               fileSizes.add(filesize);
               createMapping("file");
            }

            // Identify directories: If line begins with "$ cd" and not "$ cd ..", it is a directory
            if(line.length() >= 4 && line.substring(0, 4).equals("$ cd") && !line.equals("$ cd ..")){ 
               //add to list of directories
               directories.add(line.substring(4));
               createMapping("dir");
            }
         }
      }catch(IOException e){
         e.printStackTrace();
      }

   }

   private static void printDirectories(){
      for(String directory : directories){
         System.out.println(directory);  
      }
   }

   private static void printFileSizes(){
      for(int filesize : fileSizes){
         System.out.println(filesize);
      }
   }

   private static void createMapping(String value){
      lineMap.put(lineCount, value);
   }

   private static void printLineMap(Map<Integer, String> lineMap){
      for(Map.Entry<Integer, String> entry : lineMap.entrySet()){
         System.out.println(entry.getKey() + " " + entry.getValue());
      }
   }
}
