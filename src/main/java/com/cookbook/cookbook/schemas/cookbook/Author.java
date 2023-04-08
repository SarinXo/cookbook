package com.cookbook.cookbook.schemas.cookbook;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "author_tab")
public class Author {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @OneToMany(mappedBy = "authorId", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Receipt> receipts = new ArrayList<>();

}
