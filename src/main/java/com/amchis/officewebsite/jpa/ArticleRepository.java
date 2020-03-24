package com.amchis.officewebsite.jpa;

import com.amchis.officewebsite.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long>{
}