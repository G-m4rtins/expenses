package com.controleFinanceiro.expenses.services.Transaction;

import com.controleFinanceiro.expenses.models.Account;
import com.controleFinanceiro.expenses.models.Transaction;
import com.controleFinanceiro.expenses.models.enums.TransactionType;
import com.controleFinanceiro.expenses.repositories.AccountRepository;
import com.controleFinanceiro.expenses.repositories.TransactionRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public Transaction create(Transaction transaction){

        Account account = accountRepository.findById(
                transaction.getAccount().getId()
        ).orElseThrow(() -> new IllegalArgumentException("Account not found"));

        BigDecimal currentBalance = account.getBalance();
        BigDecimal amount = transaction.getAmount();

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        }

        if(transaction.getType().equals(TransactionType.EXPENSE)){

            if (currentBalance.compareTo(amount) < 0){
                throw new IllegalArgumentException("Insufficient balance");
            }

            currentBalance = currentBalance.subtract(amount);
        }

        if (transaction.getType().equals(TransactionType.INCOME)){
            currentBalance = currentBalance.add(amount);
        }


        account.setBalance(currentBalance);
        accountRepository.save(account);

        transaction.setAccount(account);

        return transactionRepository.save(transaction);
    }



}
