public class Rucksack {
    public static void main(String[] args){
        String data = AoCInputs.rucksack();

        String[] separated =  data.split("\r\n");

        for (String singleRow : separated){
            
            char[] firstHalf = new char[singleRow.length()/2];
            char[] secondHalf = new char[singleRow.length()/2];
            singleRow.getChars(0, (singleRow.length()/2), firstHalf, 0);
            singleRow.getChars((singleRow.length()/2), singleRow.length(), secondHalf, 0);
            
            //THIS WORKS
            System.out.println("\n\n");
            for (char c : firstHalf) {
                System.out.print(c);
            }

            System.out.println("\n");
            for (char c : secondHalf) {
                System.out.print(c);
            }
        }

    }
}
