package com.amchis.officewebsite.jpa;

import com.amchis.officewebsite.domain.StoriesSuccess;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoriesSuccessRepository extends JpaRepository<StoriesSuccess, Integer>{
    Page<StoriesSuccess> findAll(Specification specification, Pageable pageable);
}