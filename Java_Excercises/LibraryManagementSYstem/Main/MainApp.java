import model.*;
import service.Librarian;
import exception.*;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Librarian librarian = new Librarian("Admin", "EMP001");

        try {
            while (true) {
                System.out.println("\n1.Add Book\n2.Register Member\n3.Issue Book\n4.Return Book\n5.Show Books\n6.Exit");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Book ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Title: ");
                        String title = sc.nextLine();
                        System.out.print("Author: ");
                        String author = sc.nextLine();
                        librarian.addBook(new Book(id, title, author));
                        System.out.println("Book Added.");
                    }

                    case 2 -> {
                        sc.nextLine();
                        System.out.print("Member ID: ");
                        String mid = sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        librarian.registerMember(new Member(mid, name));
                        System.out.println("Member Registered.");
                    }

                    case 3 -> {
                        System.out.print("Book ID: ");
                        int bookId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Member ID: ");
                        String memberId = sc.nextLine();

                        Book book = librarian.findBook(bookId);
                        Member member = librarian.findMember(memberId);

                        if (book.isAvailable()) {
                            member.issueBook(book);
                            System.out.println("Book Issued.");
                        } else {
                            System.out.println("Already Issued.");
                        }
                    }

                    case 4 -> {
                        System.out.print("Book ID: ");
                        int bookId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Member ID: ");
                        String memberId = sc.nextLine();

                        Book book = librarian.findBook(bookId);
                        Member member = librarian.findMember(memberId);

                        member.returnBook(book);
                        System.out.println("Book Returned.");
                    }

                    case 5 -> {
                        for (Book b : librarian.getAllBooks()) {
                            b.display();
                        }
                    }

                    case 6 -> {
                        System.out.println("Exit.");
                        return;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
