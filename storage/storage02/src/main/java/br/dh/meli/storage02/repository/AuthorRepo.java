package br.dh.meli.storage02.repository;

import br.dh.meli.storage02.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Long> {
}
