import java.util.Date;
import java.util.Calendar; 
import java.util.ArrayList; 
import java.text.*; 

public class bookLoanEntry{

	Format f = new SimpleDateFormat("MM/dd/yy");
	Calendar checkoutCal, dueCal; 
	Date due, checkout; 
	public int userCardNumber; 
	public String bookTitle; 

	bookLoanEntry(int userCardNumber, String bookTitle){

      	checkoutCal = Calendar.getInstance();
      	dueCal = Calendar.getInstance();
      	dueCal.add(Calendar.DAY_OF_MONTH, 7);
      	checkout = checkoutCal.getTime();
      	due = dueCal.getTime();
      	this.bookTitle = bookTitle; 
      	this.userCardNumber = userCardNumber; 

	}
	

	public String checkoutDateToString(){
		return(f.format(checkout));
	}

	public String dueDateToString(){
		return(f.format(due));
	}

	public static void main(String args[]){
		//bookLoanEntry ble = new bookLoanEntry(3243254, "A book loan entrty-x");
	}
		
}
