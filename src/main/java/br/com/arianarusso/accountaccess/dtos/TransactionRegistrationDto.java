package br.com.arianarusso.accountaccess.dtos;

import java.math.BigDecimal;

public record TransactionRegistrationDto(
    int numberAccountSender,
    int numberAccountReceiver,
    BigDecimal value
){}
