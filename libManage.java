import java.util.Scanner;
import java.util.ArrayList;


public class libManage{
	
	public static void Librarian(Scanner sc, library[] libraries){

		System.out.println("1) Enter Branch you manage \n2) Quit to previous");

		int input = sc.nextInt();

		switch(input){
			case 1:
			System.out.println("Enter Branch you manage");
			System.out.println("1) University Library, Boston \n2) State Library, New York \n3) Federal Library, Washington DC \n4) County Library, McLean VA \n5) Quit to previous");
			int input2 = sc.nextInt();
			switch(input2){
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				Menu(sc, libraries);
			}
			case 2:
			Menu(sc, libraries);
		}
	}
	public static boolean Validate(String str){

		if(str.matches("[0-9]+")){
			return true;
		}else{
			return false;
		}

	}
	public static void Borrower(Scanner sc, library[] libs)
	{
		boolean valid = false;
		while(valid == false)
		{
			System.out.println("Enter a valid card number: ");
			String input = sc.nextLine();

			if(Validate(input))
			{
				valid = true;
			}
		}

		
		System.out.println("1) Check out a book \n2) Return a book \n3) Quit to previous");
		int input = sc.nextInt();
		switch(input)
		{
			case 1:
			int quit_option = 1;
			System.out.println("Pick the Branch you want to check out from:");
			for (int y=0; y<libs.length; y++)
			{
				System.out.println(y+1+") "+libs[y].name);
			}
			System.out.println(libs.length+1+") Quit to previous");

			int input2 = sc.nextInt();
			System.out.println("Pick the Book you want to check out ");
			int i = 1;
			ArrayList<String> inStock = new ArrayList<String>();
			for(String[] book : libs[input2-1].books){

				if(Integer.parseInt(book[1])>0){
					System.out.println(i+") "+book[0] + " - copies:" +book[1]);
					inStock.add(book[0]);
					i+=1;
				}
			}
			int input3 = sc.nextInt();

			String bookName = inStock.get(input3-1); 

			libs[input2-1].createLoan(bookName);
			break;

			case 2:
			case 3:
			Menu(sc, libs);
		} 


	}

	public static void LibNames(library[] libs){

		int i = 0;
		for (library lib : libs)
		{
			System.out.println(i+1+") "+lib.name);
			i += 1;
		}
		System.out.println(i+1+") Quit to previous");
	}


	public static void Menu(Scanner sc, library[] libraries){


		System.out.println("1) Librarian \n2) Administrator \n3) Borrower");

		int input = sc.nextInt();

		switch(input){

			case 1:
			Librarian(sc, libraries);
			break;
			case 2:
			break;
			case 3:
			Borrower(sc, libraries);
			break;
			default:
			break; 

		} 
	}



	public static void main (String args[]){

		Scanner sc = new Scanner(System.in);

		library[] libraries = new library[4];


		libraries[0] = new library("University Library","Boston");
		libraries[1] = new library("State Library","New York");
		libraries[2] = new library("Federal Library","Washington, DC");
		libraries[3] = new library("County Library","McLean VA");

		Borrower(sc, libraries);
		sc.close();

	}
}
