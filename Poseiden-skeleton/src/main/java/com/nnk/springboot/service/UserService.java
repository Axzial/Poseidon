package com.nnk.springboot.service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.exception.UserNotFound;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.utils.OptionalUtils;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService extends CrudService<User> implements UserDetailsService {
    @Getter
    private final UserRepository repository;

    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return OptionalUtils.optionally(repository.findByUsername(s), UserNotFound.class);
    }


}
