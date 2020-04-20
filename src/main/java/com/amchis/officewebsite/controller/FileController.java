package com.amchis.officewebsite.controller;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public BaseResponse<JSONObject> upload(@RequestParam("file") MultipartFile file) {
        return fileService.uploadImage(file);
    }

    //下载(展示项目页面上的图片)
    @GetMapping("/imageView")
    public ResponseEntity<byte[]> imageView(@RequestParam("imgUrl") String imgUrl) {
        return fileService.imageView(imgUrl);
    }

    @GetMapping("/delete/{id}")
    public BaseResponse<JSONObject> delete(@PathVariable("id") int id) {
        return fileService.delete(id);
    }
}
