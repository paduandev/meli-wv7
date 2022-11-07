package br.dh.meli.auth.controller;

import br.dh.meli.auth.model.Product;
import br.dh.meli.auth.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<Product> newProduct(@RequestBody Product product) {
        Product newProduct = service.create(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Optional<Product> optionalProduct = service.findById(id);
        if(optionalProduct.isPresent()) {
            return new ResponseEntity<>(optionalProduct.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<Product> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id ) {
        service.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
