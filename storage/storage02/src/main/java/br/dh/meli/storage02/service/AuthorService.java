package br.dh.meli.storage02.service;

import br.dh.meli.storage02.model.Author;
import br.dh.meli.storage02.repository.AuthorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService implements IAuthorService {

    private final AuthorRepo repo;

    @Override
    public Author insert(Author author) {
        return repo.save(author);
    }

    @Override
    public Author findById(long id) {
        Optional<Author> optionalAuthor = repo.findById(id);
        if(optionalAuthor.isPresent()) {
            return optionalAuthor.get();
        }
        return null;
    }
}
