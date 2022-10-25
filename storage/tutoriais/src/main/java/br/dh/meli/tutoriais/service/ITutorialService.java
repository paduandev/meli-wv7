package br.dh.meli.tutoriais.service;

import br.dh.meli.tutoriais.model.Tutorial;

import java.util.List;
import java.util.Optional;

public interface ITutorialService {
    Tutorial insert(Tutorial tutorial);
    List<Tutorial> getAll();
    Optional<Tutorial> getById(Long id);
    Tutorial update(Tutorial tutorial);
    void deleteAll();
    void deleteById(Long id);
    List<Tutorial> getPublished();
    List<Tutorial> getByTitle(String title);
}
