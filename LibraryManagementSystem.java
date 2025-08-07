package IntershipTasks;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        // Add some default books
        library.addBook(new Book("Java Basics", "James Gosling"));
        library.addBook(new Book("Python 101", "Guido van Rossum"));
        library.addBook(new Book("C++ Primer", "Bjarne Stroustrup"));
        library.addBook(new Book("Clean Code", "Robert C. Martin"));

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. View Available Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    library.showAvailableBooks();
                    break;

                case 2:
                    System.out.print("Enter book title to issue: ");
                    String issueTitle = sc.nextLine();
                    Book bookToIssue = library.findBookByTitle(issueTitle);
                    if (bookToIssue != null && !bookToIssue.isIssued()) {
                        bookToIssue.issueBook();
                        System.out.println(" Book issued: " + bookToIssue.getTitle());
                    } else {
                        System.out.println(" Book not available or already issued.");
                    }
                    break;

                case 3:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = sc.nextLine();
                    Book bookToReturn = library.findBookByTitle(returnTitle);
                    if (bookToReturn != null && bookToReturn.isIssued()) {
                        bookToReturn.returnBook();
                        System.out.println(" Book returned: " + bookToReturn.getTitle());
                    } else {
                        System.out.println(" Book not found or not issued.");
                    }
                    break;

                case 4:
                    System.out.print("Enter keyword to search (title/author): ");
                    String keyword = sc.nextLine();
                    ArrayList<Book> results = library.searchBooks(keyword);
                    if (results.isEmpty()) {
                        System.out.println(" No books found.");
                    } else {
                        System.out.println(" Search Results:");
                        for (Book b : results) {
                            System.out.println(b);
                        }
                    }
                    break;

                case 5:
                    System.out.println(" Exiting... Goodbye!");
                    return;

                default:
                    System.out.println(" Invalid choice. Try again.");
            }
        }
    }
}
