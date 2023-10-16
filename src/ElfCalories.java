import java.util.ArrayList;

public class ElfCalories {
    public static void main(String[] args){

        String raw = AoCInputs.returnData();
        String[] elves = raw.split("\n\n");
        Integer maxCals = 0;

        ArrayList<Integer> sums = new ArrayList<Integer>();

        for (String elf : elves){
            int sum = 0;
            String[] meals = elf.split("\n");
            for (String meal: meals){
                int calories = Integer.parseInt(meal);
                sum = sum + calories;
            }
            ///System.out.println(sum);
            if (sum >= maxCals){
                maxCals = sum;
            }
            //Add sum to an array
            sums.add(sum);
        }
        System.out.println(maxCals);
        //System.out.println(sums);
        //Sort sums array, last 3 indexes are the top 3
        sums.sort(null);
        
        int total = sums.get(sums.size()-1) + sums.get(sums.size()-2) + sums.get(sums.size()-3);

        System.out.println(total);

    }
}