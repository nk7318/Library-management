import java.util.ArrayList;
import java.util.Scanner;

public class libarery {
    private static ArrayList<Book> bookList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the library management system!");
            System.out.println("1. Add book");
            System.out.println("2. Display all books");
            System.out.println("3. Search book");
            System.out.println("4. Exit");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    System.out.println("Thank you for using the library management system!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void addBook() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter book ID:");
        int id = input.nextInt();

        System.out.println("Enter book title:");
        String title = input.next();

        System.out.println("Enter book author:");
        String author = input.next();

        Book newBook = new Book(id, title, author);
        bookList.add(newBook);

        System.out.println("Book added successfully!");
    }

    public static void displayBooks() {
        if (bookList.isEmpty()) {
            System.out.println("No books available in the library!");
            return;
        }

        System.out.println("List of books in the library:");
        for (Book book : bookList) {
            System.out.println(book.toString());
        }
    }

    public static void searchBook() {
        if (bookList.isEmpty()) {
            System.out.println("No books available in the library!");
            return;
        }

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the book title:");
        String title = input.next();

        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book.toString());
                return;
            }
        }

        System.out.println("Book not found!");
    }
}

class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author;
    }
}

