package br.com.arianarusso.accountaccess.exceptions;

import br.com.arianarusso.accountaccess.dtos.erros.CauseErrorDto;
import lombok.Getter;

@Getter
public class BusinessRuleException extends RuntimeException {
    private String message;
    private CauseErrorDto cause;

    public BusinessRuleException(String message) {
        super(message);
        this.message = message;
    }

    public BusinessRuleException(String message, CauseErrorDto cause) {
        super();
        this.message = message;
        this.cause = cause;

    }
}
