package com.mr13.colorchart.components.picture.service;

import org.springframework.web.multipart.MultipartFile;

public interface PictureService {

  void uploadFile(MultipartFile file);
}
