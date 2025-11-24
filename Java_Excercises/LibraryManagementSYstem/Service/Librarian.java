package Service;

import model.Book;
import model.Member;
import Exception.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Librarian {

    private String name;
    private String employeeId;

    private List<Book> books;
    private List<Member> members;

    public Librarian(String name, String employeeId) {
        this.name = name;
        this.employeeId = employeeId;
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(int bookId) throws ResourceNotFoundException {
        boolean removed = books.removeIf(b -> b.getBookId() == bookId);
        if (!removed)
            throw new ResourceNotFoundException("Book not found.");
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    public Book findBook(int bookId) throws ResourceNotFoundException {
        for (Book b : books) {
            if (b.getBookId() == bookId) return b;
        }
        throw new ResourceNotFoundException("Book not found.");
    }

    public Member findMember(String memberId) throws ResourceNotFoundException {
        for (Member m : members) {
            if (m.getMemberId().equals(memberId)) return m;
        }
        throw new ResourceNotFoundException("Member not found.");
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public List<Member> getAllMembers() {
        return members;
    }
}
