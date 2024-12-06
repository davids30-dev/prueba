package com.evaluacion.hospital.repository;

import com.evaluacion.hospital.Entity.Doctores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctores extends JpaRepository<Doctores,Long> {
}
