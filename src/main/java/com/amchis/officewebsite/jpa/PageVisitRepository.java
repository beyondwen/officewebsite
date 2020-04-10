package com.amchis.officewebsite.jpa;

import com.amchis.officewebsite.domain.PageVisit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PageVisitRepository extends JpaRepository<PageVisit, Integer> {
}