package br.com.arianarusso.accountaccess.dtos.erros;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CauseErrorDto {
    private String field;
    private String value;
}
