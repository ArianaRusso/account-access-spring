package br.com.arianarusso.accountaccess.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private BigDecimal amount;

    private LocalDateTime timesstamp;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Account receiver;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Account sender;

    public Transaction
            (UUID id, BigDecimal amount, LocalDateTime timesstamp, Account accountReceiver, Account accountSender) {
        this.id = id;
        this.amount = amount;
        this.timesstamp = timesstamp;
        this.receiver = accountReceiver;
        this.sender = accountSender;
    }

    public Transaction() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimesstamp() {
        return timesstamp;
    }

    public void setTimesstamp(LocalDateTime timesstamp) {
        this.timesstamp = timesstamp;
    }

    public Account getReceiver() {
        return receiver;
    }

    public void setReceiver(Account receiver) {
        this.receiver = receiver;
    }

    public Account getSender() {
        return sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }
}
