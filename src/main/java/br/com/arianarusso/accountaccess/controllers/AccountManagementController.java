package br.com.arianarusso.accountaccess.controllers;

import br.com.arianarusso.accountaccess.dtos.AccountRegistrationDto;
import br.com.arianarusso.accountaccess.services.AccountManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountManagementController {

    @Autowired
    private AccountManagementService service;

    @DeleteMapping("/{accountNumber}")
    public ResponseEntity closeAccount (@PathVariable int accountNumber){
        service.closeAccount(accountNumber);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity openAccount (@RequestBody AccountRegistrationDto dto){
        service.createAccount(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
