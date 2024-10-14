package com.example.parcialProgramacion.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class StatsAllDto {

    private Integer countMutantDNA;
    private Integer countHumanDNA;
    private Double ratio;

}
