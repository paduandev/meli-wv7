package br.com.dh.spring02.dto;

import br.com.dh.spring02.model.Produto;
import lombok.Data;

@Data
public class ProdutoDTO {
    private String nome;
    private double valor;

    public ProdutoDTO(Produto produto) {
        this.nome = produto.getNome();
        this.valor = produto.getValor();
    }

}
