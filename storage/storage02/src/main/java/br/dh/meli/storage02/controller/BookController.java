package br.dh.meli.storage02.controller;

import br.dh.meli.storage02.model.Book;
import br.dh.meli.storage02.repository.BookRepo;
import br.dh.meli.storage02.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("{id}")
    public ResponseEntity<Book> findById(@PathVariable long id) {
        Book book = service.findById(id);

        if(book != null) {
            return ResponseEntity.ok(book);
        }
        return ResponseEntity.notFound().build();
    }

}
