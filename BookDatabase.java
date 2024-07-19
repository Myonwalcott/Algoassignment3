import java.util.Scanner;

public class BookDatabase {
    private static final int MAX_BOOKS = 100;  // Maximum number of books in the database
    private String[] isbnDatabase;             // Array to store ISBN numbers
    private int currentIndex;                  // Current index to keep track of added books

    // Constructor to initialize the database
    public BookDatabase() {
        isbnDatabase = new String[MAX_BOOKS];
        currentIndex = 0;
    }

    // Method to validate ISBN numbers
    public boolean validateISBN(String isbn) {
        // Assuming ISBN length is exactly 10 characters (for simplicity)
        return isbn.matches("[0-9]{10}");
    }

    // Method to add a book to the database
    public void addBook(String isbn) {
        if (currentIndex < MAX_BOOKS) {
            if (validateISBN(isbn)) {
                isbnDatabase[currentIndex++] = isbn;
                System.out.println("ISBN added successfully.");
            } else {
                System.out.println("Invalid ISBN. Please enter a valid 10-digit ISBN.");
            }
        } else {
            System.out.println("Database is full. Cannot add more books.");
        }
    }

    // Method to search for an ISBN in the database
    public boolean searchISBN(String isbn) {
        for (int i = 0; i < currentIndex; i++) {
            if (isbnDatabase[i].equals(isbn)) {
                return true;
            }
        }
        return false;
    }

    // Method to print all ISBNs in the database
    public void printAllISBNs() {
        System.out.println("ISBNs in the database:");
        for (int i = 0; i < currentIndex; i++) {
            System.out.println(isbnDatabase[i]);
        }
    }

    public static void main(String[] args) {
        BookDatabase bookDatabase = new BookDatabase();
        Scanner scanner = new Scanner(System.in);
        String isbn;

        // Example of adding books and searching ISBNs
        System.out.println("Enter ISBNs to add (or 'exit' to stop):");
        do {
            System.out.print("ISBN: ");
            isbn = scanner.nextLine().trim();

            if (!isbn.equalsIgnoreCase("exit")) {
                bookDatabase.addBook(isbn);
            }
        } while (!isbn.equalsIgnoreCase("exit"));

        System.out.println("\nEnter ISBN to search in database:");
        isbn = scanner.nextLine().trim();
        if (bookDatabase.searchISBN(isbn)) {
            System.out.println("ISBN found in database.");
        } else {
            System.out.println("ISBN not found in database.");
        }

        // Print all ISBNs in the database
        bookDatabase.printAllISBNs();

        scanner.close();
    }
}
