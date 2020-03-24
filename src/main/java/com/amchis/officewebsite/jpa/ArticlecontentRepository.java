package com.amchis.officewebsite.jpa;

import com.amchis.officewebsite.domain.Articlecontent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlecontentRepository extends JpaRepository<Articlecontent, Integer>{
}