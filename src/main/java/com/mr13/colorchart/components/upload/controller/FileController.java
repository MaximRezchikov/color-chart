package com.mr13.colorchart.components.upload.controller;

import com.mr13.colorchart.components.upload.domain.File;
import com.mr13.colorchart.components.upload.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {

  private final FileService fileService;

  @GetMapping("/{id}")
  public File getFile(@PathVariable("id") Long fileId) {
    return fileService.getById(fileId);
  }

  @GetMapping
  public List<File> getFiles() {
    return fileService.getAllFiles();
  }

  @PostMapping
  public void uploadFile(@RequestParam("file") MultipartFile file) {
    fileService.uploadFile(file);
  }
}
