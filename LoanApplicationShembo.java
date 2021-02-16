/*
This class "has a" credit report to go with it!
*/
public class LoanApplicationShembo{
   
   //Private Declarations
   private String firstName;
   private String lastName;
   private double desiredAmount = 0.0;
   private static int dejaVu = 0;//counting repeats
   private CreditReportShembo creditReport;//calling the CreditReport class
   
   /**
   Argument Constructor
      @param firstName the user's first name
      @param lastName the user's last name
      @param desiredAmount the user's requested amount
      @param creditReport the user's credit report
      @param dejaVu counting the repeats
   */
   public LoanApplicationShembo(String setfirstName, String setlastName, double setdesiredAmount, CreditReportShembo report){
      firstName = setfirstName;
      lastName = setlastName;
      desiredAmount = setdesiredAmount;
      creditReport = report;
      dejaVu++;
   }
   
   /**
   No Argument Constructor
   */
   public LoanApplicationShembo(){
      firstName = "Phillip";
      lastName = "Shembo";
      desiredAmount = 0;
      //I assumed that the creditReport is just left out of this.
      dejaVu++;
   }
   
   
   //Setters
   /**
      @param firstName the user's first name
   */
   public void settingfirstName(String setfirstName){
      firstName = setfirstName;
   }
   /**
      @param  lastName the user's last name
   */
   public void settinglastName(String setlastName){
      lastName = setlastName;
   }
   /**
      @param desiredAmount the user's requested amount
   */
   public void settingdesiredAmount(double setdesiredAmount){
      desiredAmount = setdesiredAmount;
   }
   /**
      @param creditReport the user's credit report
   */
   public void settingCreditReport(CreditReportShembo report){
      creditReport = new CreditReportShembo(report);
   }
   
   
   //Getters
   /**
      @return the first name of the user
   */
   public String getfirstName(){
      return firstName;
   }
   /**
      @return the last name of the user
   */
   public String getlastName(){
      return lastName;
   }
   /**
      @return the desired amount
   */
   public double getdesiredAmount(){
      return desiredAmount;
   }
   /**
      @return the credit report
   */
   public CreditReportShembo getCreditReport(){
      return new CreditReportShembo(creditReport);
   }
   /**
      @return the approval staus
   */
   public String approvalStatus(){
      String status = "approved!";
      if(creditReport.getLateCount() >= 3){
         status = "declined.";
      }
      
      if(creditReport.getLateCount() < 3){
         if(desiredAmount <= 20000 && creditReport.getCreditScore() < 600){
            status = "approved!";
         }
         if(desiredAmount > 20000 && creditReport.getCreditScore() < 600){
            status = "declined.";
         }
         if(desiredAmount <= 20000 && creditReport.getCreditScore() >= 600 || creditReport.getCreditScore() <= 700 ){
            status = "approved!";
         }
         if(desiredAmount > 20000 && creditReport.getCreditScore() >= 600 || creditReport.getCreditScore() <= 700 ){
            status = "declined.";
         }
         if(desiredAmount > 20000 && creditReport.getCreditScore() < 600){
            status = "declined.";
         }
         if(desiredAmount <= 20000 && creditReport.getCreditScore() > 700){
            status = "approved!";
         }
         if(desiredAmount > 20000 && creditReport.getCreditScore() > 700){
            status = "approved!";
         }
      }
      return status;
   }
   /**
      @return the count
   */
   public int getCount(){
      return dejaVu;
   }
   
   
   //toString
   /**
      @return a to String for the Loan Application class.
   */
   public String toString(){
      return String.format("\nApplicant Information:\n" +
                           "\n\tLoan Applicant's First Name: " + firstName + 
                           "\n\tLoan Applicant's Last Name: " + lastName + 
                           "\n\tDesired Loan Amount: $%,.0f" +
                           "\n" + creditReport.toString() +//calling the CreditReport Clas
                           "\n\nThis loan is " + approvalStatus() + "\n", desiredAmount);
   }
}