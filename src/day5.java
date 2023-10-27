import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class day5 {

   private static ArrayList<String> directionsRaw = new ArrayList<>();
   private static ArrayList<Integer[]> directionsRefined = new ArrayList<>();
   private static Stack<String> stack1 = new Stack<>();
   private static Stack<String> stack2 = new Stack<>();
   private static Stack<String> stack3 = new Stack<>();
   private static Stack<String> stack4 = new Stack<>();
   private static Stack<String> stack5 = new Stack<>();
   private static Stack<String> stack6 = new Stack<>();
   private static Stack<String> stack7 = new Stack<>();
   private static Stack<String> stack8 = new Stack<>();
   private static Stack<String> stack9 = new Stack<>();

   public static void main(String[] args){   
      readFile("day5.txt");
      buildStacks();
      extractNumberFromDirections(directionsRaw);
      //print directionsRefined
      for(Integer[] line : directionsRefined){
         for(Integer i : line){
            System.out.print(i + " ");
         }
         System.out.println();
      }
      for (Integer[] line : directionsRefined) {
         processDirections(line[0], line[1], line[2]);
      } 
      printStacks();
      printTopCrates(); 
   }

   private static void readFile(String filename){
      //read file day5.txt
      try{
         BufferedReader reader = new BufferedReader(new FileReader(filename));
         String line =  reader.readLine();
         //read until there are no more lines
         while ( line != null ) {            
            directionsRaw.add(line);
            //go to next line
            line = reader.readLine();
         }
         reader.close();
      }catch(IOException e){
         System.out.println(e);
         e.printStackTrace();
      }
   }

   private static void buildStacks(){
      String[] stack1Input ={"W","D","G","B","H","R","V"};
      String[] stack2Input ={"J","N","G","C","R","F"};
      String[] stack3Input ={"L","S","F","H","D","N","J"};
      String[] stack4Input ={"J","D","S","V"};
      String[] stack5Input ={"S","H","D","R","Q","W","N","V"};
      String[] stack6Input ={"P","G","H","C","M"};
      String[] stack7Input ={"F","J","B","G","L","Z","H","C"};
      String[] stack8Input ={"S","J","R"};
      String[] stack9Input ={"L","G","S","R","B","N","V","M"};


      for(String s : stack1Input){
         stack1.push(s);
      }
      for(String s : stack2Input){
         stack2.push(s);
      }
      for(String s : stack3Input){
         stack3.push(s);
      }
      for(String s : stack4Input){
         stack4.push(s);
      }
      for(String s : stack5Input){
         stack5.push(s);
      }
      for(String s : stack6Input){
         stack6.push(s);
      }
      for(String s : stack7Input){
         stack7.push(s);
      }
      for(String s : stack8Input){
         stack8.push(s);
      }
      for(String s : stack9Input){
         stack9.push(s);
      }
   }

   private static void printStacks() {
      System.out.println(stack1);
      System.out.println(stack2);
      System.out.println(stack3);
      System.out.println(stack4);
      System.out.println(stack5);
      System.out.println(stack6);
      System.out.println(stack7);
      System.out.println(stack8);
      System.out.println(stack9);
   }

   private static void extractNumberFromDirections(ArrayList<String> directions){
      for(String line : directions){
         //split each line into a string array
         Integer[] numArray = new Integer[3];
         String[] stringArray = line.split("");
         String number = line.replaceAll("[^0-9]", "");
         for (String character : stringArray) {
            //if the string is a number
            if(character.matches("[0-9]")){
               //break number into array[3]
               String[] trio = number.split("");
               Integer lastIndex = trio.length - 1;
               if(trio.length > 3){
                  //concatonate index 0 and index 1
                  String firstTwo = trio[0] + trio[1];
                  //turn into Integer
                  Integer firstTwoInt = Integer.parseInt(firstTwo);
                  numArray[0] = firstTwoInt;
                  numArray[1] = Integer.parseInt(trio[lastIndex-1]);
                  numArray[2] = Integer.parseInt(trio[lastIndex]);
               } else {
                  //convert to integers
                  for(int i = 0; i < trio.length; i++){
                     numArray[i] = Integer.parseInt(trio[i]);
                  }
               }
            }
         }
         directionsRefined.add(numArray);
      }
   }

   private static void processDirections(Integer numberOfCrates, Integer startingStack, Integer endingStack){
      switch (startingStack) {
         case 1:
            for ( int i = 1; i <= numberOfCrates; i++){ 
               String crate = stack1.pop();
               switch (endingStack){
                  case 1:
                     stack1.push(crate);
                     break;
                  case 2:
                     stack2.push(crate);
                     break;
                  case 3:
                     stack3.push(crate);
                     break;
                  case 4:
                     stack4.push(crate);
                     break;
                  case 5:
                     stack5.push(crate);
                     break;
                  case 6:
                     stack6.push(crate);
                     break;
                  case 7:
                     stack7.push(crate);
                     break;
                  case 8:
                     stack8.push(crate);
                     break;
                  case 9:
                     stack9.push(crate);
                     break;
               }
            }  
            break;
         case 2:
            for ( int i = 1; i <= numberOfCrates; i++){ 
               String crate = stack2.pop();
               switch (endingStack){
                  case 1:
                     stack1.push(crate);
                     break;
                  case 2:
                     stack2.push(crate);
                     break;
                  case 3:
                     stack3.push(crate);
                     break;
                  case 4:
                     stack4.push(crate);
                     break;
                  case 5:
                     stack5.push(crate);
                     break;
                  case 6:
                     stack6.push(crate);
                     break;
                  case 7:
                     stack7.push(crate);
                     break;
                  case 8:
                     stack8.push(crate);
                     break;
                  case 9:
                     stack9.push(crate);
                     break;
               }
            }  
            break;
         case 3:
            for ( int i = 1; i <= numberOfCrates; i++){ 
               String crate = stack3.pop();
               switch (endingStack){
                  case 1:
                     stack1.push(crate);
                     break;
                  case 2:
                     stack2.push(crate);
                     break;
                  case 3:
                     stack3.push(crate);
                     break;
                  case 4:
                     stack4.push(crate);
                     break;
                  case 5:
                     stack5.push(crate);
                     break;
                  case 6:
                     stack6.push(crate);
                     break;
                  case 7:
                     stack7.push(crate);
                     break;
                  case 8:
                     stack8.push(crate);
                     break;
                  case 9:
                     stack9.push(crate);
                     break;
               }
            }  
            break;
         case 4:
            for ( int i = 1; i <= numberOfCrates; i++){ 
               String crate = stack4.pop();
               switch (endingStack){
                  case 1:
                     stack1.push(crate);
                     break;
                  case 2:
                     stack2.push(crate);
                     break;
                  case 3:
                     stack3.push(crate);
                     break;
                  case 4:
                     stack4.push(crate);
                     break;
                  case 5:
                     stack5.push(crate);
                     break;
                  case 6:
                     stack6.push(crate);
                     break;
                  case 7:
                     stack7.push(crate);
                     break;
                  case 8:
                     stack8.push(crate);
                     break;
                  case 9:
                     stack9.push(crate);
                     break;
               }
            }  
            break;
         case 5:
            for ( int i = 1; i <= numberOfCrates; i++){ 
               String crate = stack5.pop();
               switch (endingStack){
                  case 1:
                     stack1.push(crate);
                     break;
                  case 2:
                     stack2.push(crate);
                     break;
                  case 3:
                     stack3.push(crate);
                     break;
                  case 4:
                     stack4.push(crate);
                     break;
                  case 5:
                     stack5.push(crate);
                     break;
                  case 6:
                     stack6.push(crate);
                     break;
                  case 7:
                     stack7.push(crate);
                     break;
                  case 8:
                     stack8.push(crate);
                     break;
                  case 9:
                     stack9.push(crate);
                     break;
               }
            }  
            break;
         case 6:
            for ( int i = 1; i <= numberOfCrates; i++){ 
               String crate = stack6.pop();
               switch (endingStack){
                  case 1:
                     stack1.push(crate);
                     break;
                  case 2:
                     stack2.push(crate);
                     break;
                  case 3:
                     stack3.push(crate);
                     break;
                  case 4:
                     stack4.push(crate);
                     break;
                  case 5:
                     stack5.push(crate);
                     break;
                  case 6:
                     stack6.push(crate);
                     break;
                  case 7:
                     stack7.push(crate);
                     break;
                  case 8:
                     stack8.push(crate);
                     break;
                  case 9:
                     stack9.push(crate);
                     break;
               }
            }  
            break;
         case 7:
            for ( int i = 1; i <= numberOfCrates; i++){ 
               String crate = stack7.pop();
               switch (endingStack){
                  case 1:
                     stack1.push(crate);
                     break;
                  case 2:
                     stack2.push(crate);
                     break;
                  case 3:
                     stack3.push(crate);
                     break;
                  case 4:
                     stack4.push(crate);
                     break;
                  case 5:
                     stack5.push(crate);
                     break;
                  case 6:
                     stack6.push(crate);
                     break;
                  case 7:
                     stack7.push(crate);
                     break;
                  case 8:
                     stack8.push(crate);
                     break;
                  case 9:
                     stack9.push(crate);
                     break;
               }
            }  
            break;
         case 8:
            for ( int i = 1; i <= numberOfCrates; i++){ 
               String crate = stack8.pop();
               switch (endingStack){
                  case 1:
                     stack1.push(crate);
                     break;
                  case 2:
                     stack2.push(crate);
                     break;
                  case 3:
                     stack3.push(crate);
                     break;
                  case 4:
                     stack4.push(crate);
                     break;
                  case 5:
                     stack5.push(crate);
                     break;
                  case 6:
                     stack6.push(crate);
                     break;
                  case 7:
                     stack7.push(crate);
                     break;
                  case 8:
                     stack8.push(crate);
                     break;
                  case 9:
                     stack9.push(crate);
                     break;
               }
            }  
            break;
         case 9:
            for ( int i = 1; i <= numberOfCrates; i++){ 
               String crate = stack9.pop();
               switch (endingStack){
                  case 1:
                     stack1.push(crate);
                     break;
                  case 2:
                     stack2.push(crate);
                     break;
                  case 3:
                     stack3.push(crate);
                     break;
                  case 4:
                     stack4.push(crate);
                     break;
                  case 5:
                     stack5.push(crate);
                     break;
                  case 6:
                     stack6.push(crate);
                     break;
                  case 7:
                     stack7.push(crate);
                     break;
                  case 8:
                     stack8.push(crate);
                     break;
                  case 9:
                     stack9.push(crate);
                     break;
               }
            }  
            break;      
      }
   }

   private static void printTopCrates(){
      System.out.println(stack1.peek() + stack2.peek() + stack3.peek() + stack4.peek() + stack5.peek() + stack6.peek() + stack7.peek() + stack8.peek() + stack9.peek());
   }
}
