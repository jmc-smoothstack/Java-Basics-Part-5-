public class bookEntry{

	String title, author, genre, publisher;
	bookEntry(){}
	bookEntry(String bookTitle, String bookAuthor ){

		title = bookTitle;
		author = bookAuthor;

	}
	bookEntry(String bookTitle, String bookAuthor, String bookGenre, String bookPublisher){
		title = bookTitle;
		author = bookAuthor;
		genre = bookGenre;
		publisher = bookPublisher; 

	}
}
