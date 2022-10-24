package br.dh.meli.storage02.service;

import br.dh.meli.storage02.model.Author;
import br.dh.meli.storage02.repository.AuthorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService implements IAuthorService {

    private final AuthorRepo repo;

    @Override
    public Author insert(Author author) {
        return repo.save(author);
    }
}
