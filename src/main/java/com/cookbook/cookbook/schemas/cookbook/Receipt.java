package com.cookbook.cookbook.schemas.cookbook;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "receipt_tab")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "shortDescription")
    private String shortDescription;

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

    @Column(name = "cookTime")
    private String cookTime;

    @Column(name = "portions")
    private String portions;

    @Column(name = "authorId")
    private String authorId;

    @Column(name = "categoryId")
    private Integer categoryId;

    @Column(name = "energyValueId")
    private Integer energyValueId;

}
