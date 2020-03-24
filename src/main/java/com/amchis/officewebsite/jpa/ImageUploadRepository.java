package com.amchis.officewebsite.jpa;

import com.amchis.officewebsite.domain.ImageUpload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageUploadRepository extends JpaRepository<ImageUpload, Integer>{
}