package com.controleFinanceiro.expenses.Controllers.Users;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controleFinanceiro.expenses.models.User;
import com.controleFinanceiro.expenses.services.Users.UserService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class userController {

        private final UserService userService;

        @GetMapping
        public ResponseEntity<List<User>> findAll() {
            return ResponseEntity.ok(userService.findAll());
        }

        @PostMapping
        public ResponseEntity<User> create(@RequestBody User user) {
            User createdUser = userService.Create(user);
            return ResponseEntity.ok(createdUser);
        }

        @GetMapping("/{id}")
        public ResponseEntity<User> findById(Long id) {
            User user = userService.findById(id);
            return ResponseEntity.ok(user);
        }

        @PutMapping("/{id}")
        public ResponseEntity<User> update(
                @PathVariable Long id,
                @RequestBody User user) {

            User updatedUser = userService.Update(id, user);
            return ResponseEntity.ok(updatedUser);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id) {
            userService.Delete(id);
            return ResponseEntity.noContent().build();
        }

}
