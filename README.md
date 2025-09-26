# Task-3-Library-Management-System-

Hey Everyone!! This is a simple Library Management System implemented in Java.
It demonstrates Object-Oriented Programming (OOP) concepts such as classes, objects, lists, and relationships between entities.
The system allows you to:
* Add books and users
* Issue books to users
* Return books to library
* View list of books and users

Classes Used :-
1. Book
Represents a single book in the library.
Fields: id, title, author, isIssued
Methods: issueBook(), returnBook(), toString()

2. User
Represents a user of the library.
Fields: id, name, borrowedBooks
Methods: borrowBook(Book), returnBook(Book), toString()

3. Library
Manages the entire library system.
Fields: books, users
Methods:
addBook(Book)
addUser(User)
showBooks()
showUsers()
issueBook(int bookId, int userId)
returnBook(int bookId, int userId)

4. LibrarySystem (Main Class)
Contains the main() method to run the program.
Adds sample data (books and users) and demonstrates issue/return operations.

How It Works :-

Add books and users to the library.
Display the current list of books and users.
Issue a book → Book marked as Issued, added to user’s borrowed list.
Return a book → Book marked as Available, removed from user’s list.
