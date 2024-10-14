package com.example.parcialProgramacion.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class DnaEntity extends BaseEntity {

    private String[] dna;
    private Boolean isMutant;

}
