package br.com.arianarusso.accountaccess.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "number")
    private int number;

    @Column(name = "balance")
    private BigDecimal balance;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Account(Customer customer) {
        this.balance = new BigDecimal(BigInteger.ZERO);
        this.customer = customer;

    }

}
