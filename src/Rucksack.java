import java.util.ArrayList;
import java.util.HashMap;

public class Rucksack {
    public static void main(String[] args){
        //SEPARATE THE DATA INTO ROWS   
        String data = AoCInputs.rucksack();
        String[] separated =  data.split("\r\n");
        for (String singleRow : separated){    
            //SPLIT THE ROW IN HALF
            int length = singleRow.length();
            char[] firstHalf = new char[length/2];
            singleRow.getChars(0, (length/2), firstHalf, 0);
            char[] secondHalf = new char[length/2];
            singleRow.getChars((length/2), length, secondHalf, 0);
            //printArray(firstHalf);   
            //printArray(secondHalf);
            findMatches(firstHalf, secondHalf);
        }
    }

    private static void printArray(char[] array){
        System.out.println("\n\n");
        for (char c : array) {
            System.out.print(c);
        }
        System.out.println("\n");
    }

    private static void findMatches(char[] firstHalf, char[] secondHalf){
        ArrayList<Character> matches = new ArrayList<Character>();

        for (char c : firstHalf){
            for (char d : secondHalf){
                if (c == d){
                    matches.add(c);
                    //System.out.println(c);
                }
            }
        }
    }

    private static void calculatePriority(char[] matches){
        //hashmap to store the priority of each character
        HashMap<Character, Integer> priorities = new HashMap<Character, Integer>();
    
        for (Character key : priorities.keySet()) {
            int value = 0;
            // do something with the key
          }
    }
}
