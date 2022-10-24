package br.dh.meli.storage02.service;

import br.dh.meli.storage02.dto.AuthorDTO;
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
        author.getAddress().setAuthor(author);
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

    @Override
    public void delete(long id) {
        repo.deleteById(id);
    }

    @Override
    public AuthorDTO getById(long id) {
        return repo.getById(id);
    }

    @Override
    public Author getNAtiveById(long id) {
        return repo.getNativeById(id);
    }

    @Override
    public AuthorDTO getDtoEagle(long id) {
        return repo.getDtoEagle(id);
    }


}
