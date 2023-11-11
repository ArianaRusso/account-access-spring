package br.com.arianarusso.accountaccess.dtos.erros;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class CauseErrorDto{
    private String field;
    private String value;

    public CauseErrorDto() {

    }

    public CauseErrorDto(String field, String value) {
        this.field = field;
        this.value = value;
    }

}
