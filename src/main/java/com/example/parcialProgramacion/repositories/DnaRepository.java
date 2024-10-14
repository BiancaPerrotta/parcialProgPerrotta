package com.example.parcialProgramacion.repositories;

import com.example.parcialProgramacion.domain.entities.DnaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DnaRepository extends JpaRepository<DnaEntity, Long> {
}
