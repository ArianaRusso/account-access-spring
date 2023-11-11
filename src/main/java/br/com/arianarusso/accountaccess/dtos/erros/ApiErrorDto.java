package br.com.arianarusso.accountaccess.dtos.erros;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ApiErrorDto {
    private String message;
    private HttpStatus status;
    private List<CauseErrorDto> causes;

    public ApiErrorDto(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
    public ApiErrorDto(String message, HttpStatus status, List<CauseErrorDto> causes) {
        this.message = message;
        this.status = status;
        this.causes = causes;
    }
}
