package com.amchis.officewebsite.jpa;

import com.amchis.officewebsite.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer>{
}