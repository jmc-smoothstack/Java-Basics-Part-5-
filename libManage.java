import java.util.Scanner; 
import java.util.ArrayList; 
import java.util.*;
import java.util.Calendar; 
import java.io.*;

public class library{
	String name, address;
	//books[][] is the catalog of books in the libraries system.
	String[][] books = {{"Lost Tribe by Sidney Sheldon", "1"}, {"The Haunting by Stepehen King", "2"}, {"Microtrends by Mark Penn", "3"}};
	//Vector of bookLoanEntry objects to track a library's loans 
	Vector <bookLoanEntry> bookLoans = new Vector<bookLoanEntry>();
	//Contructors 
	library(){}
	library(String name, String address){
		this.name = name; 
		this.address = address; 
	}
	//createLoan() creates a new loan entry and adds it to Vector of loans 
	public void createLoan(int userCardNumber, String bookTitle){

		bookLoanEntry loan = new bookLoanEntry(userCardNumber, bookTitle);
		bookLoans.add(loan);
		//bookOut() subtracts 1 book from avaliable books
		bookOut(bookTitle);
		System.out.println("Loan successfully created");

	}
	//removes loan entry from Vector and adds copy back to inventory 
	public void returnBook(int cardNumber, String bt){
		int position = 0; //tracks poistion in Vector 
		for(bookLoanEntry loan : bookLoans)
		{
			if(loan.userCardNumber == cardNumber)
			{
				if(loan.bookTitle == bt)
				{
					break; 
				}
			}
			position +=1;
		}
		//removes bookLoanEntry() by position in Vector()
		bookLoans.remove(position);

		//adds copy back to inventory / raises availble copies for the specific book by 1 
		for(String[] book : books){
			if(book[0]==bt){
				book[1] = Integer.toString(Integer.parseInt(book[1])+1);
			}
		}
		System.out.println("remove succesful");
	}

	//addBooks() adds copies of a book in books[][] 
	public void addBooks(String bookTitle, int booksToAdd){
		for(String[] book : books)
		{
			if(book[0]==bookTitle){ 
				book[1] = Integer.toString(Integer.parseInt(book[1])+booksToAdd);
				System.out.println("copies successfully updated - copies: " + book[1]);
			}
		}
	}
	//get method to return Vector of book loans 
	public Vector<bookLoanEntry> getBookLoans(){
		return bookLoans;
	}

	//bookOut is used to subtract 1 from avalible books in the ibraries inventory  
	public void bookOut(String bookTitle){
		for(int i=0; i<books.length;i++){
			//subtract book from inventory 
			if(bookTitle == books[i][0]){
				int current = Integer.parseInt(books[i][1])-1;
				books[i][1] = Integer.toString(current);
			}
		}
	}
	//print method to show all books (titles and copies) in book catalog 
	public int showBooks(){
		int c = 0; 
		for(int i=0; i<books.length; i++){
			System.out.println(i+1+") "+books[i][0] + "  copies: " + books[i][1]);
			c = i; 
		}
		//reutrns index for quit line 
		System.out.println(c+2+") Quit to previous");
		return c+2; 
	}

	//print method shows active loans 
	public void showLoans(){
		//checks if there is a loan in the loan array 
		if(bookLoans.size() > 0)
		{
			int c = 0; 
			for(bookLoanEntry loan : bookLoans)
			{
				System.out.println(c+1+") "+loan.userCardNumber + " " + loan.bookTitle);
				c+=1; 
			}
			System.out.println(c+2+") Quit to previous");
		}else{System.out.println("No loans in system");}

	}
	//set method to set / change  library name 
	public void setName(String s){
		name = s; 
		System.out.println("name successfully set");
	}
	//set method to set / change library address 
	public void setAddress(String s){
		address = s;
		System.out.println("address successfully set");
	}
}
