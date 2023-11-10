package br.com.arianarusso.accountaccess.mappers;

import br.com.arianarusso.accountaccess.dtos.TransactionRegistrationDto;
import br.com.arianarusso.accountaccess.entities.Account;
import br.com.arianarusso.accountaccess.entities.Transaction;
import java.time.LocalDateTime;

public class TransactionRegistrationMapper {

    public static TransactionRegistrationDto entityToDto(Transaction transaction) {
        return new TransactionRegistrationDto(
                transaction.getSender().getNumber(),
                transaction.getReceiver().getNumber(),
                transaction.getAmount()
        );
    }

    public static Transaction dtoToEntity(TransactionRegistrationDto dto, Account sender, Account receiver) {
       return Transaction.builder()
               .amount(dto.value())
               .timesstamp(LocalDateTime.now())
               .receiver(receiver)
               .sender(sender)
               .build();

    }
}
