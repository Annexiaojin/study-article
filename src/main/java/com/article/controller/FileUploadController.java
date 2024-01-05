package com.article.controller;

import com.article.entity.Result;
import com.article.utils.QCloudCosUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
public class FileUploadController {
    @Autowired
    private QCloudCosUtils qCloudCosUtils;
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file){
        String upload = qCloudCosUtils.upload(file);
        if (upload != null){
               return Result.success(upload);
        }
        return Result.error("文件上传错误");
    }
}
