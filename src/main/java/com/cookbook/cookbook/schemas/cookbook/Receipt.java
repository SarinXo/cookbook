package com.cookbook.cookbook.schemas.cookbook;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Receipt_Tab")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "short_description")
    private String short_description;

    @Column(name = "photo")
    private String photo;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "receipt")
    private String receipt;

    @Column(name = "rating")
    private String rating;

    @Column(name = "editable")
    private String editable;

    @Column(name = "cook_time")
    private String cook_time;

    @Column(name = "portions")
    private String portions;

    @Column(name = "author_id")
    private String author_id;

    @Column(name = "category_id")
    private int category_id;

    @Column(name = "energy_value_id")
    private int energy_value_id;

}
