package br.com.arianarusso.accountaccess.repositories;

import br.com.arianarusso.accountaccess.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRespository extends JpaRepository<Account, UUID> {
}
