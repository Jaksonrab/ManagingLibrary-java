package ManagingLibrary;

public abstract class LibraryItem {
	// attributes
    private String title;
    private boolean isLeased;
    private int yearOfPublication;
    private String author;

    // default constructor
    public LibraryItem() {
        this.title = "";
        this.isLeased = false;
        this.yearOfPublication = 0;
        this.author = "";
    }

    // parametrized constructor
    public LibraryItem(String title, boolean isLeased, int yearOfPublication, String author) {
        this.title = title;
        this.isLeased = isLeased;
        this.yearOfPublication = yearOfPublication;
        this.author = author;
    }

    // copy constructor
    public LibraryItem(LibraryItem other) {
        this.title = other.title;
        this.isLeased = other.isLeased;
        this.yearOfPublication = other.yearOfPublication;
        this.author = other.author;
    }

    // equals method
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        LibraryItem that = (LibraryItem) obj;

        return this.title.equals(that.title) &&
               this.yearOfPublication == that.yearOfPublication &&
               this.author.equals(that.author);
    }

    // Abstract method that subclasses must implement
    public abstract String getItemType();

    // Standard getters and setters
    public String getTitle() { 
    	return title; 
    	}
    public void setTitle(String title) { 
    	this.title = title; 
    	}
    public boolean isLeased() { 
    	return isLeased; 
    	}
    public void setLeased(boolean isLeased) { 
    	this.isLeased = isLeased; 
    	}
    public int getYearOfPublication() { 
    	return yearOfPublication; 
    	}
    public void setYearOfPublication(int yearOfPublication) { 
    	this.yearOfPublication = yearOfPublication; 
    	}
    public String getAuthor() { 
    	return author; 
    	}
    public void setAuthor(String author) { 
    	this.author = author; 
    	}

    // to string method
    public String toString() {
        String leaseStatus = isLeased ? "Leased" : "Not leased";
        return "\n------------------------------" +
               "\nTitle: " + title +
               "\nLease status: " + leaseStatus +
               "\nYear of publication: " + yearOfPublication;
    }
}
