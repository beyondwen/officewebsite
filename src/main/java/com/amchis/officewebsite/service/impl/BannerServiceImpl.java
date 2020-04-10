package com.amchis.officewebsite.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseApiService;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.domain.Banner;
import com.amchis.officewebsite.domain.BannerArry;
import com.amchis.officewebsite.domain.Image;
import com.amchis.officewebsite.jpa.BannerRepository;
import com.amchis.officewebsite.jpa.ImageRepository;
import com.amchis.officewebsite.service.BannerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BannerServiceImpl extends BaseApiService implements BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public BaseResponse<JSONObject> save(BannerArry bannerArry) {
        Banner[] banners = bannerArry.getBanners();
        for (Banner banner : banners) {
            Integer imageId = banner.getImageId();
            Optional<Image> image = imageRepository.findById(imageId);
            if (image.isPresent()){
                Image image1 = image.get();
                String imageUrl = "/image/imageView?imgUrl="+image1.getImageUrl();
                banner.setImageUrl(imageUrl);
                bannerRepository.save(banner);
                return setResultSuccess();
            }
            return setResultError("上传图片id未获取到");
        }
        return setResultError("保存失败");
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
    public BaseResponse<JSONObject> list(Integer type) {
        List<Banner> banners = bannerRepository.findByType(type);
        return setResultSuccess(banners);
    }
}
