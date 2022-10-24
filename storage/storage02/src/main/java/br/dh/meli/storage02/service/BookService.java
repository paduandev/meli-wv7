package br.dh.meli.storage02.service;

import br.dh.meli.storage02.model.Book;
import br.dh.meli.storage02.repository.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService implements IBookService {

    private final BookRepo repo;

    @Override
    public Book findById(long id) {
/*        Optional<Book> optionalBook = repo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        }
        return null;*/

        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        repo.deleteById(id);
    }
}
