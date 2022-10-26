package br.dh.meli.elastic.service;

import br.dh.meli.elastic.model.Article;

import java.util.List;
import java.util.Optional;

public interface IArticleService {
    Article save(Article article);
    List<Article> findAll();
    Optional<Article> findById(int id);
    void delete(int id);
    Article update(Article article);
}
