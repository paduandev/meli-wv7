package br.dh.meli.tutoriais.controller;

import br.dh.meli.tutoriais.model.Status;
import br.dh.meli.tutoriais.model.Tutorial;
import br.dh.meli.tutoriais.service.TutorialService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TutorialController.class)
class TutorialControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TutorialService service;

    @Test
    void insert_returnNewTutorial_whenTutorialIsValid() throws Exception {
        BDDMockito.when(service.insert(ArgumentMatchers.any(Tutorial.class)))
                .thenReturn(new Tutorial(1L, "Titulo 1", "Descrição 1", Status.DRAFT));

        Tutorial tutorial = new Tutorial(null, "Titulo 1", "Descrição 1", null);

        ResultActions result = mockMvc.perform(post("/tutorial")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(tutorial)));

        result.andExpect(status().isCreated())
                .andExpect(jsonPath("$.title", CoreMatchers.is("Titulo 1")));
    }

    @Test
    void updateStatusPublished() {
    }

    @Test
    void getByTitle() {
    }

    @Test
    void getPublished() {
    }
}