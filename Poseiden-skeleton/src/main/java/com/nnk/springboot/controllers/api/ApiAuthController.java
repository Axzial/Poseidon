package com.nnk.springboot.controllers.api;

import com.nnk.springboot.config.security.utils.JwtUtils;
import com.nnk.springboot.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class ApiAuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public TokenDTO login(@RequestBody LoginDTO loginDTO) {
        var user = userService.loadUserByUsername(loginDTO.getUsername());
        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) throw new SecurityException();
        return new TokenDTO(JwtUtils.generateToken(user));
    }

    public TokenDTO regiser(@RequestBody RegisterDTO registerDTO) {
        var user = userService.loadUserByUsername(registerDTO.getUsername());
        if (!passwordEncoder.matches(registerDTO.getPassword(), user.getPassword())) throw new SecurityException();
        return new TokenDTO(JwtUtils.generateToken(user));
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class LoginDTO {
        @NotBlank
        @NotNull
        String username;
        @NotBlank
        @NotNull
        String password;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class TokenDTO {
        String token;
    }

    private static class RegisterDTO extends LoginDTO {

    }
}
