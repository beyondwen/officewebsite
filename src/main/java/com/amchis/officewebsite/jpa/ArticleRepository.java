package com.amchis.officewebsite.jpa;

import com.amchis.officewebsite.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer>{
    Page<Article> findAll(Specification specification, Pageable pageable);
}