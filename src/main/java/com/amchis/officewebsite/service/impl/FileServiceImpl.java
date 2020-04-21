package com.amchis.officewebsite.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseApiService;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.domain.TransferFile;
import com.amchis.officewebsite.domain.viewdo.ViewTransferFile;
import com.amchis.officewebsite.jpa.FileRepository;
import com.amchis.officewebsite.service.FileService;
import com.amchis.officewebsite.utils.MeiteBeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
@Slf4j
public class FileServiceImpl extends BaseApiService implements FileService {

    @Autowired
    private FileRepository fileRepository;

    @Override
    public BaseResponse upload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            //获得服务器根路径
            String rootPath = "/home/mhsy/mhsyplatform/record/";
            //创建的文件夹名称
            String path = "/";
            java.io.File dir = new java.io.File(rootPath + path);
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
                TransferFile systemTransferFile = new TransferFile();
                systemTransferFile.setFileUrl(serverPath);
                TransferFile savedTransferFile = fileRepository.save(systemTransferFile);
                ViewTransferFile viewTransferFile = MeiteBeanUtils.doToDto(savedTransferFile, ViewTransferFile.class);
                if (viewTransferFile != null) {
                    viewTransferFile.setFileUrl("/file/view?url="+serverPath);
                    return setResultSuccess(viewTransferFile);
                }
                return setResultError("上传失败");
            } catch (Exception e) {
                e.printStackTrace();
                return setResultError("上传失败");
            }
        }
        return setResultError("上传失败");
    }


    public ResponseEntity<byte[]> view(String imgUrl) {
        try {
            HttpHeaders headers = new HttpHeaders();
            java.io.File file = new java.io.File(imgUrl);
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
        TransferFile one = fileRepository.getOne(id);
        if (one != null) {
            fileRepository.delete(one);
            return setResultSuccess("删除成功");
        }
        return setResultSuccess("删除失败");
    }
}