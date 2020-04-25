package com.amchis.officewebsite.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseApiService;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.base.request.BannerPageQuery;
import com.amchis.officewebsite.base.response.CommonCode;
import com.amchis.officewebsite.base.response.QueryResponseResult;
import com.amchis.officewebsite.base.response.QueryResult;
import com.amchis.officewebsite.domain.Banner;
import com.amchis.officewebsite.domain.FileArry;
import com.amchis.officewebsite.domain.TransferFile;
import com.amchis.officewebsite.domain.dto.BannerDto;
import com.amchis.officewebsite.domain.dto.TransferFileDto;
import com.amchis.officewebsite.domain.dto.TransferFileVideoDto;
import com.amchis.officewebsite.jpa.BannerRepository;
import com.amchis.officewebsite.jpa.FileRepository;
import com.amchis.officewebsite.service.BannerService;
import com.amchis.officewebsite.utils.MeiteBeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BannerServiceImpl extends BaseApiService implements BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    @Autowired
    private FileRepository fileRepository;

    @Override
    public BaseResponse<JSONObject> saveupdate(BannerDto bannerDto) {
        Integer id1 = bannerDto.getId();
        String firstPage = bannerDto.getFirstPage();
        FileArry[] fileArries = bannerDto.getFileArries();
        Integer id;
        if (id1 == null) {
            Banner banner = new Banner();
            banner.setFirstPage(firstPage);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = sdf.format(new Date());
            banner.setCreateTime(format);
            banner.setUpdateTime(format);
            Banner save = bannerRepository.save(banner);
            id = save.getId();
            for (FileArry fileArry : fileArries) {
                Optional<TransferFile> optional = fileRepository.findById(fileArry.getFileId());
                if (optional.isPresent()) {
                    TransferFile transferFile = optional.get();
                    transferFile.setLink(fileArry.getLink());
                    transferFile.setOrderNum(fileArry.getOrder());
                    transferFile.setRelatedId(id);
                    transferFile.setType(fileArry.getType());
                    transferFile.setCreateTime(format);
                    transferFile.setUpdateTime(format);
                    fileRepository.save(transferFile);
                }
            }
            return setResultSuccess();
        } else {
            Optional<Banner> optional = bannerRepository.findById(id1);
            if (optional.isPresent()) {
                Banner banner = optional.get();
                banner.setFirstPage(firstPage);
                bannerRepository.save(banner);
                id = banner.getId();
                for (FileArry fileArry : fileArries) {
                    Optional<TransferFile> optional1 = fileRepository.findById(fileArry.getFileId());
                    if (optional1.isPresent()) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String format = sdf.format(new Date());
                        TransferFile transferFile = optional1.get();
                        transferFile.setLink(fileArry.getLink());
                        transferFile.setOrderNum(fileArry.getOrder());
                        transferFile.setRelatedId(id);
                        transferFile.setCreateTime(format);
                        transferFile.setUpdateTime(format);
                        fileRepository.save(transferFile);
                    }
                }
            }
            return setResultSuccess();
        }
    }

    @Override
    public BaseResponse<JSONObject> delete(Integer id) {
        try {
            bannerRepository.deleteById(id);
            return setResultSuccess("删除成功");
        } catch (Exception e) {
            return setResultError("删除失败");
        }
    }

    @Override
    public QueryResponseResult findPageList(int page, int size, BannerPageQuery pageQuery) {
        //分页参数
        if (page <= 0) {
            page = 1;
        }
        page = page - 1;
        if (size <= 0) {
            size = 10;
        }
        //排序规则和分页
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(page, size, sort);
        Specification specification = (Specification) (root, criteriaQuery, cb) -> {
            Predicate predicate = cb.conjunction();
            //String type = pageQuery.getType();
            String firstPage = pageQuery.getFirstPage();
            //String secondPage = pageQuery.getSecondPage();
           /* //起始日期
            if (StringUtils.isNotEmpty(startTime)) {
                predicate.getExpressions().add(cb.greaterThanOrEqualTo(root.get("createTime").as(String.class), startTime));
            }
            //结束日期
            if (StringUtils.isNotEmpty(endTime)) {
                predicate.getExpressions().add(cb.lessThanOrEqualTo(root.get("createTime").as(String.class), endTime));
            }*/
            /*if (StringUtils.isNotEmpty(firstPage)) {
                predicate = cb.and(predicate, cb.equal(root.get("type"), firstPage));
            }*/
            if (StringUtils.isNotEmpty(firstPage)) {
                predicate = cb.and(predicate, cb.like(root.get("firstPage"), "%" + firstPage + "%"));
            }
            /*if (StringUtils.isNotEmpty(secondPage)) {
                predicate = cb.and(predicate, cb.like(root.get("secondPage"), "%" + secondPage + "%"));
            }*/
            return predicate;
        };
        Page<Banner> all = bannerRepository.findAll(specification, pageable);
        QueryResult<Banner> queryResult = new QueryResult<>();
        //数据列表
        queryResult.setList(all.getContent());
        //数据总记录数
        queryResult.setTotal(all.getTotalElements());
        return new QueryResponseResult(CommonCode.SUCCESS, queryResult);
    }

    @Override
    public BaseResponse<JSONObject> findByFirstPage(String firstPage) {
        Banner banner = bannerRepository.findTopByFirstPageOrderByCreateTimeDesc(firstPage);
        if (banner != null){

            List<TransferFile> bannerFiles = fileRepository.findByRelatedId(banner.getId());
            List<Object> bannerLink = new ArrayList<>();
            for (TransferFile bannerFile : bannerFiles) {
                TransferFileDto transferFileDto = MeiteBeanUtils.doToDto(bannerFile, TransferFileDto.class);
                transferFileDto.setFileUrl("/file/view?url=" + bannerFile.getFileUrl());
                TransferFile transferFile = fileRepository.findByRelatedIdAndOrderNum(bannerFile.getRelatedId(), bannerFile.getOrderNum());
                TransferFile transferFileVideo = fileRepository.findByVideoCoverId(transferFile.getId());
                if (transferFileVideo != null) {
                    TransferFileVideoDto video = new TransferFileVideoDto();
                    video.setCoverId(transferFileVideo.getId());
                    video.setCoverFileUrl("/file/view?url=" + transferFileVideo.getFileUrl());
                    video.setCoverLink(transferFileVideo.getLink());
                    video.setCoverOrderNum(transferFileVideo.getOrderNum());
                    video.setCoverRelatedId(transferFileVideo.getRelatedId());
                    video.setCoverType(transferFileVideo.getType());
                    video.setCoverVideoCoverId(transferFileVideo.getVideoCoverId());
                    video.setId(transferFileDto.getId());
                    video.setFileUrl(transferFileDto.getFileUrl());
                    video.setLink(transferFileDto.getLink());
                    video.setOrderNum(transferFileDto.getOrderNum());
                    video.setType(transferFileDto.getType());
                    video.setVideoCoverId(transferFileDto.getVideoCoverId());
                    video.setRelatedId(transferFileDto.getRelatedId());
                    video.setCreateTime(transferFileDto.getCreateTime());
                    video.setUpdateTime(transferFileDto.getUpdateTime());
                    video.setCreateUsername(transferFileDto.getCreateUsername());
                    bannerLink.add(video);
                } else {
                    bannerLink.add(transferFileDto);
                }
            }
            return setResultSuccess(bannerLink);
        }
        return setResultError("未找到");
    }
}
