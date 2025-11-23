package model;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberId;
    private String name;
    private List<Book> issuedBooks;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.issuedBooks = new ArrayList<>();
    }

    public String getMemberId() { 
      return memberId; 
    }
    public String getName() {
      return name;
    }
    public List<Book> getIssuedBooks() { 
      return issuedBooks;
    }

    public void issueBook(Book book) {
        issuedBooks.add(book);
        book.markUnavailable();
    }

    public void returnBook(Book book) {
        issuedBooks.remove(book);
        book.markAvailable();
    }
}
