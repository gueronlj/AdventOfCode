import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class day5 {

   private static ArrayList<String> directionsRaw = new ArrayList<>();
   private static Stack<String> stack1 = new Stack<>();
   private static Stack<String> stack2 = new Stack<>();
   private static Stack<String> stack3 = new Stack<>();
   private static Stack<String> stack4 = new Stack<>();
   private static Stack<String> stack5 = new Stack<>();
   private static Stack<String> stack6 = new Stack<>();
   private static Stack<String> stack7 = new Stack<>();
   private static Stack<String> stack8 = new Stack<>();
   private static Stack<String> stack9 = new Stack<>();
   private static Stack<String> result1 = new Stack<>();
   private static Stack<String> result2 = new Stack<>();
   private static Stack<String> result3 = new Stack<>();
   private static Stack<String> result4 = new Stack<>();
   private static Stack<String> result5 = new Stack<>();
   private static Stack<String> result6 = new Stack<>();
   private static Stack<String> result7 = new Stack<>();
   private static Stack<String> result8 = new Stack<>();
   private static Stack<String> result9 = new Stack<>();
   public static void main(String[] args){   
     readFile("day5.txt");
     buildStacks();
     printStacks();
     extractNumberFromDirections(directionsRaw);
     processDirections(1, 1, 2);
     printStacks();   
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
         int num = 0;
         String[] stringArray = line.split("");
         for (String string : stringArray) {
            //if the string is a number
            if(string.matches("[0-9]")){
               //extract number from line
               String number = line.replaceAll("[^0-9]", "");
               //convert to int
               num = Integer.parseInt(number);
            }
         }
         System.out.println(num);
      }
   }

   private static void processDirections(Integer numberOfCrates, Integer startingNumber, Integer endingNumber){
      Stack<String>startingStack = null;
      Stack<String>endingStack = null;
      switch (startingNumber) {
            case 1:
               startingStack = stack1;
               break;
            case 2:
               startingStack = stack2;
               break;
            case 3:
               startingStack = stack3;
               break;
            case 4:
               startingStack = stack4;
               break;
            case 5:
               startingStack = stack5;
               break;
            case 6:
               startingStack = stack6;
               break;
            case 7:
               startingStack = stack7;
               break;
            case 8:
               startingStack = stack8;
               break;
            case 9:
               startingStack = stack9;
               break;
            default:
               break;
         }
      switch (endingNumber) {
            case 1:
               endingStack = stack1;
               break;
            case 2:
               endingStack = stack2;
               break;
            case 3:
               endingStack = stack3;
               break;
            case 4:
               endingStack = stack4;
               break;
            case 5:
               endingStack = stack5;
               break;
            case 6:
               endingStack = stack6;
               break;
            case 7:
               endingStack = stack7;
               break;
            case 8:
               endingStack = stack8;
               break;
            case 9:
               endingStack = stack9;
               break;
            default:
               break;
      }

      for ( int i = 1; i < numberOfCrates; i++){ 
         String crate = startingStack.pop();
         endingStack.push(crate);  
      }  
      
   }
}
