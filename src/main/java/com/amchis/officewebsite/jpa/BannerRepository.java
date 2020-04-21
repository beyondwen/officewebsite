package com.amchis.officewebsite.jpa;

import com.amchis.officewebsite.domain.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerRepository extends JpaRepository<Banner, Integer> {
}