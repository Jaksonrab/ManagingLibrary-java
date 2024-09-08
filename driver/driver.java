package driver;

import ManagingLibrary.Book;
import ManagingLibrary.Journal;
import ManagingLibrary.LibraryItem;
import ManagingLibrary.Media;
import Client.Client;
import java.util.Scanner;

public class driver {

    // attributes
    private static Book[] books = new Book[100];
    private static Journal[] journals = new Journal[100];
    private static Media[] media = new Media[100];
    private static Client[] clients = new Client[100];
    private static int bookCount = 0, journalCount = 0, mediaCount = 0, clientCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // asking user menu or predefined scenario
        System.out.println("Menu (M) or predefined scenario (P)?");
        String choice = scanner.nextLine().toUpperCase();

        if ("M".equals(choice)) {
            displayMenu(scanner);
        } else if ("P".equals(choice)) {
            runPredefinedScenario();
        } else {
            System.out.println("Invalid choice.");
        }
    }
    
    // display menu method
    private static void displayMenu(Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Library Management System Menu ---");
            System.out.println("1. Add an item");
            System.out.println("2. Delete an item");
            System.out.println("3. Change information of an item");
            System.out.println("4. List all items in a category");
            System.out.println("5. Print all items");
            System.out.println("6. Add a client");
            System.out.println("7. Edit a client");
            System.out.println("8. Delete a client");
            System.out.println("9. Lease an item to a client");
            System.out.println("10. Return an item from a client");
            System.out.println("11. Show all items leased by a client");
            System.out.println("12. Show all leased items");
            System.out.println("13. Display the biggest book");
            System.out.println("14. Make a copy of the books array");
            System.out.println("15. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addItem(scanner);
                    break;
                case 2:
                    deleteItem(scanner);
                    break;
                case 3:
                	editItem(scanner);
                    break;
                case 4:
                	listItemsInCategory(scanner);
                    break;
                case 5:
                	printAllItems();
                    break;
                case 6:
                    addClient(scanner);
                    break;
                case 7:
                	editClient(scanner);
                    break;
                case 8:
                	deleteClient(scanner);
                    break;
                case 9:
                	leaseItemToClient(scanner);
                    break;
                case 10:
                    returnItemFromClient(scanner);
                    break;
                case 11:
                    showItemsLeasedByClient(scanner);
                    break;
                case 12:
                	showAllLeasedItems();
                    break;
                case 13:
                	Book biggestBook = Book.getBiggestBook(books); // Assuming 'books' is your Book array
                	System.out.println("Biggest Book: " + (biggestBook != null ? biggestBook.toString() : "No books available."));
                    break;
                case 14:
                    Book[] copiedBooks = copyBooks();
                    System.out.println("Books array copied. Copy size: " + copiedBooks.length);
                    break;
                case 15:
                    System.out.println("Exiting the system. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 15.");
            }
        }
    }

     // predefined scenario method
    private static void runPredefinedScenario() {
    	LibraryItem[] items = new LibraryItem[9];
    	books = new Book[3]; 
        journals = new Journal[3]; 
        media = new Media[3]; 
        clients = new Client[3]; 
        
    	books[0] = new Book("Book One", false, 2020, "Author A", 572);
    	books[1] = new Book("Book Two", true, 2017, "Author B", 367);
    	books[2] = new Book("Book One", true, 2020, "Author A", 572);
    	journals[0] = new Journal("Journal One", true, 2019, "Author D", 1);
        journals[1] = new Journal("Journal Two", false, 2018, "Author E", 2);
        journals[2] = new Journal("Journal Three", false, 2009, "Author F", 1);
        media[0] = new Media("Media One", false, 2021, "Author G", "DVD");
        media[1] = new Media("Media Two", false, 2018, "Author H", "audio");
        media[2] = new Media("Media Three", false, 2005, "Author I", "video");
    
        clients[0] = new Client(1, "Client One", 5148394383L, "client1@example.com");
        clients[1] = new Client(2, "Client Two", 5149711704L, "client2@example.com");
        clients[2] = new Client(3, "Client Three", 5148363842L, "client3@example.com");
        
     // display book info
        for (Book book : books) {
            System.out.println(book.toString());
        }
     // display journal info
        for (Journal journal : journals) {
            System.out.println(journal.toString());
        }
        // display media info
        for (Media media : media) {
            System.out.println(media.toString());
        }
        // display client info
        for (Client client : clients) {
            System.out.println(client.toString());
        }
        
        // equality tests
        
        if (books[0].equals(journals[0])) {
        	 System.out.println("Book One and Journal One are the same.");
        }
        else System.out.println("Book One and Journal One are not the same."); 
    
        
        if (media[0].equals(media[1])) {
       	 System.out.println("Media One and Media Two are the same.");
       }
       else System.out.println("Book One are not the same."); 
    	
        if (books[0].equals(books[2])) {
       	 System.out.println("Book One and Book Two are the same.");
       }
       else System.out.println("Book One and Book Two are not the same."); 

        {
        
        // biggest book method
        	Book biggestBook = Book.getBiggestBook(books);
        	System.out.println("\nBiggest Book: " + biggestBook);

            }
     // copybooks method on media array
        	// Replacing books array with media items
        for (int i = 0; i < media.length; i++) {
            if (media[i] != null) {
                books[i] = new Book(media[i].getTitle(), media[i].isLeased(), media[i].getYearOfPublication(), media[i].getAuthor(), 0);
                // Update bookCount as media items are added
                bookCount++;
            }
        }

        	// Copy the media items in the books array
        Book[] copiedBooks = copyBooks();
        System.out.println("\nMedia array copied. Copy size: " + copiedBooks.length);
    }
    
    	
    // Add item method
    private static void addItem(Scanner scanner) {
        System.out.println("Select item type to add (1, 2 or 3):");
        System.out.println("1. Book");
        System.out.println("2. Journal");
        System.out.println("3. Media");
        System.out.print("Enter your choice: ");
        int itemType = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        System.out.print("Enter year of publication: ");
        int year = scanner.nextInt();
        scanner.nextLine(); 

        switch (itemType) {
            case 1:
                System.out.print("Enter number of pages: ");
                int numPages = scanner.nextInt();
                scanner.nextLine(); 
                books[bookCount++] = new Book(title, false, year, author, numPages);
                break;
            case 2:
                System.out.print("Enter volume: ");
                int volume = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                journals[journalCount++] = new Journal(title, false, year, author, volume);
                break;
            case 3:
                System.out.print("Enter media type (audio/video/interactive): ");
                String type = scanner.nextLine();
                media[mediaCount++] = new Media(title, false, year, author, type);
                break;
            default:
                System.out.println("Invalid choice. Choose the respective number to the item type.");
        }
    }
    // delete item method
    private static void deleteItem(Scanner scanner) {
        System.out.println("Select item type to delete (1, 2 or 3):");
        System.out.println("1. Book");
        System.out.println("2. Journal");
        System.out.println("3. Media");
        System.out.print("Enter your choice: ");
        int itemType = scanner.nextInt();
        scanner.nextLine(); 

        switch (itemType) {
            case 1:
                deleteBook(scanner);
                break;
            case 2:
                deleteJournal(scanner);
                break;
            case 3:
                deleteMedia(scanner);
                break;
            default:
                System.out.println("Invalid choice. Choose the respective number to the item type.");
        }
    }
    // method to delete book
    private static void deleteBook(Scanner scanner) {
        System.out.print("Enter the ID of the book you want to delete: ");
        String bookID = scanner.nextLine();

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getID().equals(bookID)) {
                for (int j = i; j < bookCount - 1; j++) {
                    books[j] = books[j + 1];
                }
                bookCount--;
                System.out.println("Book deleted successfully.");
                return;
            }
        }
        System.out.println("Book not found with ID: " + bookID);
    }
    // method to delete journal
    private static void deleteJournal(Scanner scanner) {
        System.out.print("Enter the ID of the journal you want to delete: ");
        String journalID = scanner.nextLine();

        for (int i = 0; i < journalCount; i++) {
            if (journals[i].getID().equals(journalID)) {
                for (int j = i; j < journalCount - 1; j++) {
                    journals[j] = journals[j + 1];
                }
                journalCount--;
                System.out.println("Journal deleted successfully.");
                return;
            }
        }
        System.out.println("Journal not found with ID: " + journalID);
    }
    // method to delete media
    private static void deleteMedia(Scanner scanner) {
        System.out.print("Enter the ID of the media you want to delete: ");
        String mediaID = scanner.nextLine();

        for (int i = 0; i < mediaCount; i++) {
            if (media[i].getID().equals(mediaID)) {
                for (int j = i; j < mediaCount - 1; j++) {
                    media[j] = media[j + 1];
                }
                mediaCount--;
                System.out.println("Media deleted successfully.");
                return;
            }
        }
        System.out.println("Media not found with ID: " + mediaID);
    }
    // edit item method
    private static void editItem(Scanner scanner) {
        System.out.println("Select item type to edit (1, 2 or 3):");
        System.out.println("1. Book");
        System.out.println("2. Journal");
        System.out.println("3. Media");
        System.out.print("Enter your choice: ");
        int itemType = scanner.nextInt();
        scanner.nextLine(); 

        switch (itemType) {
            case 1:
                editBook(scanner);
                break;
            case 2:
                editJournal(scanner);
                break;
            case 3:
                editMedia(scanner);
                break;
            default:
                System.out.println("Invalid choice. Choose the respective number to the item type.");
        }
    }
    	// method to edit book
    private static void editBook(Scanner scanner) {
        System.out.print("Enter the ID of the book you want to edit: ");
        String bookID = scanner.nextLine();

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getID().equals(bookID)) {
                System.out.print("Enter new title: ");
                String newTitle = scanner.nextLine();
                books[i].setTitle(newTitle);

                System.out.print("Enter new author: ");
                String newAuthor = scanner.nextLine();
                books[i].setAuthor(newAuthor);

                System.out.print("Enter new year of publication: ");
                int newYear = scanner.nextInt();
                scanner.nextLine(); 
                books[i].setYearOfPublication(newYear);

                System.out.print("Enter new number of pages: ");
                int newNumPages = scanner.nextInt();
                scanner.nextLine(); 
                books[i].setNumPages(newNumPages);

                System.out.println("Book information updated successfully.");
                return;
            }
        }
        System.out.println("Book not found with ID: " + bookID);
    }
    // method to edit journal
    private static void editJournal(Scanner scanner) {
        System.out.print("Enter the ID of the journal you want to edit: ");
        String journalID = scanner.nextLine();

        for (int i = 0; i < journalCount; i++) {
            if (journals[i].getID().equals(journalID)) {
                System.out.print("Enter new title: ");
                String newTitle = scanner.nextLine();
                journals[i].setTitle(newTitle);

                System.out.print("Enter new author: ");
                String newAuthor = scanner.nextLine();
                journals[i].setAuthor(newAuthor);

                System.out.print("Enter new year of publication: ");
                int newYear = scanner.nextInt();
                scanner.nextLine(); 
                journals[i].setYearOfPublication(newYear);

                System.out.print("Enter new volume: ");
                int newVolume = scanner.nextInt();
                scanner.nextLine(); 
                journals[i].setVolume(newVolume);

                System.out.println("Journal information updated successfully.");
                return;
            }
        }
        System.out.println("Journal not found with ID: " + journalID);
    }
    // method to edit media
    private static void editMedia(Scanner scanner) {
        System.out.print("Enter the ID of the media you want to edit: ");
        String mediaID = scanner.nextLine();

        for (int i = 0; i < mediaCount; i++) {
            if (media[i].getID().equals(mediaID)) {
                System.out.print("Enter new title: ");
                String newTitle = scanner.nextLine();
                media[i].setTitle(newTitle);

                System.out.print("Enter new author: ");
                String newAuthor = scanner.nextLine();
                media[i].setAuthor(newAuthor);

                System.out.print("Enter new year of publication: ");
                int newYear = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                media[i].setYearOfPublication(newYear);

                System.out.print("Enter new media type: ");
                String newType = scanner.nextLine();
                media[i].setType(newType);

                System.out.println("Media information updated successfully.");
                return;
            }
        }
        System.out.println("Media not found with ID: " + mediaID);
    }
