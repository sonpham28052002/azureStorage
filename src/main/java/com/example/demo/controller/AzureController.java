package com.example.demo.controller;

import com.example.demo.storages.AzureStorageServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("azure")
public class AzureController {
    @Autowired
    private AzureStorageServive azureStorageServive;

    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file) throws IOException {
        String type =file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
        return azureStorageServive.uploadFile(UUID.randomUUID().toString()+"."+type,file.getInputStream(),file.getSize(),file.getContentType());
    }
    @GetMapping("/file")
    public String string(){
        return "phạm thanh son";
    }
}
