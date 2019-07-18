package com.mykafka.kafkaexampleOne.repository;

import com.mykafka.kafkaexampleOne.entities.Personas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface PersonasRepository extends JpaRepository<Personas, Integer> {
}
