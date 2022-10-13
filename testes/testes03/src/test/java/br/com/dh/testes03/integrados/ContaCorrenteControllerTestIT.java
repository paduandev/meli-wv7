package br.com.dh.testes03.integrados;

import br.com.dh.testes03.dao.ContaDAO;
import br.com.dh.testes03.modelo.ContaCorrente;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Log4j2
@SpringBootTest
@AutoConfigureMockMvc
public class ContaCorrenteControllerTestIT {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ContaDAO contaDAO;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        contaDAO.deleteAll();
        log.info("Contas: " + contaDAO.listarTodasContas().size());
    }

    @Test
    void novaContaCorrente_ReturnContaCorrente_quandoCriarComSucesso() throws Exception {
        String nomeCliente = "Cliente 1";

        ResultActions resposta = mockMvc.perform(
                post("/cc/{cliente}", nomeCliente)
                        .contentType(MediaType.APPLICATION_JSON) );

        resposta.andExpect(status().isCreated())
                .andExpect(jsonPath("$.cliente", CoreMatchers.is(nomeCliente)))
                .andExpect(jsonPath("$.saldo", CoreMatchers.is(0.0)));

        assertThat(contaDAO.listarTodasContas().size()).isEqualTo(1);
        assertThat(contaDAO.listarTodasContas().get(0)).isNotNull();
        log.info(contaDAO.listarTodasContas().get(0));
        ContaCorrente cc = objectMapper.readValue(resposta.andReturn().getResponse().getContentAsString(),
                ContaCorrente.class);
        log.info(cc);
    }

    @Test
    void getContaCorrente_returnContaCorrente_quantoContaExiste() throws Exception {
        ContaCorrente contaCorrente = contaDAO.novaContaCorrente("Cliente 1");

        ResultActions resposta = mockMvc.perform(
                get("/cc/{numero}", contaCorrente.getNumero())
                        .contentType(MediaType.APPLICATION_JSON) );

        resposta.andExpect(status().isOk())
                .andExpect(jsonPath("$.cliente", CoreMatchers.is(contaCorrente.getCliente())))
                .andExpect(jsonPath("$.numero", CoreMatchers.is(contaCorrente.getNumero())));
    }

    @Test
    void depositar_returnContaCorrenteAtualizada_quandoDepositarComSucesso() throws Exception {
        ContaCorrente contaCorrente = contaDAO.novaContaCorrente("Cliente 1");
        double valorDeposito = 100;

        ResultActions resposta = mockMvc.perform(
                patch("/cc/dep/{numero}/{valor}", contaCorrente.getNumero(), valorDeposito)
                        .contentType(MediaType.APPLICATION_JSON));

        resposta.andExpect(status().isOk())
                .andExpect(jsonPath("$.cliente", CoreMatchers.is(contaCorrente.getCliente())))
                .andExpect(jsonPath("$.saldo", CoreMatchers.is(valorDeposito)));

        assertThat(contaDAO.getContaCorrente(contaCorrente.getNumero()).getSaldo())
                .isEqualTo(valorDeposito);
    }

}

