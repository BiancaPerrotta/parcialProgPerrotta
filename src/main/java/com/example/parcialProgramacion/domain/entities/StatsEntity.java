package com.example.parcialProgramacion.domain.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class StatsEntity extends BaseEntity {

    private Integer countMutantDNA = 0;
    private Integer countHumanDNA = 0;
    private Double ratio = 0.0;


}
