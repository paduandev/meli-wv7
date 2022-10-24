package br.dh.meli.storage02.controller;

import br.dh.meli.storage02.dto.AuthorDTO;
import br.dh.meli.storage02.model.Author;
import br.dh.meli.storage02.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable long id) {
        Author author = service.findById(id);
        if(author != null) {
            return ResponseEntity.ok(author);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<AuthorDTO> getById(@PathVariable long id) {
        AuthorDTO author = service.getById(id);
        if(author != null) {
            return ResponseEntity.ok(author);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/native/{id}")
    public ResponseEntity<Author> getNativeById(@PathVariable long id) {
        Author author = service.getNAtiveById(id);
        if(author != null) {
            return ResponseEntity.ok(author);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/dtoeagle/{id}")
    public ResponseEntity<AuthorDTO> getDtoEagleById(@PathVariable long id) {
        AuthorDTO author = service.getDtoEagle(id);
        if(author != null) {
            return ResponseEntity.ok(author);
        }
        return ResponseEntity.notFound().build();
    }
}
