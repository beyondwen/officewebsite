package com.amchis.officewebsite.jpa;

import com.amchis.officewebsite.domain.EnergyDynamics;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnergyDynamicsRepository extends JpaRepository<EnergyDynamics, Integer> {
    Page<EnergyDynamics> findAll(Specification specification, Pageable pageable);
}