package br.dh.meli.tutoriais.repository;

import br.dh.meli.tutoriais.model.Status;
import br.dh.meli.tutoriais.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorialRepo extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByTitleContaining(String title);
    List<Tutorial> findByStatus(Status status);
}
