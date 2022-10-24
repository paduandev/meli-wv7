package br.dh.meli.storage02.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false) // nome é obrigatorio
    private String name;

    @OneToOne(mappedBy = "author", cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("author")
    private Address address;

    @ManyToMany
    @JoinTable(
            name = "author_books",
            joinColumns = @JoinColumn(name = "id_author", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_book", referencedColumnName = "id")
    )
    @JsonIgnoreProperties("authors")
    private Set<Book> books;
}
