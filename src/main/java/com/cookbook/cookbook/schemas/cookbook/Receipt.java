package com.cookbook.cookbook.schemas.cookbook;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "photo")
    private String photo;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "receipt")
    private String receipt;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "editable")
    private Boolean editable;

    @Column(name = "cook_time")
    private String cookTime;

    @Column(name = "portions")
    private String portions;

    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "author_id")
    //private Author authorId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category categoryId;

    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "energy_value_id")
    //private EnergyValue energyValueId;


}
