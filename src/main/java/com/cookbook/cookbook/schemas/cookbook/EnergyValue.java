package com.cookbook.cookbook.schemas.cookbook;




import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "energy_value_tab")
public class EnergyValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "calories")
    private Integer calories;

    @Column(name = "proteins")
    private Integer proteins;

    @Column(name = "fat")
    private Integer fat;

    @Column(name = "carbohydrate")
    private Integer carbohydrate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "energyValueId")
    private List<Receipt> receipt = new ArrayList<>();

}
