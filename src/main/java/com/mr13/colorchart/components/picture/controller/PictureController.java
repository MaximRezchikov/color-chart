package com.mr13.colorchart.components.picture.controller;

import com.mr13.colorchart.components.picture.domain.Picture;
import com.mr13.colorchart.components.picture.dto.PictureForm;
import com.mr13.colorchart.components.picture.service.PictureService;
import com.mr13.colorchart.core.controller.CommonController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/picture")
@RequiredArgsConstructor
public class PictureController extends CommonController<Picture> {

  private final PictureService pictureService;

  @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public void uploadFile(@ModelAttribute PictureForm pictureForm) {
    pictureService.uploadFile(pictureForm);
  }
}
