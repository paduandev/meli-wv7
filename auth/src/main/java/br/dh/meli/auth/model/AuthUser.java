package br.dh.meli.auth.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthUser {
    @NotNull
    @Length(min = 5, max = 50)
    private String username;

    @NotNull @Length(min = 5, max = 20)
    private String password;
}
