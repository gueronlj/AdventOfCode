import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Rucksack {
    public static ArrayList<Character> uniqueList = new ArrayList<Character>();

    public static void main(String[] args) throws IOException{
        //SEPARATE THE DATA INTO ROWS   
        String data = AoCInputs.rucksack();
        String[] separated =  data.split("\r\n");
    
        //SPLIT EACH ROW IN HALF
        for (String singleRow : separated){    
            int length = singleRow.length();
            char[] firstHalf = new char[length/2];
            singleRow.getChars(0, (length/2), firstHalf, 0);

            char[] secondHalf = new char[length/2];
            singleRow.getChars((length/2), length, secondHalf, 0);
            findMatches(firstHalf, secondHalf);            
        }
        //calculateTotal();
        readFile();
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

    private static void readFile(){
        //read text file
        ArrayList<String[]> trios = new ArrayList<>();
        BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("data.txt"));
			String line;
            int lineCount = 0;
            ArrayList<String> trio = new ArrayList<String>();
            //while there are lines to read...
            while ((line = reader.readLine()) != null) {
                lineCount++;
                //Add the current line to the current group of 3
                trio.add(line);
                //If we've read 3 lines, add the group of 3 to the list of trios and clear the group of 3
                if (lineCount % 3 == 0) {
                    trios.add(trio.toArray(new String[0]));
                    trio.clear();
                } 
            }
            //If there are 1 or 2 lines left over, add them to the list of trios
            if (lineCount % 3 != 0){
                trios.add(trio.toArray(new String[0]));
            }
		} catch (IOException e) {
			e.printStackTrace();
		}
        //Print the trios
        for (String[] array : trios) { 
            for (String s : array) { 
                System.out.println(s); 
            }
            //Print blank line in between trios
            System.out.println(); 
        }
    }
}

