package com.mr13.colorchart.components.picture.controller;

import com.mr13.colorchart.components.picture.converter.PictureToPictureName;
import com.mr13.colorchart.components.picture.domain.Picture;
import com.mr13.colorchart.components.picture.dto.PictureForm;
import com.mr13.colorchart.components.picture.service.PictureService;
import com.mr13.colorchart.components.picture.service.PictureServiceImpl;
import com.mr13.colorchart.core.controller.CommonController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.mr13.colorchart.core.constants.URLConstant.NAMES_URL;

@RestController
@RequestMapping("/picture")
@RequiredArgsConstructor
public class PictureController extends CommonController<Picture> {

  private final PictureService pictureService;
  private final PictureServiceImpl pictureServiceImpl;
  private final PictureToPictureName pictureToPictureName;

  @GetMapping(NAMES_URL)
  public List<String> getByName() {

    List<Picture> pictures = pictureServiceImpl.getAll();

    return pictureToPictureName.convert(pictures);
  }

  @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public void uploadFile(@ModelAttribute PictureForm pictureForm) {
    pictureService.uploadFile(pictureForm);
  }
}
