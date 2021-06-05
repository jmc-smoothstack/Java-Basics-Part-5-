import java.util.Scanner; 
import java.util.ArrayList; 
import java.util.*;
import java.util.Calendar; 
import java.io.*;

public class library{
	String name, address;
	String[][] books = {{"Lost Tribe by Sidney Sheldon", "1"}, {"The Haunting by Stepehen King", "2"}, {"Microtrends by Mark Penn", "3"}};

	Vector <bookLoanEntry> bookLoans = new Vector<bookLoanEntry>();


	library(){}
	library(String name, String address){
		this.name = name; 
		this.address = address; 
	}
	public void createLoan(int userCardNumber, String bookTitle){

		bookLoanEntry loan = new bookLoanEntry(userCardNumber, bookTitle);
		bookLoans.add(loan);
		bookOut(bookTitle);
		System.out.println("Loan successfully created");

	}
	public void returnBook(int cardNumber, String bt){
		int position = 0; 
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
		bookLoans.remove(position);
		System.out.println("remove succesful");
	}

	public void addBooks(String bookTitle, int booksToAdd){

		for(String[] book : books)
		{
			if(book[0]==bookTitle){
				book[1] = Integer.toString(Integer.parseInt(book[1])+booksToAdd);
				System.out.println("copies successfully updated - copies: " + book[1]);
			}
		}


	}

	public Vector<bookLoanEntry> getBookLoans(){
		return bookLoans;
	}

	public void bookOut(String bookTitle){
		for(int i=0; i<books.length;i++){
			//subtract book from inventory 
			if(bookTitle == books[i][0]){
				int current = Integer.parseInt(books[i][1])-1;
				books[i][1] = Integer.toString(current);
			}
		}
	}
	public int showBooks(){
		int c = 0; 
		for(int i=0; i<books.length; i++){
			System.out.println(i+1+") "+books[i][0] + "  copies: " + books[i][1]);
			c = i; 
		}
		System.out.println(c+2+") Quit to previous");
		return c+2; 
	}

	public void showLoans(){

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

	public void setName(String s){
		name = s; 
		System.out.println("name successfully set");
	}

	public void setAddress(String s){
		address = s;
		System.out.println("address successfully set");
	}

	public void libraryOptions(Scanner sc){
		System.out.println("1) Update library details \n2) Add copies of Book to Branch \n3) Quit to previous");
		int input = sc.nextInt();
		switch(input){
			case 1:
			System.out.println("1) Update name \n2) Update address");
			int input2 = sc.nextInt();
			switch(input2)
			{
				case 1:
				//changeName(sc);
				case 2:
				//changeAddress(sc);
			}
			case 2:   //add copies of books to branch 
			for(int i=0; i<books.length; i++){
				System.out.println(i+1+") "+books[i][0]);
			}
			int input3 = sc.nextInt();
			System.out.println(books[input3-1][0] + " - existing number of copies: " + books[input3-1][1]);
			System.out.println("Enter new number of copies");
			int input4 = sc.nextInt();
			books[input3-1][1] = Integer.toString(input4);
			System.out.println("__copies updated__("+books[input3-1][1]+")");
			case 3:
			break;
		}

	}
	public static void main (String args[]){
		library lib = new library();
		//lib.createLoan(12212, "jdfkgjfdl;k");
	}
}
