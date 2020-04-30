package com.mr13.colorchart.components.picture.converter;

import com.mr13.colorchart.components.picture.domain.Picture;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PictureToPictureName implements Converter<List<Picture>, List<String>> {

  @Override
  public List<String> convert(List<Picture> pictures) {
    return pictures.stream()
        .map(Picture::getName)
        .collect(Collectors.toList());
  }
}
