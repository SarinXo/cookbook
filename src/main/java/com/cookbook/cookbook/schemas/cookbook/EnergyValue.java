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
    private Long id;

    private Integer calories;

    private Integer proteins;

    private Integer fat;

    private Integer carbohydrate;

    @OneToMany(mappedBy = "energyValueId", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Receipt> receipts = new ArrayList<>();
}
