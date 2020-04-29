package com.mr13.colorchart.components.picture.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
public class PictureForm {

  private MultipartFile picture;
}
