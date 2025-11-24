package com.moolya.exceptions;


import java.util.HashMap;

public class App {
    static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }

    static class ResourceNotFoundException extends Exception {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

    static class DatabaseConnectionException extends Exception {
        public DatabaseConnectionException(String message) {
            super(message);
        }
    }
    private static HashMap<Integer, String> books = new HashMap<>();

    public static void main(String[] args) {
        books.put(101, "Java Programming");
        books.put(102, "Data Structures");

        try {
            //  Invalid Input Example
            borrowBook(10);//(Exception wont get )
         //   borrowBook(-10);//(we will get the exception here)

            //  Resource Not Found Example
            findBook(102);//(we wont get the exception)
            //findBook(106);//(we will get the exception)

            //  Database Error Example
            connectToDatabase(true);//(we wont get the exception)
            //  connectToDatabase(false);//(we will get the exception)

        }
        catch (InvalidInputException e) {
            System.out.println("InvalidInputException Caught: " + e.getMessage());
        }
        catch (ResourceNotFoundException e) {
            System.out.println("ResourceNotFoundException Caught: " + e.getMessage());
        }
        catch (DatabaseConnectionException e) {
            System.out.println("DatabaseConnectionException Caught: " + e.getMessage());
        }
        finally {
            System.out.println("Program execution completed.");
        }
    }

    public static void borrowBook(int bookId) throws InvalidInputException {
        if (bookId <= 0) {
            throw new InvalidInputException("Book ID cannot be zero or negative.");
        }

        System.out.println("Borrowing book with ID: " + bookId);
    }
    
    public static void findBook(int bookId) throws ResourceNotFoundException {
        if (!books.containsKey(bookId)) {
            throw new ResourceNotFoundException("Book with ID " + bookId + " not found.");
        }

        System.out.println("Book Found: " + books.get(bookId));
    }

    public static void connectToDatabase(boolean simulateError) throws DatabaseConnectionException {
        if (!simulateError) {
            throw new DatabaseConnectionException(
                    "Unable to connect to database."
            );
        }

        System.out.println("Database connected successfully.");
    }
}
