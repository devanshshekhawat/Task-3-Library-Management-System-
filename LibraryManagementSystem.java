import java.util.*;

// Book class
class Book {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }

    public void issueBook() { isIssued = true; }
    public void returnBook() { isIssued = false; }

    @Override
    public String toString() {
        return id + " - " + title + " by " + author + (isIssued ? " (Issued)" : " (Available)");
    }
}

// User class
class User {
    private int id;
    private String name;
    private List<Book> borrowedBooks;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return id + " - " + name + " (Borrowed: " + borrowedBooks.size() + ")";
    }
}

// Library class
class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) { books.add(book); }
    public void addUser(User user) { users.add(user); }

    public void showBooks() {
        System.out.println("\nBooks in Library:");
        for (Book b : books) System.out.println(b);
    }

    public void showUsers() {
        System.out.println("\nRegistered Users:");
        for (User u : users) System.out.println(u);
    }

    public void issueBook(int bookId, int userId) {
        Book book = findBook(bookId);
        User user = findUser(userId);

        if (book != null && user != null) {
            if (!book.isIssued()) {
                book.issueBook();
                user.borrowBook(book);
                System.out.println(user.getName() + " issued " + book.getTitle());
            } else {
                System.out.println("Book already issued!");
            }
        } else {
            System.out.println("Book or User not found!");
        }
    }

    public void returnBook(int bookId, int userId) {
        Book book = findBook(bookId);
        User user = findUser(userId);

        if (book != null && user != null) {
            if (book.isIssued() && user.getBorrowedBooks().contains(book)) {
                book.returnBook();
                user.returnBook(book);
                System.out.println(user.getName() + " returned " + book.getTitle());
            } else {
                System.out.println("Book not issued to this user!");
            }
        } else {
            System.out.println("Book or User not found!");
        }
    }

    private Book findBook(int bookId) {
        for (Book b : books) if (b.getId() == bookId) return b;
        return null;
    }

    private User findUser(int userId) {
        for (User u : users) if (u.getId() == userId) return u;
        return null;
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books
        library.addBook(new Book(1, "Java Basics", "James Gosling"));
        library.addBook(new Book(2, "Effective Java", "Joshua Bloch"));
        library.addBook(new Book(3, "Clean Code", "Robert C. Martin"));

        // Adding users
        library.addUser(new User(101, "Devansh"));
        library.addUser(new User(102, "Aarav"));

        // Display
        library.showBooks();
        library.showUsers();

        // Issue and return
        library.issueBook(2, 101);
        library.issueBook(3, 102);
        library.showBooks();

        library.returnBook(2, 101);
        library.showBooks();
    }
}
