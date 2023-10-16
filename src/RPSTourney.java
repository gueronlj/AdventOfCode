import java.util.ArrayList;

public class RPSTourney {
   
   public static void main(String[] args){
      String data = AoCInputs.strategyGuide();
      String[] rounds = data.split("\n\n");
      ArrayList<String> moveList = new ArrayList<>();
      int sum = 0;

      for (String round : rounds) {
         String[] answers = round.split("\n");
         for (String chars : answers){
            moveList.add(chars);
         }
      }

      //get first and last character in every element of moveList
      for(String ele : moveList){
         String opponentMove = ele.split("")[0];
         String response = ele.split("")[2];
         int moveValue = checkMoveValue(response);
         int resultValue = checkResult(opponentMove, response);
         int roundTotal = moveValue + resultValue;
         sum = sum + roundTotal;
         System.out.println(opponentMove + "/" + response);
         System.out.println(roundTotal);
      }

      System.out.println(sum);
   }

   private static Integer checkResult(String firstMove, String response ) {
      int score = 0;
   
      if(firstMove.equals("A") && response.equals("X")){
         score = 3;
      }

      if(firstMove.equals("A") && response.equals("Y")){
         score = 6;
      }
      
      if(firstMove.equals("A") && response.equals("Z")){
         score = 0;
      }

      if(firstMove.equals("B") && response.equals("Y")){
         score = 3;
      }
      if(firstMove.equals("B") && response.equals("Z")){
         score = 6;
      } 
      if(firstMove.equals("B") && response.equals("X")){ 
        score = 0;
      }

      if(firstMove.equals("C") && response.equals("Z")){
         score = 3;
      }
      if(firstMove.equals("C") && response.equals("X")){
         score = 6;
      }
      if(firstMove.equals("C") && response.equals("Y")){
         score = 0;
      }
      return score;
   }

   private static Integer checkMoveValue(String move){
      if(move.equals("X")){
         return 1;
      } else if(move.equals("Y")){
         return 2;
      } else {
         return 3;
      }
   }
}
