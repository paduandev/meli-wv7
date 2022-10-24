package br.dh.meli.storage02.service;

import br.dh.meli.storage02.model.Book;

public interface IBookService {
    Book findById(long id);

    void delete(long id);
}
