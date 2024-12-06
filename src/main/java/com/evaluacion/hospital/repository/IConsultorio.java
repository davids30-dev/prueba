package com.evaluacion.hospital.repository;

import com.evaluacion.hospital.Entity.Consultorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConsultorio extends JpaRepository<Consultorio,Long> {
}
