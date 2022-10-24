package br.dh.meli.storage02.repository;

import br.dh.meli.storage02.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
}
