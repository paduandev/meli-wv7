package br.dh.meli.tutoriais.repository;

import br.dh.meli.tutoriais.model.Status;
import br.dh.meli.tutoriais.model.Tutorial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@DataJpaTest
public class TutorialRepoTest {

    @Autowired
    private TutorialRepo repo;

    @BeforeEach
    public void setup() {
        repo.deleteAll();
    }

    @Test
    public void save_returnTutorial_whenTutorialIsValid() {
        Tutorial newTutorial = new Tutorial(null, "Titulo 1", "Descrição 1", null);

        Tutorial tutorialSaved = repo.save(newTutorial);

        assertThat(tutorialSaved).isNotNull();
        assertThat(tutorialSaved.getId()).isPositive();
        assertThat(tutorialSaved.getStatus()).isEqualTo(Status.DRAFT);
        assertThat(tutorialSaved.getTitle()).isEqualTo(newTutorial.getTitle());
    }

}
