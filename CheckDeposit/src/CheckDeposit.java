import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * 
 * @author Philip Burggraf
 * This program will request an initial account balance and check information from the user.
 * The program will use this information to compute the final account balance. 
 */

public class CheckDeposit {
  public static void main (String[] args) {
	//Declaring variables (including DecimalFormat).
    double accountBalance;
    double checkAmount;
	Scanner input = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("0.00");
	
	//Getting the initial account balance and check amount from the user.
	System.out.println("Please enter the account balance: $");
	accountBalance = input.nextDouble();
	System.out.println("Please enter a check amount (-1 to end): $");
	checkAmount = input.nextDouble();
	
	//Entering the while loop. If statement will be used to test accountBalance.
	while(checkAmount >= 0) {
	  if(accountBalance - checkAmount >= 0) {
	    accountBalance = accountBalance - checkAmount;
	    System.out.println("Remaining balance: $" + df.format(accountBalance));
	  }
	  else {
	    System.out.println("Warning: Check will bounce. No transaction occured.");
	  }
	  System.out.println("Please enter a check amount (-1 to end): $");
	  checkAmount = input.nextDouble();
	}
	//Printing final account balance. 
	System.out.println("Final balance: $" + df.format(accountBalance));
  }
}
