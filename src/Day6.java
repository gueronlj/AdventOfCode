import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day6 {
   public static char[] allCharacters = new char[4095];
   public static char[] charsToCheck = new char[4];
   public static void main(String[] args){
      System.out.println();
      //Read day6.txts

      BufferedReader bReader = null;
      try{
         int c;
         int count = 0;
         bReader = new BufferedReader(new FileReader("day6.txt"));
         //read 4 characters at a time, store them in charsToCheck
         while((c = bReader.read(allCharacters)) != -1){
            //find the first occurance of 4 unique characters in a row
            for(int i = 0; i < 4; i++){
               charsToCheck[i] = allCharacters[i];
            }
            for(int i = 4; i < 4095; i++){
               //check if all 4 characters are unique
               boolean unique = true;
               for(int j = 0; j < 4; j++){
                  for(int k = j+1; k < 4; k++){
                     if(charsToCheck[j] == charsToCheck[k]){
                        unique = false;
                     }
                  }
               }
               if(unique){
                  System.out.println(charsToCheck);
                  System.out.println(count);
                  break;
               }
               //shift characters
               for(int j = 0; j < 3; j++){
                  charsToCheck[j] = charsToCheck[j+1];
               }
               charsToCheck[3] = allCharacters[i];
               count++;
            }
         }
      }catch(IOException e){
         e.printStackTrace();
      }
      // How many characters need to be processed before the first start-of-packet marker is detected?
   }
}
