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
@Table(name = "Author_Tab")
public class Author {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "author_id")
    private List<Receipt> receipt = new ArrayList<>();

}
