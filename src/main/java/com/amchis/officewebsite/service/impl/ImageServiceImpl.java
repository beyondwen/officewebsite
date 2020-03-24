package com.amchis.officewebsite.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseApiService;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.domain.ImageUpload;
import com.amchis.officewebsite.jpa.ImageUploadRepository;
import com.amchis.officewebsite.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
@Slf4j
public class ImageServiceImpl extends BaseApiService implements ImageService {

    @Autowired
    private ImageUploadRepository imageUploadRepository;

    @Override
    public BaseResponse uploadImage(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            //获得服务器根路径
            String rootPath = "/home/mhsy/mhsyplatform/record/";
            //创建的文件夹名称
            String path = "/";
            File dir = new File(rootPath + path);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            // 写文件到服务器
            try {
                String fileName = file.getOriginalFilename();
                String serverFileUrlName = UUID.randomUUID().toString();
                String serverPath = dir.getAbsolutePath() + "/" + serverFileUrlName + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
                File serverFile = new File(serverPath);
                file.transferTo(serverFile);
                ImageUpload upFile = new ImageUpload();
                upFile.setImageUrl(serverPath);
                ImageUpload save = imageUploadRepository.save(upFile);
                if (save != null) {
                    //Integer id = save.getId();
                    return setResultSuccess(save);
                }
                return setResultError("上传失败");
            } catch (Exception e) {
                e.printStackTrace();
                return setResultError("上传失败");
            }
        }
        return setResultError("上传失败");
    }


    public ResponseEntity<byte[]> imageView(String imgUrl) {
        try {
            HttpHeaders headers = new HttpHeaders();
            File file = new File(imgUrl);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", imgUrl);
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BaseResponse<JSONObject> delete(Integer id) {
        ImageUpload one = imageUploadRepository.getOne(id);
        if (one != null) {
            imageUploadRepository.delete(one);
            return setResultSuccess("删除成功");
        }
        return setResultSuccess("删除失败");
    }
}
