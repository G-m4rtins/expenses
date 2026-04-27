package com.controleFinanceiro.expenses.services.Users;
import java.util.List;

import org.springframework.stereotype.Service;

import com.controleFinanceiro.expenses.models.User;
import com.controleFinanceiro.expenses.repositories.UserRepositories;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepositories userRepositories;

    public User Create(User user) {
        if (userRepositories.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        return userRepositories.save(user);
    }

    public List<User> findAll() {
        return userRepositories.findAll();
    }

    public User findById(Long id) {
        return userRepositories.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public User Update(User user) {
        if (!userRepositories.existsById(user.getId())) {
            throw new IllegalArgumentException("User not found");
        }
        return userRepositories.save(user);
    }

    public void Delete(Long id) {
        if (!userRepositories.existsById(id)) {
            throw new IllegalArgumentException("User not found");
        }
        userRepositories.deleteById(id);
    }

}
