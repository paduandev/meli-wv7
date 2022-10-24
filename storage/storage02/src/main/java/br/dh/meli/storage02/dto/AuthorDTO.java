package br.dh.meli.storage02.dto;

import br.dh.meli.storage02.model.Author;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorDTO {
    private String name;
    private AddressDTO addressDTO;

    public AuthorDTO(Author author) {
        this.name = author.getName();
        this.addressDTO = new AddressDTO(author.getAddress());
    }

}
