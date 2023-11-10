package br.com.arianarusso.accountaccess.controllers;

import br.com.arianarusso.accountaccess.dtos.TransactionRegistrationDto;
import br.com.arianarusso.accountaccess.entities.Transaction;
import br.com.arianarusso.accountaccess.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/check-balance/{accountNumber}")
    public ResponseEntity checkAccountBalance(@PathVariable int accountNumber){
        return ResponseEntity.status(HttpStatus.OK)
                .body(transactionService.checkAccountBalance(accountNumber));
    }

    @PostMapping("/pay-in")
    public ResponseEntity payIn (@RequestBody TransactionRegistrationDto transaction){
        return ResponseEntity.status(HttpStatus.OK)
                .body(transactionService.payIn(transaction));
    }

    @PostMapping("/with-draw")
    public ResponseEntity withDraw (@RequestBody TransactionRegistrationDto transaction){
        return ResponseEntity.status(HttpStatus.OK)
                .body(transactionService.withDraw(transaction));
    }

    @PostMapping("/transfer")
    public ResponseEntity transferValue (@RequestBody TransactionRegistrationDto transaction){
        return ResponseEntity.status(HttpStatus.OK)
                .body(transactionService.transferValue(transaction));
    }




}