// list all items in category method
    private static void listItemsInCategory(Scanner scanner) {
        System.out.println("Select category to list items (1, 2 or 3):");
        System.out.println("1. Book");
        System.out.println("2. Journal");
        System.out.println("3. Media");
        System.out.print("Enter your choice: ");
        int category = scanner.nextInt();
        scanner.nextLine(); 

        switch (category) {
            case 1:
                System.out.println("--- Books ---");
                for (int i = 0; i < bookCount; i++) {
                    System.out.println(books[i].toString());
                }
                break;
            case 2:
                System.out.println("--- Journals ---");
                for (int i = 0; i < journalCount; i++) {
                    System.out.println(journals[i].toString());
                }
                break;
            case 3:
                System.out.println("--- Media ---");
                for (int i = 0; i < mediaCount; i++) {
                    System.out.println(media[i].toString());
                }
                break;
            default:
                System.out.println("Invalid choice. Choose the respective number for the category.");
        }
    }
// print all items method
    private static void printAllItems() {
        System.out.println("--- All Items ---");
        System.out.println("--- Books ---");
        for (int i = 0; i < bookCount; i++) {
            System.out.println(books[i].toString());
        }
        System.out.println("--- Journals ---");
        for (int i = 0; i < journalCount; i++) {
            System.out.println(journals[i].toString());
        }
        System.out.println("--- Media ---");
        for (int i = 0; i < mediaCount; i++) {
            System.out.println(media[i].toString());
        }
    }


    // add clients method
    private static int clientIDCounter = 1;
   
    private static void addClient(Scanner scanner) {
        // Generate a unique client ID
        int clientID = clientIDCounter++;

        System.out.print("Enter client name: ");
        String name = scanner.nextLine();

        System.out.print("Enter client phone number: ");
        long phoneNumber = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter client email address: ");
        String emailAddress = scanner.nextLine();

        // Create a new Client object and set its ID
        Client newClient = new Client();
        newClient.setID(clientID);
        newClient.setName(name);
        newClient.setPhoneNumber(phoneNumber);
        newClient.setEmailAddress(emailAddress);

        // Add the new client to the clients array
        clients[clientCount++] = newClient;

        System.out.println("Client added successfully. Their ID is " + clientID);
    }


    

    // edit a client
    private static void editClient(Scanner scanner) {
        System.out.print("Enter the ID of the client you want to edit: ");
        int clientID = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < clientCount; i++) {
            if (clients[i].getID() == clientID) {
                System.out.print("Enter new client name: ");
                String newName = scanner.nextLine();
                clients[i].setName(newName);

                System.out.print("Enter new client phone number: ");
                long newPhoneNumber = scanner.nextLong();
                scanner.nextLine(); 
                clients[i].setPhoneNumber(newPhoneNumber);

                System.out.print("Enter new client email address: ");
                String newEmailAddress = scanner.nextLine();
                clients[i].setEmailAddress(newEmailAddress);

                System.out.println("Client information updated successfully.");
                return;
            }
        }
        System.out.println("Client not found with ID: " + clientID);
    }
    // delete a client method
    private static void deleteClient(Scanner scanner) {
        System.out.print("Enter the ID of the client you want to delete: ");
        int clientID = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < clientCount; i++) {
            if (clients[i].getID() == clientID) {
                for (int j = i; j < clientCount - 1; j++) {
                    clients[j] = clients[j + 1];
                }
                clientCount--;
                System.out.println("Client deleted successfully.");
                return;
            }
        }
        System.out.println("Client not found with ID: " + clientID);
    }
    // lease an item method
    private static void leaseItemToClient(Scanner scanner) {
        System.out.print("Enter client ID: ");
        int clientID = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter the ID of the item to lease: ");
        String itemID = scanner.nextLine();

        // Search for the client
        Client client = null;
        for (int i = 0; i < clientCount; i++) {
            if (clients[i].getID() == clientID) {
                client = clients[i];
                break;
            }
        }

        if (client == null) {
            System.out.println("Client not found with ID: " + clientID);
            return;
        }

        // Search for the item and lease it to the client
        for (Book book : books) {
            if (book != null && book.getID().equals(itemID)) {
                if (!book.isLeased()) {
                    client.leaseItem(book);
                    book.setLeased(true);
                    System.out.println("Book leased successfully to client: " + client.getName());
                    return;
                } else {
                    System.out.println("Book with ID " + itemID + " is already leased.");
                    return;
                }
            }
        }

        for (Journal journal : journals) {
            if (journal != null && journal.getID().equals(itemID)) {
                if (!journal.isLeased()) {
                    client.leaseItem(journal);
                    journal.setLeased(true);
                    System.out.println("Journal leased successfully to client: " + client.getName());
                    return;
                } else {
                    System.out.println("Journal with ID " + itemID + " is already leased.");
                    return;
                }
            }
        }

        for (Media media : media) {
            if (media != null && media.getID().equals(itemID)) {
                if (!media.isLeased()) {
                    client.leaseItem(media);
                    media.setLeased(true);
                    System.out.println("Media leased successfully to client: " + client.getName());
                    return;
                } else {
                    System.out.println("Media with ID " + itemID + " is already leased.");
                    return;
                }
            }
        }

        System.out.println("Item not found with ID: " + itemID);
    }
    // return an item method
    private static void returnItemFromClient(Scanner scanner) {
        System.out.print("Enter client ID: ");
        int clientID = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter the ID of the item to return: ");
        String itemID = scanner.nextLine();

        // Search for the client
        Client client = null;
        for (int i = 0; i < clientCount; i++) {
            if (clients[i].getID() == clientID) {
                client = clients[i];
                break;
            }
        }

        if (client == null) {
            System.out.println("Client not found with ID: " + clientID);
            return;
        }

        // Search for the item and return it from the client
        for (LibraryItem item : client.getLeasedItems()) {
            if (item != null) {
                if (item instanceof Book) {
                    Book book = (Book) item;
                    if (book.getID().equals(itemID)) {
                        client.returnItem(book);
                        book.setLeased(false);
                        System.out.println("Item returned successfully from client: " + client.getName());
                        return;
                    }
                } else if (item instanceof Journal) {
                    Journal journal = (Journal) item;
                    if (journal.getID().equals(itemID)) {
                        client.returnItem(journal);
                        journal.setLeased(false);
                        System.out.println("Item returned successfully from client: " + client.getName());
                        return;
                    }
                } else if (item instanceof Media) {
                    Media media = (Media) item;
                    if (media.getID().equals(itemID)) {
                        client.returnItem(media);
                        media.setLeased(false);
                        System.out.println("Item returned successfully from client: " + client.getName());
                        return;
                    }
                }
            }
        }


        System.out.println("Item not found with ID " + itemID + " in the leased items of " + client.getName());
    }
    // show all items leased by a client mehtod
    private static void showItemsLeasedByClient(Scanner scanner) {
        System.out.print("Enter client ID: ");
        int clientID = scanner.nextInt();
        scanner.nextLine(); 

        // Search for the client
        Client client = null;
        for (int i = 0; i < clientCount; i++) {
            if (clients[i].getID() == clientID) {
                client = clients[i];
                break;
            }
        }

        if (client == null) {
            System.out.println("Client not found with ID: " + clientID);
            return;
        }

        System.out.println("Items leased by client " + client.getName() + ":");
        for (LibraryItem item : client.getLeasedItems()) {
            if (item != null) {
                System.out.println(item.toString());
            }
        }
    }
    // show all leased items by all clients method
    private static void showAllLeasedItems() {
        System.out.println("All leased items:");
        for (Client client : clients) {
            if (client != null) {
                for (LibraryItem item : client.getLeasedItems()) {
                    if (item != null) {
                        System.out.println("Client: " + client.getName() + ", Item: " + item.toString());
                    }
                }
            }
        }
    }
    private static Book[] copyBooks() {
        Book[] copiedBooks = new Book[bookCount];
        for (int i = 0; i < bookCount; i++) {
            copiedBooks[i] = new Book(books[i]); 
        }
        return copiedBooks;
    }

}
