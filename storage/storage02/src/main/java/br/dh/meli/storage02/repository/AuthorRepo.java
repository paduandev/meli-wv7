package br.dh.meli.storage02.repository;

import br.dh.meli.storage02.dto.AuthorDTO;
import br.dh.meli.storage02.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepo extends JpaRepository<Author, Long> {
    @Query("select a from Author a where a.id = ?1")
    AuthorDTO getById(long id);

    @Query(value = "select * from author where id = ?1", nativeQuery = true)
    Author getNativeById(long id);

    @Query("select a from Author a left join a.address where a.id = :id")
    AuthorDTO getDtoEagle(long id);
}
