package com.amchis.officewebsite.service;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "图片相关")
public interface FileService {

    @ApiOperation("图片上传")
    BaseResponse<JSONObject> upload(@RequestParam("file") MultipartFile file);

    @ApiOperation("图片删除")
    BaseResponse<JSONObject> delete(@RequestParam("id") Integer id);

    @ApiOperation("文件下载/图片回显")
    ResponseEntity<byte[]> view(@RequestParam("imgUrl") String imgUrl);
}