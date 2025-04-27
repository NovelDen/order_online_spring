package com.example.order_online.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

public interface FileService {
    public ResponseEntity<Resource> getfile(String filename,String path);
    public String upload(MultipartFile file, String path,String pathName) throws IOException;
}
