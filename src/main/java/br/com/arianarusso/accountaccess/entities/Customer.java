package br.com.arianarusso.accountaccess.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String firstName;
    private String lastName;
    private String document;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

}

