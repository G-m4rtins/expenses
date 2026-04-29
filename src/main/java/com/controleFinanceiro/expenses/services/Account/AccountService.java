package com.controleFinanceiro.expenses.services.Account;

import com.controleFinanceiro.expenses.models.Account;
import com.controleFinanceiro.expenses.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account create(Account account) {
        return accountRepository.save(account);
    }

    public Account update(Long id, Account account) {
        Account existing = findById(id);

        existing.setName(account.getName());
        existing.setBalance(account.getBalance());

        return accountRepository.save(existing);
    }

    public void delete(Long id) {
        validateAccount(id);
        accountRepository.deleteById(id);
    }

    public BigDecimal getBalance(Long id) {
        return findById(id).getBalance();
    }

    public Account findById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
    }

    private void validateAccount(Long id) {
        if (!accountRepository.existsById(id)) {
            throw new IllegalArgumentException("Account not found");
        }
    }
}