import java.util.ArrayList;
import java.util.HashMap;

public class Rucksack {
    public static ArrayList<Character> uniqueList = new ArrayList<Character>();

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
            findMatches(firstHalf, secondHalf);            
        }

        calculateTotal();
    }

    private static void printArray(char[] array){
        System.out.println("\r\n");
        for (char c : array) {
            System.out.print(c);
        }
        //System.out.println("\n");
    }

    private static void findMatches(char[] a, char[] b){
        ArrayList<Character> matches = new ArrayList<Character>();
        //System.out.println(matches);
        boolean[] charSet = new boolean[256]; // Assuming ASCII characters 
        // Mark characters from array a 
        for (char c : a) { 
            charSet[c] = true; 
        }
        // Check if any character from array b exists in array a 
        for (char c : b) { 
            if (charSet[c]) {
                matches.add(c);
            } 
        }
        uniqueList.add(matches.get(0));
        
    }

    private static int calculateValue(String key){      
        int value = valueMap().get(key);
        return value;
    }

    private static void calculateTotal(){
       //Turn uniqueList into String[]
        String[] sringArray= new String[uniqueList.size()];
        for (int i = 0; i < uniqueList.size(); i++) {
            sringArray[i] = String.valueOf(uniqueList.get(i));
        }
        //loop through stringArray and calculate the value of each character
        int total = 0;
        for(String s : sringArray){
            total = total + calculateValue(s);
        }
        System.out.println(total);
    }
    private static HashMap<String, Integer> valueMap(){
        //hashmap to store the priority of each character
        HashMap<String, Integer> priorities = new HashMap<String, Integer>();

        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        int value = 1;
        for (String c : alphabet) {          
            priorities.put(c, value);       
            value = value + 1;
            priorities.put(c.toUpperCase(), value + 25);  
        }

        return priorities;
    }
}
