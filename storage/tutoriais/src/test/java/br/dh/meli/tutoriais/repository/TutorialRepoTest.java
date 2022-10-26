package br.dh.meli.tutoriais.repository;

import br.dh.meli.tutoriais.model.Status;
import br.dh.meli.tutoriais.model.Tutorial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TutorialRepoTest {

    @Autowired
    private TutorialRepo repo;

    @BeforeEach
    public void setup() {
        repo.deleteAll();
    }

    @Test
    public void save_returnTutorial_whenTutorialIsValid() {
        Tutorial newTutorial = new Tutorial(null, "Titulo 1", "Descrição 1", Status.DRAFT);

        Tutorial tutorialSaved = repo.save(newTutorial);

        assertThat(tutorialSaved).isNotNull();
        assertThat(tutorialSaved.getId()).isPositive();
        assertThat(tutorialSaved.getStatus()).isEqualTo(Status.DRAFT);
        assertThat(tutorialSaved.getTitle()).isEqualTo(newTutorial.getTitle());
    }

    @Test
    public void findById_returnTutorial_whenIdTutorialExist() {
        Tutorial newTutorial = new Tutorial(null, "Titulo 1", "Descrição 1", Status.DRAFT);
        Tutorial tutorialSaved = repo.save(newTutorial);

        Optional<Tutorial> tutorialOptional = repo.findById(tutorialSaved.getId());

        assertThat(tutorialOptional.isPresent()).isTrue();
        assertThat(tutorialOptional.get().getId()).isPositive();
        assertThat(tutorialOptional.get().getStatus()).isEqualTo(Status.DRAFT);
        assertThat(tutorialSaved.getTitle()).isEqualTo(newTutorial.getTitle());
    }

    @Test
    public void findById_returnOptionalEmpty_whenIdTutorialNotExist() {
        Optional<Tutorial> tutorialOptional = repo.findById(1L);

        assertThat(tutorialOptional.isEmpty()).isTrue();
    }

    @Test
    public void findByStatus_returnListTutorial_whenStatusExist() {
        Tutorial newTutorial = new Tutorial(null, "Titulo 1", "Descrição 1", Status.DRAFT);
        Tutorial tutorialSaved = repo.save(newTutorial);

        List<Tutorial> tutorials = repo.findByStatus(Status.DRAFT);

        assertThat(tutorials.size()).isEqualTo(1);
        assertThat(tutorials.get(0).getId()).isEqualTo(tutorialSaved.getId());
    }

    @Test
    public void findByStatus_returnEmptyList_whenStatusNotExist() {
        List<Tutorial> tutorials = repo.findByStatus(Status.DRAFT);

        assertThat(tutorials.size()).isEqualTo(0);
    }

    @Test
    public void findByStatus_returnEmptyList_whenStatusDiferent() {
        Tutorial newTutorial = new Tutorial(null, "Titulo 1", "Descrição 1", Status.DRAFT);
        Tutorial tutorialSaved = repo.save(newTutorial);
        List<Tutorial> tutorials = repo.findByStatus(Status.PUBLISHED);

        assertThat(tutorials.size()).isEqualTo(0);
    }

}
