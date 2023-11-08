package br.com.arianarusso.accountaccess.repositories;

import br.com.arianarusso.accountaccess.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRespository extends JpaRepository<Transaction, UUID> {
}
