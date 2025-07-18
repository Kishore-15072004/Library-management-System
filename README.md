# Library Management System

This is a simple Java-based Library Management System that allows users to add, search, update, and remove books from a MySQL database.

## Project Structure

- `LibraryManagent/app/`
  - [`LibraryManagement.java`](LibraryManagent/app/LibraryManagement.java): Interface defining library operations.
  - [`ImplementLibraryManagement.java`](LibraryManagent/app/ImplementLibraryManagement.java): Implementation of library operations using JDBC.
  - [`ProceedManagement.java`](LibraryManagent/app/ProceedManagement.java): Factory for obtaining a `LibraryManagement` instance.
- `libusage/app/`
  - [`UserLogic1.java`](libusage/app/UserLogic1.java): Main class providing a menu-driven CLI for library operations.

## Requirements

- Java 8 or higher
- MySQL database
- MySQL JDBC Driver (`mysql-connector-j-8.0.33.jar`)

## Setup

1. **Database Setup**
   - Create a database named `gejm8` in MySQL.
   - Create a table `librarydata` with the following columns:
     - `book` (VARCHAR)
     - `price` (INT)
     - `NofPages` (INT)
     - `author` (VARCHAR)
     - `edition` (INT)

   Example SQL:
   ```sql
   CREATE DATABASE gejm8;
   USE gejm8;
   CREATE TABLE librarydata (
     book VARCHAR(100),
     price INT,
     NofPages INT,
     author VARCHAR(100),
     edition INT
   );
   ```

2. **Configure JDBC URL**
   - The JDBC URL is set in [`ImplementLibraryManagement.java`](src/org/LibraryManagent/app/ImplementLibraryManagement.java):
     ```
     jdbc:mysql://localhost:3306?user=root&password=YOUR_PASSWORD
     ```
   - Update the password as needed.

3. **Build and Run**
   - Compile the project using your IDE or with `javac`.
   - Run the main class:
     ```
     java org.libusage.app.UserLogic1
     ```

## Usage

- The application provides a menu to:
  - Add a book
  - Search for a book (by name, author, or edition)
  - Update book details
  - Remove a book

Follow the prompts in the console to perform operations.

## License

This project is for
