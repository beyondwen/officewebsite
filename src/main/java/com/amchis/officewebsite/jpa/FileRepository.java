package com.amchis.officewebsite.jpa;

import com.amchis.officewebsite.domain.TransferFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<TransferFile, Integer> {

    TransferFile findByRelatedIdAndOrderNum(Integer relatedId,Integer orderNum);

    TransferFile findByVideoCoverId(Integer viderCoverId);
}