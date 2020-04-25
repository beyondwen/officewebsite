package com.amchis.officewebsite.jpa;

import com.amchis.officewebsite.domain.Content;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Integer> {


    Page<Content> findAll(Specification specification, Pageable pageable);

    Content findTopByFirstPageOrSecondPageOrderByCreateTimeDesc(String firstPage,String secondPage);
}