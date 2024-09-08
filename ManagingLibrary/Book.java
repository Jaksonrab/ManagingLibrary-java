package ManagingLibrary;

public class Book extends LibraryItem {
	// attributes
    private static int nextID = 1; 
    private final String ID; 
    private int numPages;

    // default constructor
    public Book() {
        super();
        this.ID = "B" + nextID++; 
        this.numPages = 0;
    }
// parametrized constructor
    public Book(String title, boolean isLeased, int yearOfPublication, String author, int numPages) {
        super(title, isLeased, yearOfPublication, author);
        this.ID = "B" + nextID++; 
        this.numPages = numPages;
    }
// copy constructor
    public Book(Book other) {
        super(other);
        this.ID = "B" + nextID++; 
        this.numPages = other.numPages;
    }
 //   method to find the biggest book
    public static Book getBiggestBook(Book[] books) {
        if (books == null || books.length == 0) 
        	return null; 

        Book biggestBook = null; 
        for (Book book : books) {
            if (book != null && (biggestBook == null || book.getNumPages() > biggestBook.getNumPages())) {
                biggestBook = book;
            }
        }
        return biggestBook;
    }

 // equals method
    public boolean equals(Object obj) {
        if (!super.equals(obj)) 
        	return false;
        Book book = (Book) obj;
        return this.numPages == book.numPages; 
    }

    @Override
    public String getItemType() {
        return "Book";
    }

 // setters and getters
    public String getID() { 
    	return ID; 
    	}
    public int getNumPages() { 
    	return numPages; 
    	}
    public void setNumPages(int numPages) { 
    	this.numPages = numPages; 
    	}

 // to string method (overridden)
    public String toString() {
        return super.toString() +
               "\nBook ID: " + ID +
               "\nNumber of pages: " + numPages +
               "\n------------------------------";
    }
}
