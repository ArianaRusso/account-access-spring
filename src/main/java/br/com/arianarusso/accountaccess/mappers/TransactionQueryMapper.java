package br.com.arianarusso.accountaccess.mappers;

import br.com.arianarusso.accountaccess.dtos.TransactionQueryDto;
import br.com.arianarusso.accountaccess.dtos.TransactionRegistrationDto;
import br.com.arianarusso.accountaccess.entities.Account;
import br.com.arianarusso.accountaccess.entities.Transaction;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionQueryMapper {
    public static TransactionQueryDto entityToDto(Transaction transaction) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String dateFormatted = dateFormat.format(date);
        return  new TransactionQueryDto(
                transaction.getId(),
                transaction.getSender().getNumber(),
                transaction.getReceiver().getNumber(),
                transaction.getAmount(),dateFormatted
                );
    }

    }

