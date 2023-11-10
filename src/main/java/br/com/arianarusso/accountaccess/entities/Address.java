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
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String postalCode;
    private String street;
    private int number;
    private String complement;
    private String city;
    private String state;
    private String country;
}