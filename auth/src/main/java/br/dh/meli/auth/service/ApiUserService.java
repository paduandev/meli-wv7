package br.dh.meli.auth.service;

import br.dh.meli.auth.model.ApiUser;
import br.dh.meli.auth.model.AuthUser;
import br.dh.meli.auth.repository.ApiUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Optional;

@Service
public class ApiUserService {

    @Autowired
    private ApiUserRepo repo;

    public ApiUser saveUser(AuthUser authUser) {
        if (repo.existsByUsername(authUser.getUsername())) {
            throw new InvalidParameterException("This username has already been registered");
        }
        ApiUser apiUser = new ApiUser();
        apiUser.setUsername(authUser.getUsername());
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        apiUser.setPassword(passwordEncoder.encode(authUser.getPassword()).substring(8));
        apiUser.setAuthorities("USER");
        ApiUser savedUser = repo.save(apiUser);
        return savedUser;
    }

    public Optional<ApiUser> findUserByUsernameAndPassword(String username, String password) {
        return repo.findUserByUsernameAndPassword(username, password);
    }
}
