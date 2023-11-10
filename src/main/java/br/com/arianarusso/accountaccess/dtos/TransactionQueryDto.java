package br.com.arianarusso.accountaccess.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionQueryDto(
        UUID id,
        int numberAccountSender,
        int numberAccountReceiver,
        BigDecimal value,
        String dateQuery
){

}
