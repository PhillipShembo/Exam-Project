/*
I had no trouble completing this thanks to your help with the 
project. I triple checked it too, if I missed anything...

I need glasses.
*/
import java.util.*;
public class DemoShembo{
   public static void main(String [] args){
      Scanner input = new Scanner(System.in);
      
      //declarations
      String firstName = "", lastName = "", repeat = "Y";
      int desiredAmount = 0, creditScore = 0, lateCount = 0, totalRuns = 0;
      
      ArrayList<LoanApplicationShembo> report = new ArrayList<LoanApplicationShembo>();
      
      //data collection
      do{
         System.out.print("\nLoan Applicant's First Name: ");
         firstName = input.nextLine();
         System.out.print("Loan Applicant's Last Name: ");
         lastName = input.nextLine();
         System.out.print("Desired Loan Amount: ");
         desiredAmount = input.nextInt();
         while(desiredAmount < 0){//validation - why would a person want to give free money to the money givers?
            System.out.print("Desired loan amount can't be negative. Desired Loan Amount: ");
            desiredAmount = input.nextInt();
         }
         System.out.print("Credit Score: ");//looked online, no one has gone below 0, it is still possible. Validation not needed.
         creditScore = input.nextInt();
         System.out.print("Number of Late Payments: ");
         lateCount = input.nextInt();
         while(lateCount < 0){//validation - can't be late by negative days.
            System.out.print("Your late days can't be negative. Number of Late Payments: ");
            lateCount = input.nextInt();
         }
         input.nextLine();
         System.out.print("\nWould you like to enter information for another loan application (Y/N)?: ");
         repeat = input.nextLine();
         
         //calling the boys
         CreditReportShembo creditR = new CreditReportShembo(creditScore, lateCount);
         LoanApplicationShembo loanA = new LoanApplicationShembo(firstName, lastName, desiredAmount, creditR);
         totalRuns = loanA.getCount();
         report.add(loanA);
      
      }while(repeat.equalsIgnoreCase("Y"));
      
      //displaying the data
      System.out.println("\nLoan Application Report\n\n");
      for(int i = 0; i < report.size(); i++){
         System.out.println(report.get(i));
      }
      System.out.println("There is/are a total of " + totalRuns + " loan application(s) in this report.");
   }
}