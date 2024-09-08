package Client;

import ManagingLibrary.LibraryItem;

public class Client {
	// attributes
    private int ID; 
    private String name;
    private long phoneNumber;
    private String emailAddress;
    private LibraryItem[] leasedItems;
    private int itemCount;

    	// default constructor
    public Client() {
        this.name = "";
        this.phoneNumber = 0;
        this.emailAddress = "";
        this.leasedItems = new LibraryItem[5]; 
        this.itemCount = 0;
    }
    // parametrized constructor
    public Client(int ID, String name, long phoneNumber, String emailAddress) {
        this.ID = ID; 
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.leasedItems = new LibraryItem[5];
        this.itemCount = 0;
    }

    // Copy Constructor
    public Client(Client other) {
        this.ID = other.ID;
        this.name = other.name;
        this.phoneNumber = other.phoneNumber;
        this.emailAddress = other.emailAddress;
        this.leasedItems = new LibraryItem[other.leasedItems.length];
        this.itemCount = other.itemCount;
        System.arraycopy(other.leasedItems, 0, this.leasedItems, 0, other.itemCount);
    }

    // Methods to lease and return items
    public void leaseItem(LibraryItem item) {
        if (itemCount < leasedItems.length) {
            leasedItems[itemCount++] = item;
        } else {
            System.out.println("Cannot lease more items. Maximum limit reached.");
        }
    }

    public void returnItem(LibraryItem item) {
        for (int i = 0; i < itemCount; i++) {
            if (leasedItems[i].equals(item)) {
                for (int j = i; j < itemCount - 1; j++) {
                    leasedItems[j] = leasedItems[j + 1];
                }
                leasedItems[--itemCount] = null; 
                return;
            }
        }
        System.out.println("Item not found in the leased items.");
    }

    // Getters and setters 
    public int getID() { 
    	return ID; 
    	}
    public void setID(int ID) { 
    	this.ID = ID; 
    	
    	
    	}
    public String getName() { 
    	return name; 
    	}
    public void setName(String name) { 
    	this.name = name; 
    	
    	
    	}
    public long getPhoneNumber() { 
    	return phoneNumber; 
    	}
    public void setPhoneNumber(long phoneNumber) { 
    	this.phoneNumber = phoneNumber; 
    	
    	
    	}
    public String getEmailAddress() { 
    	return emailAddress; 
    	}
    public void setEmailAddress(String emailAddress) { 
    	this.emailAddress = emailAddress; 
    	}
    
    
    public LibraryItem[] getLeasedItems() {
        return leasedItems;
    }
    public void setLeasedItems(LibraryItem[] leasedItems) {
        this.leasedItems = leasedItems;
    }

    // equals method
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) 
        	return false;

        Client other = (Client) obj;

        if (!this.name.equals(other.name)) return false;
        if (!(this.phoneNumber==other.phoneNumber)) return false;
        if (!this.emailAddress.equals(other.emailAddress)) return false;
        return true;
    }
   

   // to string method (overridden)
    public String toString() {
        String leasedItemsList = "";
        for (int i = 0; i < itemCount; i++) {
            leasedItemsList += leasedItems[i].toString() + "\n";
        }
        return "\nClient name: " + name +
               "\nID: " + ID +
               "\nPhone number: " + phoneNumber + 
               "\nEmail address: " + emailAddress +
               "\nLeased Items:\n" + leasedItemsList;
    }
}
