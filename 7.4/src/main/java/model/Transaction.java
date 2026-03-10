package model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction_record")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_currency_abbr", nullable = false)
    private Currency fromCurrency;

    @ManyToOne
    @JoinColumn(name = "to_currency_abbr", nullable = false)
    private Currency toCurrency;

    @Column(name = "amount_from", nullable = false)
    private double amountFrom;

    @Column(name = "amount_to", nullable = false)
    private double amountTo;

    @Column(name = "transaction_time", nullable = false)
    private LocalDateTime transactionTime;

    public Transaction() {
        this.transactionTime = LocalDateTime.now();
    }

    public Transaction(Currency fromCurrency, Currency toCurrency, double amountFrom, double amountTo) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amountFrom = amountFrom;
        this.amountTo = amountTo;
        this.transactionTime = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(Currency fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(Currency toCurrency) {
        this.toCurrency = toCurrency;
    }

    public double getAmountFrom() {
        return amountFrom;
    }

    public void setAmountFrom(double amountFrom) {
        this.amountFrom = amountFrom;
    }

    public double getAmountTo() {
        return amountTo;
    }

    public void setAmountTo(double amountTo) {
        this.amountTo = amountTo;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }
}