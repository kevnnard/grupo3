package com.misionticg9.account_ms.controllers;

import com.misionticg9.account_ms.exceptions.AccountNotFoundException;
import com.misionticg9.account_ms.exceptions.InsufficientBalanceException;
import com.misionticg9.account_ms.models.Account;
import com.misionticg9.account_ms.models.Transaction;
import com.misionticg9.account_ms.repositories.AccountRepository;
import com.misionticg9.account_ms.repositories.TransactionRepository;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class TransactionController {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public TransactionController(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @PostMapping("/transactions")
    Transaction newTransaction(@RequestBody Transaction transaction){
        Account accountOrigin = accountRepository.findById(transaction.getUsernameOrigin()).orElse(null);
        Account accountDestiny = accountRepository.findById(transaction.getUsernameDestiny()).orElse(null);

        if(accountOrigin == null){
            throw new AccountNotFoundException("No sé encontró al usuario origen: "+transaction.getUsernameOrigin());
        }
        if(accountDestiny == null){
            throw new AccountNotFoundException("No sé encontró al usuario destino: "+transaction.getUsernameDestiny());
        }

        if(accountOrigin.getBalance()<transaction.getValue()){
            throw new InsufficientBalanceException("Saldo Insuficiente");
        }

        accountOrigin.setBalance(accountOrigin.getBalance()-transaction.getValue());
        accountOrigin.setLastChange(new Date());
        accountRepository.save(accountOrigin);

        accountDestiny.setBalance(accountDestiny.getBalance()+transaction.getValue());
        accountDestiny.setLastChange(new Date());
        accountRepository.save(accountDestiny);

        transaction.setDate(new Date());
        return transactionRepository.save(transaction);
    }
    @GetMapping("transactions/{username}")
    List<Transaction> userTransaction(@PathVariable String username){
        Account account = accountRepository.findById(username).orElse(null);
        if (account == null){
            throw new AccountNotFoundException("No se encontró al usuario: "+username);
        }
        List <Transaction> Origin = transactionRepository.findByUsernameOrigin(username);
        List <Transaction> Destiny = transactionRepository.findByUsernameDestiny(username);

        List<Transaction> transactions = Stream.concat(Origin.stream(),Destiny.stream()).collect(Collectors.toList());

        return transactions;
    }
}