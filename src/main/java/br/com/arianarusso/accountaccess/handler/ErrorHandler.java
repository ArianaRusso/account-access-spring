package br.com.arianarusso.accountaccess.handler;

import br.com.arianarusso.accountaccess.dtos.erros.ApiErrorDto;
import br.com.arianarusso.accountaccess.dtos.erros.CauseErrorDto;
import br.com.arianarusso.accountaccess.exceptions.BusinessRuleException;
import br.com.arianarusso.accountaccess.exceptions.NotFoundResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpHeaders;

import java.util.List;

@RestControllerAdvice
public class ErrorHandler {

    public ResponseEntity<ApiErrorDto> checkReturnWithAndWithoutCause(CauseErrorDto cause, String message, HttpStatus status) {
        if (cause == null) {
            ApiErrorDto apiError = new ApiErrorDto(message, status);
            return new ResponseEntity<>(apiError, new HttpHeaders(), status);
        }

        ApiErrorDto apiError = new ApiErrorDto(message, status, List.of(cause));
        return new ResponseEntity<>(apiError, new HttpHeaders(), status);
    }

    @ExceptionHandler({BusinessRuleException.class})
    public ResponseEntity<ApiErrorDto> buninessRuleExceptionError400(BusinessRuleException ex){
        return checkReturnWithAndWithoutCause(ex.getCause(), ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NotFoundResourceException.class})
    public ResponseEntity<ApiErrorDto> notFoundResourceExceptionError404(NotFoundResourceException ex){
        return checkReturnWithAndWithoutCause(ex.getCause(), ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
