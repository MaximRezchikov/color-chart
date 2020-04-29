package com.mr13.colorchart.components.picture.service;

import com.mr13.colorchart.components.picture.dto.PictureForm;
import org.springframework.web.multipart.MultipartFile;

public interface PictureService {

  void uploadFile(PictureForm pictureForm);
}
