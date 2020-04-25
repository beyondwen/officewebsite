package com.amchis.officewebsite.jpa;

import com.amchis.officewebsite.domain.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerRepository extends JpaRepository<Banner, Integer> {

    Page<Banner> findAll(Specification specification, Pageable pageable);

    Banner findTopByFirstPageOrderByCreateTimeDesc(String firstPage);

}