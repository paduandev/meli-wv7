package br.dh.meli.auth.repository;

import br.dh.meli.auth.model.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApiUserRepo extends JpaRepository<ApiUser, String> {
    Optional<ApiUser> findUserByUsername(String username);
    Optional<ApiUser> findUserByUsernameAndPassword(String username, String password);
    Boolean existsByUsername(String username);
}
