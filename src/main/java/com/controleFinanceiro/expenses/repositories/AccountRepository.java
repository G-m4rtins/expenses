package com.controleFinanceiro.expenses.repositories;

import com.controleFinanceiro.expenses.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {


}
