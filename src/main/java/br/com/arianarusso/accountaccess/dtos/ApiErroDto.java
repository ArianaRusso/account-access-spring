package br.com.arianarusso.accountaccess.dtos;

import org.springframework.http.HttpStatus;

public class ApiErroDto {
    private String mensagem;
    private HttpStatus status;
}
