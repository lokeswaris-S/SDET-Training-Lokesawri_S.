package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Transaction {

    private String transactionId;
    private int bookId;
    private String memberId;
    private LocalDate issueDate;
    private LocalDate returnDate;
    private double fineAmount;

    private static final double FINE_PER_DAY = 5;

    public Transaction(String transactionId, int bookId, String memberId) {
        this.transactionId = transactionId;
        this.bookId = bookId;
        this.memberId = memberId;
        this.issueDate = LocalDate.now();
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
        calculateFine();
    }

    public double calculateFine() {
        long days = ChronoUnit.DAYS.between(issueDate, returnDate);

        if (days > 14) {
            fineAmount = (days - 14) * FINE_PER_DAY;
        } else {
            fineAmount = 0;
        }
        return fineAmount;
    }

    public double getFineAmount() {
        return fineAmount;
    }
}
