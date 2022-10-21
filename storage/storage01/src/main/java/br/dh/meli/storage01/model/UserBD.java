package br.dh.meli.storage01.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity // indica que esta classe será persistidano BD
@Table(name = "tb_user") // nome dado à tabela no BD (opcional)
public class UserBD {

    @Id // indica que o campo é PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera automatico no BD 1, 2, 3, ...
    private long cod;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(name = "e_mail", length = 100, unique = true)
    private String email;
}
