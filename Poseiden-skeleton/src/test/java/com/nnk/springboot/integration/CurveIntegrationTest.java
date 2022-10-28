package com.nnk.springboot.integration;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.security.utils.JwtUtils;
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
public class CurveIntegrationTest extends IntegrationTest {

    @Autowired
    UserRepository userService;

    private String token;

    @BeforeEach
    public void beforeEach() {
        User user = User.builder()
                .username("axzial")
                .fullname("Victor")
                .password(new BCryptPasswordEncoder().encode("12345678"))
                .role("ADMIN")
                .build();
        System.out.println(user);
        userService.save(user);
        token = JwtUtils.generateToken(user);
    }

    @Test
    public void getCurvesTest() {
        testStatus(HttpMethod.GET, URI.create("http://localhost:8080/curvePoint/list"), token, HttpStatus.OK);
    }

}
