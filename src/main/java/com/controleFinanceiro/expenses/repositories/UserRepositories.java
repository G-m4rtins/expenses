package com.controleFinanceiro.expenses.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.controleFinanceiro.expenses.models.User;

public interface UserRepositories extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

}
