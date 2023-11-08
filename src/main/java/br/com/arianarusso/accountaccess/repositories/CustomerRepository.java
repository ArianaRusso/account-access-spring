package br.com.arianarusso.accountaccess.repositories;

import br.com.arianarusso.accountaccess.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
