package ManagingLibrary;

public class Media extends LibraryItem {
	// attributes
    private static int nextID = 1; 
    private final String ID; 
    private String type;
    
    // default constructor
    public Media() {
        super();
        this.ID = "M" + nextID++; // Assign unique ID at creation
    }
    	
    // parametrized constructor
    public Media(String title, boolean isLeased, int yearOfPublication, String author, String type) {
        super(title, isLeased, yearOfPublication, author);
        this.ID = "M" + nextID++; // Assign unique ID at creation
        this.type = type;
    }

    // copy constructor
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Media media = (Media) obj;
        return this.type.equals(media.type); // ID is not compared because it's unique for each instance
    }

    @Override
    public String getItemType() {
        return "Media";
    }

    // setters and getters
    public String getID() { 
    	return ID; 
    	}
    public String getType() { 
    	return type; 
    	}
    public void setType(String type) { 
    	this.type = type; 
    	}

 // to string method (overridden)
    public String toString() {
        return super.toString() +
               "\nMedia ID: " + ID +
               "\nType: " + type +
               "\n------------------------------";
    }
}

