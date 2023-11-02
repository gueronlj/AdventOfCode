import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day6 {
   public static char[] allCharacters = new char[4095];
   public static char[] charsToCheck = new char[14];
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
            //check 4 at a time
            for(int i = 0; i < 14; i++){
               charsToCheck[i] = allCharacters[i];
            }
            for(int i = 14; i < 4095; i++){
               //check if all 4 characters are unique
               boolean unique = true;

               //compare each value of the array 
               for(int j = 0; j < 14; j++){
                  //against every other value in the array
                  for(int k = j+1; k < 14; k++){
                     if(charsToCheck[j] == charsToCheck[k]){
                        //if any two are the same, unique is false
                        unique = false;
                     }
                     //ELSE unique is still true
                  }
               }
               if(unique){
                  //Print the 4 unique characters
                  System.out.println(charsToCheck);
                  
                  //Print the number of characters processed

                  /*NOTE! This count oes not include the 4 unique characters. Depending on the phrasing of the question, the answer could be count or count + 4 */
                  System.out.println(count + 14);
                  break;
               }

               //Did not find any unique, shift the scope and check the next characters. Check 3 new ones along with the last one from the previous set
               for(int j = 0; j < 13; j++){
                  charsToCheck[j] = charsToCheck[j+1];
               }
               //makes sure the last character checked is still in the new array to be checked
               charsToCheck[13] = allCharacters[i];

               //increment the count (this is happening after every time a character is processed)
               count++;
            }
         }
      }catch(IOException e){
         e.printStackTrace();
      }

      // Q: How many characters need to be processed before the first start-of-packet marker is detected?
   }
}
