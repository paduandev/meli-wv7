package br.dh.meli.storage02.controller;

import br.dh.meli.storage02.model.Author;
import br.dh.meli.storage02.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService service;

    @PostMapping
    ResponseEntity<Author> insert(@RequestBody Author author) {
        Author newAuthor = service.insert(author);
        return ResponseEntity.ok(newAuthor);
    }

}
