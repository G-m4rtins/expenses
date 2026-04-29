package com.controleFinanceiro.expenses.Controllers.Account;

import com.controleFinanceiro.expenses.models.Account;
import com.controleFinanceiro.expenses.models.User;
import com.controleFinanceiro.expenses.services.Account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Account")
@RequiredArgsConstructor
class AccountController {

    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> findAll() {
        return ResponseEntity.ok(accountService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> findById(@PathVariable Long id) {
        Account account = accountService.findById(id);
        return ResponseEntity.ok(account);
    }

    @GetMapping("/balance/{id}")
    public ResponseEntity<String> getBalance(@PathVariable Long id) {
        String balance = accountService.getBalance(id).toString();
        return ResponseEntity.ok(balance);
    }

    @PostMapping
    public ResponseEntity<Account> create(Account account) {
        Account createdAccount = accountService.create(account);
        return ResponseEntity.ok(createdAccount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> update(
            @PathVariable Long id,
            @RequestBody Account account) {
        Account updatedAccount = accountService.update(id, account);
        return ResponseEntity.ok(updatedAccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
