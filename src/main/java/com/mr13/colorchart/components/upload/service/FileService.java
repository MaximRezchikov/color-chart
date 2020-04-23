package com.mr13.colorchart.components.upload.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

  void uploadFile(MultipartFile file);
}
