package com.amchis.officewebsite.jpa;

import com.amchis.officewebsite.domain.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BannerRepository extends JpaRepository<Banner, Integer> {

    List<Banner> findByType(Integer type);
}