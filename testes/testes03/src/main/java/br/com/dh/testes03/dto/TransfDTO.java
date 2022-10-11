package br.com.dh.testes03.dto;

import br.com.dh.testes03.modelo.Conta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransfDTO {
    private Conta origem;
    private Conta destino;
}
