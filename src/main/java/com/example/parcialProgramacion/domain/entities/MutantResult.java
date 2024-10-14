package com.example.parcialProgramacion.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class MutantResult {

    Boolean isADnaMutant;
    int countDnaMutant;
    int countDnaHuman;


}
