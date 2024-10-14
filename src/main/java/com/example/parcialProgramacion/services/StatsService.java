package com.example.parcialProgramacion.services;

import com.example.parcialProgramacion.domain.dto.StatsAllDto;
import com.example.parcialProgramacion.domain.entities.StatsEntity;
import com.example.parcialProgramacion.repositories.StatsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatsService {

    private final StatsRepository statsRepository;

    public StatsService(StatsRepository statsRepository) {
        this.statsRepository = statsRepository;
    }

    @Transactional
    public StatsEntity save(StatsEntity statsEntity) {
        return statsRepository.save(statsEntity);
    }

    public List<StatsEntity> findAllStats() {
        return statsRepository.findAll();
    }

    // Metodo para buscar una entidad por ID
    public StatsEntity findById(Long id) {
        return statsRepository.findById(id).orElse(null);
    }


    public StatsEntity convertToEntity(StatsAllDto statsDto) {

        StatsEntity statsEntity = new StatsEntity();

        statsEntity.setRatio(statsDto.getRatio());
        statsEntity.setCountHumanDNA(statsDto.getCountHumanDNA());
        statsEntity.setCountMutantDNA(statsDto.getCountMutantDNA());
        return statsEntity;

    }

    public StatsAllDto convertToDto(StatsEntity statsEntity) {

        StatsAllDto statsAllDto = new StatsAllDto();

        statsAllDto.setRatio(statsEntity.getRatio());
        statsAllDto.setCountHumanDNA(statsEntity.getCountHumanDNA());
        statsAllDto.setCountMutantDNA(statsEntity.getCountMutantDNA());

        return statsAllDto;

    }

    public StatsEntity updateStats(int countMutantDNA, int countHumanDNA) {
        StatsEntity stats = new StatsEntity();

        // Asignar los valores recibidos
        stats.setCountMutantDNA(countMutantDNA);
        stats.setCountHumanDNA(countHumanDNA);

        // Calcular el ratio
        int total = countMutantDNA + countHumanDNA;
        if (total > 0) {
            stats.setRatio((double) countMutantDNA / total);
        } else {
            stats.setRatio(0.0);
        }

        // Guardar la nueva entidad en la base de datos
        return statsRepository.save(stats);
    }

}
