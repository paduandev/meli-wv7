package br.dh.meli.elastic.repository;

import br.dh.meli.elastic.model.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleRepo extends ElasticsearchRepository<Article, Integer> {
}
