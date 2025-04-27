package com.example.order_online.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.example.order_online.common.Result;
import com.example.order_online.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/files")
public class FileController {
    @Autowired
    private FileService fileService;
    @Value("${files.upload.dashimg.path}")
    private String dashimgUploadPath;
    @Value("${files.upload.userimg.path}")
    private String userimgUploadPath;
    @GetMapping("/dashimg/{filename}")
    public ResponseEntity<Resource> getdashimg(@PathVariable String filename) {
        return fileService.getfile(filename,"dashmenu");
    }
    @PostMapping("/dashimg")
    public Result dashimgupload(@RequestParam MultipartFile file) throws IOException {
        String url = fileService.upload(file, dashimgUploadPath,"dashimg");
        return Result.success(url);
    }
    @GetMapping("/userimg/{filename}")
    public ResponseEntity<Resource> getuserimg(@PathVariable String filename) {return fileService.getfile(filename,"userimg");}
    @PostMapping("/userimg")
    public Result userimgupload(@RequestParam MultipartFile file) throws IOException {
        String url = fileService.upload(file, userimgUploadPath,"userimg");
        return Result.success(url);
    }
}
