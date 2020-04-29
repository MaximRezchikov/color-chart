package com.mr13.colorchart.components.picture.controller;

import com.mr13.colorchart.components.picture.domain.Picture;
import com.mr13.colorchart.components.picture.service.PictureService;
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
public class FileController extends CommonController<Picture> {

  private final PictureService pictureService;

  @PostMapping
  public void uploadFile(@RequestParam("file") MultipartFile file) {
    pictureService.uploadFile(file);
  }
}
