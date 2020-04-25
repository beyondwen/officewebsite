package com.amchis.officewebsite.jpa;

import com.amchis.officewebsite.domain.TransferFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<TransferFile, Integer> {

    TransferFile findByRelatedIdAndOrderNum(Integer relatedId, Integer orderNum);

    TransferFile findByVideoCoverId(Integer viderCoverId);

    List<TransferFile> findByRelatedId(Integer relatedId);
}