package com.example.parcialProgramacion.repositories;


import com.example.parcialProgramacion.domain.entities.StatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface StatsRepository extends JpaRepository<StatsEntity, Long> {}
