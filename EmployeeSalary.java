import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmployeeSalary {
    public static void main(String[] args) {
      
         double DA_Percentage = 0.02;
         double TA_Percentage = 0.01;
         double HRA_Percentage = 0.03;
         double PF_Percentage  = 0.005;
         double TAX_Deduction = 1000.0;
         int RETIREMENT_Age = 55;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the basic payment (between 4500 and 6500): ");
        double basicPayment = scanner.nextDouble();
  

        
        if (basicPayment < 4500 || basicPayment > 6500) {
            System.out.println("Invalid basic payment amount. Please enter a value between 4500 and 6500.");
            return;
        }

        
        double DA = basicPayment * DA_Percentage ;
        double TA = basicPayment * TA_Percentage ;
        double HRA = basicPayment * HRA_Percentage ;

    
        double totalSalary = basicPayment + DA + TA + HRA;

     
        if (totalSalary > 10000) {
            double pfDeduction = totalSalary * PF_Percentage ;
            totalSalary -= pfDeduction;
        }

     
        totalSalary -= TAX_Deduction;

        LocalDate currentDate = LocalDate.now();
        LocalDate retirementDate = currentDate.plusYears(RETIREMENT_Age);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Basic Payment: rs " + basicPayment);
        System.out.println("DA (2%): rs " + DA);
        System.out.println("TA (1%): rs " + TA);
        System.out.println("HRA (3%): rs " + HRA);
        System.out.println("Total Salary: rs " + totalSalary);
        System.out.println("Retirement Date: " + retirementDate.format(formatter));
    }
}
