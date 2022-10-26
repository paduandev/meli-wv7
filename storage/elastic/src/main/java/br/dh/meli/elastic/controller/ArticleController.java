package br.dh.meli.elastic.controller;

import br.dh.meli.elastic.model.Article;
import br.dh.meli.elastic.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private IArticleService service;

    @PostMapping
    public Article insert(@RequestBody Article article) {
        Article newArticle = service.save(article);
        return newArticle;
    }
}
