import java.util.Scanner;
import java.util.ArrayList;


public class libManage{
	
	public static void Librarian(Scanner sc, library[] libraries){

		System.out.println("1) Enter Branch you manage \n2) Quit to previous");

		int input = sc.nextInt();

		String[] lib_names = {"University Library, Boston", "State Library, New York", "Federal Library, Washington DC", "County Library, McLean VA"};

		switch(input)
		{
			case 1:
			System.out.println("Enter Branch you manage");
			System.out.println("1) University Library, Boston \n2) State Library, New York \n3) Federal Library, Washington DC \n4) County Library, McLean VA \n5) Quit to previous");
			
			//input2 = lib index + 1 
			int input2 = sc.nextInt();

			if(input2 == 5){
				Menu(sc, libraries); 
			}else{
				System.out.println("1) Update the details of the Library \n2) Add copies of book to the Branch \n3) Quit to previous");
				int input3 = sc.nextInt();
				String newBranchName = "", newBranchAddress; 
				switch(input3){

					case 1:
					System.out.println("Please enter new branch name or enter N/A for no change:");
					String getNewLineChar = sc.nextLine();
					newBranchName = sc.nextLine();
					libraries[input2-1].setName(newBranchName);
					System.out.println("Please enter new branch address or enter N/A for no change:");
					newBranchAddress = sc.nextLine();
					libraries[input2-1].setAddress(newBranchAddress);
					case 2:
					boolean c2_exit = false; 
					while(c2_exit == false){
						System.out.println("Pick the Book you want to add copies of, to your branch:");
						int quitIndex = libraries[input2-1].showBooks();
						int book = sc.nextInt();
						if(quitIndex == book){
							c2_exit = true; 
						}else{
							System.out.println(libraries[input2-1].books[book-1][0] + "  copies: " + libraries[input2-1].books[book-1][1]);
							System.out.println("Enter new number of copies:");
							int toAdd = sc.nextInt(); 
							libraries[input2-1].addBooks(libraries[input2-1].books[book-1][0], toAdd);	
						}
					}				
					case 3:
					Menu(sc, libraries);
				}
			}
		}
	}
	//Validate() accepts a string and determines if it is an integer or invalid input 
	public static boolean Validate(String str){
		//Will return true if there are no digits in the string, will return false otherwise.
		if(str.matches("[0-9]+")){
			return true;
		}else{
			return false;
		}

	}
	//Borrower is a MAIN() method for checking out and returning books 
	public static void Borrower(Scanner sc, library[] libs)
	{
		//Contraints for a valid card number. 
		boolean valid = false;
		int cardNumber = 0; 
		//will not let user proceed unil user enters a string with no letters. See Validate()
		while(valid == false)
		{
			System.out.println("Enter a valid card number: ");
			String card = sc.nextLine();

			if(Validate(card))
			{
				cardNumber = Integer.parseInt(card); 
				valid = true;
			}
		}

		//Display BORR1 prompt and accept user input 
		System.out.println("1) Check out a book \n2) Return a book \n3) Quit to previous");
		int input = sc.nextInt(); 
		int quit_option = 1;
		int input2, input3;  
		String bookName;
		switch(input)
		{
			case 1: //Option 1 - Checkout a book
			System.out.println("Pick the Branch you want to check out from:");
			//Print library names and get user input 
			for (int y=0; y<libs.length; y++)
			{
				System.out.println(y+1+") "+libs[y].name);
			}
			System.out.println(libs.length+1+") Quit to previous");
			input2 = sc.nextInt();

			//only show books that have atleast one copy in BOOK_COPIES in the branch picked
			System.out.println("Pick the Book you want to check out ");
			int i = 1;
			//books with at least 1 copy are added to inStock[]
			ArrayList<String> inStock = new ArrayList<String>();
			for(String[] book : libs[input2-1].books){

				if(Integer.parseInt(book[1])>0){
					System.out.println(i+") "+book[0] + " - copies:" +book[1]);
					inStock.add(book[0]);
					i+=1;
				}
			}
			//user chooses which in stocked book they want to add copies of
			input3 = sc.nextInt();
			bookName = inStock.get(input3-1); 

			//Book Loan Entry is created and added to collection of bookloans
			libs[input2-1].createLoan(cardNumber,bookName);

			case 2: //Option 2 - return a book
			System.out.println("Pick the Branch you want to return book to");
			int j = 1;
			//Display all branch names registered in system and accept user input 
			for (int y=0; y<libs.length; y++)
			{
				System.out.println(y+1+") "+libs[y].name);
				j+=1;
			}
			System.out.println(libs.length+1+") Quit to previous");
			input2 = sc.nextInt();
			j=1;
			//Display all books names registered in system and accpet user input 
			System.out.println("Pick the Book you are returning");
			for(String[] book : libs[input2-1].books){
				System.out.println(j+") "+book[0] + " - copies:" +book[1]);
				j+=1;
			}
			input3 = sc.nextInt();

			//bookName uses input2 to index correct library.  
			bookName = libs[input2-1].name; 

			//Create not loan entry and add it to loan book 
			libs[input2-1].createLoan(cardNumber,bookName);

			case 3:
			Menu(sc, libs);
		} 


	}

	public static void LibNames(library[] libs){

		//variable will hold correct number to place quit to previous string. Accounts for more libraries being added 
		int i = 0;
		//iterate through each library() in the library[] libs 
		for (library lib : libs)
		{
			System.out.println(i+1+") "+lib.name);
			i += 1;
		}
		System.out.println(i+1+") Quit to previous");
	}


	public static boolean  Menu(Scanner sc, library[] libraries){

		//Display prompt for MAIN 
		System.out.println("1) Librarian \n2) Administrator \n3) Borrower \n4) Exit program");

		//Accpet user input for MAIN. Input is accpeted as an int in coordinance with number in prompt string 
		int input = sc.nextInt();

		//Switch statement reads input to determine which MAIN method to run
		switch(input){
			case 1:
			Librarian(sc, libraries);
			case 2:
			break;
			case 3:
			Borrower(sc, libraries);
			case 4:
			//Case 4 will for Main to return true and exit Main(); 
			return true; 
		} 
		return false;
	}



	public static void main (String args[]){


		//Creates new Scanner to accept user input 
		Scanner sc = new Scanner(System.in);

		//intialize a library array of size 4 (4 libraries)
		library[] libraries = new library[4];

		//Create library objects for the following libraries 
		libraries[0] = new library("University Library","Boston");
		libraries[1] = new library("State Library","New York");
		libraries[2] = new library("Federal Library","Washington, DC");
		libraries[3] = new library("County Library","McLean VA");

		//control variable to terminate Menu() 
		boolean exitMenu = false; 
		while(exitMenu == false){
			exitMenu = Menu(sc, libraries);
		}

		//close Scanner 
		sc.close();

	}
}
