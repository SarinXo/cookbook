package com.cookbook.cookbook.schemas.cookbook;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Long id;

    private String name;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "photo")
    private String photo;

    private String ingredients;

    private String receipt;

    private Double rating;

    private Boolean editable;

    @Column(name = "cook_time")
    private String cookTime;

    private String portions;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author authorId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category categoryId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "energy_value_id")
    private EnergyValue energyValueId;


}
