package com.controleFinanceiro.expenses.repositories;

import com.controleFinanceiro.expenses.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
