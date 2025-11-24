
import java.util.HashMap;

public class LibraryApp {

    // ----------- Custom Exceptions -----------

    static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }

        public InvalidInputException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    static class ResourceNotFoundException extends Exception {
        public ResourceNotFoundException(String message) {
            super(message);
        }

        public ResourceNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    static class DatabaseConnectionException extends Exception {
        public DatabaseConnectionException(String message) {
            super(message);
        }

        public DatabaseConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    // ----------- Simple Library Database -----------

    private static HashMap<Integer, String> books = new HashMap<>();

    public static void main(String[] args) {

        // Adding some sample books
        books.put(101, "Java Programming");
        books.put(102, "Data Structures");

        try {
            //  Invalid Input Example
            borrowBook(-10);

            //  Resource Not Found Example
            findBook(999);

            //  Database Error Example
            connectToDatabase(true);

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
            System.out.println("\nProgram execution completed.");
        }
    }

    // ----------- Methods Demonstrating Exceptions -----------

    // Invalid input example
    public static void borrowBook(int bookId) throws InvalidInputException {
        if (bookId <= 0) {
            throw new InvalidInputException("Book ID cannot be zero or negative.");
        }

        System.out.println("Borrowing book with ID: " + bookId);
    }

    // Resource not found example
    public static void findBook(int bookId) throws ResourceNotFoundException {
        if (!books.containsKey(bookId)) {
            throw new ResourceNotFoundException("Book with ID " + bookId + " not found.");
        }

        System.out.println("Book Found: " + books.get(bookId));
    }

    // Database connection example
    public static void connectToDatabase(boolean simulateError) throws DatabaseConnectionException {
        if (simulateError) {
            throw new DatabaseConnectionException(
                    "Unable to connect to database.",
                    new RuntimeException("Connection timeout")
            );
        }

        System.out.println("Database connected successfully.");
    }
}
