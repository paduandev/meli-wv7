package br.dh.meli.storage02.dto;

import br.dh.meli.storage02.model.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressDTO {
    private String location;

    public AddressDTO(Address address) {
        this.location = address.getLocation();
    }
}
