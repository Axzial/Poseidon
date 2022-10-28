package com.nnk.springboot.integration;

import com.nnk.springboot.config.security.utils.JwtUtils;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.URI;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class RuleNameIntegrationTest extends IntegrationTest {

    @Autowired
    private UserRepository userService;

    private String token;

    @BeforeEach
    public void beforeEach() {
        User user = User.builder()
                .username("axzial")
                .fullname("Victor")
                .password(new BCryptPasswordEncoder().encode("12345678"))
                .role("ADMIN")
                .build();
        userService.save(user);
        token = JwtUtils.generateToken(user);
    }

    @Test
    public void getBidListTest() {
        testStatus(HttpMethod.GET, URI.create("http://localhost:8080/api/ruleName"), token, HttpStatus.FOUND);
    }

}
