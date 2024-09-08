package ManagingLibrary;

public class Journal extends LibraryItem {
	//attributes
    private static int nextID = 1; 
    private final String ID; 
    private int volume;
    
    //default constructor
    public Journal() {
        super();
        this.ID = "J" + nextID++; 
    }

    // parametrized constructor
    public Journal(String title, boolean isLeased, int yearOfPublication, String author, int volume) {
        super(title, isLeased, yearOfPublication, author);
        this.ID = "J" + nextID++; 
        this.volume = volume;
    }
    // copy construcor
    public Journal(Journal other) {
        super(other);
        this.ID = "J" + nextID++; 
        this.volume = other.volume;
    }

    // equals method
    public boolean equals(Object obj) {
        if (!super.equals(obj)) 
        	return false;
        Journal journal = (Journal) obj;
        return this.volume == journal.volume; 
    }

    @Override
    public String getItemType() {
        return "Journal";
    }

    // getters and setters
    public String getID() { 
    	return ID; 
    	}
    public int getVolume() { 
    	return volume; 
    	}
    public void setVolume(int volume) { 
    	this.volume = volume; 
    	}

    // to string method (overridden)
    public String toString() {
        return super.toString() +
               "\nJournal ID: " + ID +
               "\nVolume: " + volume +
               "\n------------------------------";
    }
}
