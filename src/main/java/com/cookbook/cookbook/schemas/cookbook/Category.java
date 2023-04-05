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
@Table(name = "category_tab")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    //@OneToMany(mappedBy = "categoryId", cascade = CascadeType.ALL,
    //        fetch = FetchType.LAZY)
    //private List<Receipt> category = new ArrayList<>();
}
