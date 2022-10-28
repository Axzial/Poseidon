package com.nnk.springboot.service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.exception.UserNotFound;
import com.nnk.springboot.repositories.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService extends CrudService<User, Long> implements UserDetailsService {

    @Getter
    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return repository.findByUsername(s).orElseThrow(UserNotFound::new);
    }

    public void saveDefaults() {
        if (repository.findByUsername("axzial").isEmpty()) {
            repository.save(User.builder()
                    .username("axzial")
                    .fullname("Victor")
                    .password(passwordEncoder.encode("12345678"))
                    .role("ADMIN")
                    .build());
        }
    }

}
