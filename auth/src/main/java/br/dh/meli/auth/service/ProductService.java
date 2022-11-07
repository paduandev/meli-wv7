package br.dh.meli.auth.service;

import br.dh.meli.auth.model.Product;
import br.dh.meli.auth.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo repo;

    public Product create(Product product) {
        return repo.save(product);
    }

    public void remove(Long id) {
        repo.deleteById(id);
    }

    public Optional<Product> findById(Long id) {
        return repo.findById(id);
    }

    public List<Product> findAll() {
        return (List<Product>) repo.findAll();
    }
}
