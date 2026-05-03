package com.controleFinanceiro.expenses.Controllers.Transaction;


import com.controleFinanceiro.expenses.models.Transaction;
import com.controleFinanceiro.expenses.services.Transaction.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> create(@RequestBody Transaction transaction){

        Transaction created = transactionService.create(transaction);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(created);
    }
}
