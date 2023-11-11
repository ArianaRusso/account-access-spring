package br.com.arianarusso.accountaccess.exceptions;
import br.com.arianarusso.accountaccess.dtos.erros.CauseErrorDto;
import lombok.Getter;

@Getter
public class NotFoundResourceException extends RuntimeException {
    private String message;
    private CauseErrorDto cause;

    public NotFoundResourceException(String message) {
        super(message);
        this.message = message;
    }

    public NotFoundResourceException(String message, CauseErrorDto cause) {
        super();
        this.message = message;
        this.cause = cause;

    }
}