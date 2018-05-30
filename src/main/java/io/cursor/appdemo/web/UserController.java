package io.cursor.appdemo.web;

import io.cursor.appdemo.model.User;
import io.cursor.appdemo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@RestController
@Slf4j
public class UserController {

    private final UserRepository repository;

    @Autowired
    UserController (UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public void saveUser() {

        try (Scanner scanner = new Scanner(System.in)) {

            log.info("Input name and email");

            String name = scanner.next();
            String email = scanner.next();
            User user = new User();
            user.setUsername(name);
            user.setEmail(email);
            repository.save(user);
        }
    }
}
