public class CreditReportShembo{
   
   //Private Declarations
   private int creditScore = 0;
   private int lateCount = 0;
   
   /**
   Argument Constructor
      @param creditScore the user's credit score
      @param lastCount the user's amount of late days
   */
   public CreditReportShembo(int setCreditScore, int setLateCount){
      creditScore = setCreditScore;
      lateCount = setLateCount;
   }
   
   /**
   No Argument Constructor
   */
   public CreditReportShembo(){
      creditScore = 686;//average for NC
      lateCount = 0;
   }
   
   /**
   Copy Constructor
   */
   public CreditReportShembo(CreditReportShembo object2){
      creditScore = object2.creditScore;
      lateCount = object2.lateCount;
   }
   
   //Setters (Don't add items that should just do math)
   /**
      @param creditScore the user's credit score
   */
   public void settingCreditScore(int setCreditScore){
      creditScore = setCreditScore;
   }
   /**
      @param lastCount the user's amount of late days
   */
   public void settingLateCount(int setLateCount){
      lateCount = setLateCount;
   }
   
   //Getters 
   /**
      @return the credit score
   */
   public int getCreditScore(){
      return creditScore;
   }
   /**
      @return the late day amount
   */
   public int getLateCount(){
      return lateCount;
   }
   
   //toString
   /**
      @return the String for the Credit Report class
   */
   public String toString(){
      return String.format("\nCredit Report:\n" +
                           "\n\tCredit Score: " + creditScore +
                           "\n\tNumber of Late Payments: " + lateCount);
   }
}