package br.com.arianarusso.accountaccess.services;

import br.com.arianarusso.accountaccess.dtos.TransactionRegistrationDto;
import br.com.arianarusso.accountaccess.dtos.TransactionQueryDto;
import br.com.arianarusso.accountaccess.entities.Account;
import br.com.arianarusso.accountaccess.entities.Transaction;
import br.com.arianarusso.accountaccess.exceptions.BusinessRuleException;
import br.com.arianarusso.accountaccess.exceptions.NotFoundResourceException;
import br.com.arianarusso.accountaccess.mappers.TransactionRegistrationMapper;
import br.com.arianarusso.accountaccess.mappers.TransactionQueryMapper;
import br.com.arianarusso.accountaccess.repositories.AccountRespository;
import br.com.arianarusso.accountaccess.repositories.TransactionRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class TransactionService {

    @Autowired
    private AccountRespository accountRepository;

    @Autowired
    private TransactionRespository transactionRespository;


    public BigDecimal checkAccountBalance (int accountNumber){
        return this.getAccount(accountNumber).getBalance();
    }

    @Transactional
    public TransactionQueryDto payIn (TransactionRegistrationDto dto){

        Account sender = this.getAccount(dto.numberAccountSender());
        Account receiver = this.getAccount(dto.numberAccountReceiver());

        this.validateTransaction(dto, sender);

        Transaction  newTransaction = this.saveTransaction(dto, sender, receiver);

        BigDecimal newBalance = receiver.getBalance().add(dto.value());
        this.update(receiver, newBalance);

        return TransactionQueryMapper.entityToDto(newTransaction);

    }
    @Transactional
    public TransactionQueryDto withDraw (TransactionRegistrationDto dto){
        Account sender = this.getAccount(dto.numberAccountSender());
        Account receiver = this.getAccount(dto.numberAccountReceiver());

        this.validateTransaction(dto, sender);

        Transaction  newTransaction = this.saveTransaction(dto, sender, receiver);

        BigDecimal newBalance = sender.getBalance().subtract(dto.value());
        this.update(sender, newBalance);

        return TransactionQueryMapper.entityToDto(newTransaction);

    }
    @Transactional
    public TransactionQueryDto transferValue (TransactionRegistrationDto dto){
        Account sender = this.getAccount(dto.numberAccountSender());
        Account receiver = this.getAccount(dto.numberAccountReceiver());

        this.validateTransaction(dto, sender);

        Transaction  newTransaction = this.saveTransaction(dto, sender, receiver);

        BigDecimal newBalanceSender = sender.getBalance().subtract(dto.value());
        BigDecimal newBalanceReceiver = receiver.getBalance().add(dto.value());
        this.update(receiver, newBalanceReceiver);
        this.update(sender, newBalanceSender);

        return TransactionQueryMapper.entityToDto(newTransaction);

    }

    private void update(Account account, BigDecimal value){
        Account updatedAccount = new Account(
                account.getId(),
                account.getNumber(),
                value,
                account.getCustomer());
        accountRepository.save(updatedAccount);
    }

    private Account getAccount(int accountNumber) {
        return accountRepository.findByNumber(accountNumber)
                .orElseThrow(() -> new NotFoundResourceException("Account not found"));
    }

    private void validateTransaction(TransactionRegistrationDto dto, Account sender) {
        if (dto.value().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BusinessRuleException("Value must be greater than zero");
        }
        if(dto.value().compareTo(sender.getBalance()) > 0){
            throw new BusinessRuleException("Insufficient funds");
        }
    }

    private Transaction saveTransaction(TransactionRegistrationDto dto, Account sender, Account receiver) {
        Transaction newTransaction = transactionRespository.save(
                TransactionRegistrationMapper.dtoToEntity(dto, sender, receiver));
        return newTransaction;
    }


}
