import java.util.*;

public class RentalRates
{
   private static final boolean DEBUG = false; 
   
   private static final String BEST_RATE = "Best rate - $40.00 per day or $200.00 per week."; 
   private static final String RISK_RATE_1 = "Risk rate 1 - $50.00 per day or $255.00 per week."; 
   private static final String RISK_RATE_2 = "Risk rate 2 - $57.00 per dat or $285.00 per week."; 
   private static final String RISK_RATE_3 = "Risk rate 3 - $%4.2f per day or $%5.2f per week.";
   
   public static void main (String [] args)
   {
      int curMonth = 0; 
      int curDay = 0; 
      int curYear = 0; 
      int bMonth = 0; 
      int bDay = 0; 
      int bYear = 0; 
      String gender = ""; 
      int age = 0; 
      String rateResult;
      
      //Testing mode... 
      if (DEBUG == true)
      {
         //Establish a 'current' date for testing... 
         
         Calendar cal = Calendar.getInstance(); 
         int year = cal.get(Calendar.YEAR);
         int month = cal.get(Calendar.MONTH);      
         int day = cal.get(Calendar.DAY_OF_MONTH);
         
         System.out.println("First test case: Renter is not old enought to rent..."); 
         bMonth = 2; 
         bDay = 2; 
         bYear = 1991; 
         gender = "m"; 
         age = calcAge(curMonth, curDay, curYear, bMonth, bDay, bYear);
         rateResult = calcRateClass (age, gender); 
         displayResults(gender, age, rateResult);
         
         System.out.println("\nSecond test case: Renter is barely old enough (57/285)..."); 
         bMonth = 2; 
         bDay = 1; 
         bYear = 1991; 
         gender = "m"; 
         age = calcAge(curMonth, curDay, curYear, bMonth, bDay, bYear);
         rateResult = calcRateClass (age, gender); 
         displayResults(gender, age, rateResult);
         
         System.out.println("\nThird test case: Renter is 35 and male (40/200)..."); 
         bMonth = 1; 
         bDay = 1; 
         bYear = 1981; 
         gender = "m"; 
         age = calcAge(curMonth, curDay, curYear, bMonth, bDay, bYear);
         rateResult = calcRateClass (age, gender); 
         displayResults(gender, age, rateResult);
         
         System.out.println("\nForth test case: Renter is 35 and female (40/200)..."); 
         bMonth = 1; 
         bDay = 1; 
         bYear = 1985; 
         gender = "f"; 
         age = calcAge(curMonth, curDay, curYear, bMonth, bDay, bYear);
         rateResult = calcRateClass (age, gender); 
         displayResults(gender, age, rateResult);
         
         System.out.println("\nFifth test case: Renter is 30 and male (57/285)..."); 
         bMonth = 1; 
         bDay = 1; 
         bYear = 1986; 
         gender = "m"; 
         age = calcAge(curMonth, curDay, curYear, bMonth, bDay, bYear);
         rateResult = calcRateClass (age, gender); 
         displayResults(gender, age, rateResult);
         
         System.out.println("\nSixth test case: Renter is 30 and female (40/200)..."); 
         bMonth = 1; 
         bDay = 1; 
         bYear = 1986; 
         gender = "f"; 
         age = calcAge(curMonth, curDay, curYear, bMonth, bDay, bYear);
         rateResult = calcRateClass (age, gender); 
         displayResults(gender, age, rateResult);
         
         System.out.println("\nSeventh test case: Renter is 76 and male (62/255)..."); 
         bMonth = 1; 
         bDay = 1; 
         bYear = 1940; 
         gender = "m"; 
         age = calcAge(curMonth, curDay, curYear, bMonth, bDay, bYear);
         rateResult = calcRateClass (age, gender); 
         displayResults(gender, age, rateResult); 
         
         System.out.println("\nEighth test case: Renter is 76 and female (68/270)..."); 
         bMonth = 1; 
         bDay = 1; 
         bYear = 1940; 
         gender = "f"; 
         age = calcAge(curMonth, curDay, curYear, bMonth, bDay, bYear);
         rateResult = calcRateClass (age, gender); 
         displayResults(gender, age, rateResult);   
      }
      else
      {
         Scanner kb = new Scanner(System.in); 
         System.out.println("Welcome to Anna's car renter rate finder!");
         
         // Get today's date:
         Calendar cal = Calendar.getInstance(); 
         int year = cal.get(Calendar.YEAR);
         int month = cal.get(Calendar.MONTH);      
         int day = cal.get(Calendar.DAY_OF_MONTH);
         
         // Get gender: 
         System.out.println("Please enter renter's gender (m/f): ");
         gender = kb.nextLine();
         
         // Get birthday: 
         System.out.println("Please enter renter's birth year: ");
         bYear = kb.nextInt();
         
         System.out.println("Please enter renter's birth month: "); 
         bMonth = kb.nextInt(); 
         
         System.out.println("Please enter the renter's birth day: "); 
         bDay = kb.nextInt(); 
         
        age = calcAge(year, month, day, bMonth, bDay, bYear);
        rateResult = calcRateClass (age, gender); 
        displayResults(gender, age, rateResult);
               
      }
   }
   
   public static int calcAge(int month, int day, int year, int bMonth, int bDay, int bYear)
   {
        Calendar todayCalendar = Calendar.getInstance();

        Calendar bDayCalendar = Calendar.getInstance();
        bDayCalendar.set(Calendar.YEAR, bYear);
        bDayCalendar.set(Calendar.MONTH, bMonth);
        bDayCalendar.set(Calendar.DAY_OF_MONTH, bDay);
        
        int age = todayCalendar.get(Calendar.YEAR) - bDayCalendar.get(Calendar.YEAR);

        if (todayCalendar.get(Calendar.DAY_OF_YEAR) < bDayCalendar.get(Calendar.DAY_OF_YEAR)) {
            age--; 
        }
        
        return age;
        
   }
   
   public static String calcRateClass(int age,String gender)
   { 
      if (gender == "m")
      {
         if (33 <= age && age <= 65)
         {
            return BEST_RATE;
         }
         if (25 <= age && age <= 32) 
         {
            return RISK_RATE_2;
         } 
         else //if (age >= 66) 
         {
            return RISK_RATE_3;
         }       
      }
      else
      {
         if (30 <= age && age <= 62)
         { 
            return BEST_RATE; 
         }
         
         if (25 <= age && age <= 29) 
         {
            return RISK_RATE_1;
         }    
         else //if (age >= 62)
         {
            return RISK_RATE_3;
         } 
      }
   }
   
   public static void displayResults( String gender, int age, String rateResult) {
       
       if (gender == "f" || gender == "F")
            gender = "female";
        else
            gender = "male";
        
        if (age >= 25) {
            System.out.print("\nThank you.\n");
            System.out.print("The " + gender + " driver is " + age + " year old.\n");
            System.out.print("The rate class is: " + rateResult);  
        } else {
            System.out.print("Sorry, renter is not old enought to rent...");
        }
    }  
}
