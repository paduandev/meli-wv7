package br.dh.meli.auth.repository;

import br.dh.meli.auth.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, Long> {
}
