package com.amchis.officewebsite.jpa;

import com.amchis.officewebsite.domain.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Integer> {


}