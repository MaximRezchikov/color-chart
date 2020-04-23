package com.mr13.colorchart.components.upload.controller;

import com.mr13.colorchart.components.upload.domain.File;
import com.mr13.colorchart.components.upload.service.FileService;
import com.mr13.colorchart.core.controller.CommonController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController extends CommonController<File> {

  private final FileService fileService;

  @PostMapping
  public void uploadFile(@RequestParam("file") MultipartFile file) {
    fileService.uploadFile(file);
  }
}
