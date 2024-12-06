package com.evaluacion.hospital.repository;

import com.evaluacion.hospital.Entity.Citas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICitas extends JpaRepository<Citas,Long> {
}
