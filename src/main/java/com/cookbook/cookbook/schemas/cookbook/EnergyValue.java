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
@Table(name = "Energy_Value_Tab")
public class EnergyValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "calories")
    private int calories;

    @Column(name = "proteins")
    private int proteins;

    @Column(name = "fat")
    private int fat;

    @Column(name = "carbohydrate")
    private int carbohydrate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "energy_value_id")
    private List<Receipt> receipt = new ArrayList<>();

}
