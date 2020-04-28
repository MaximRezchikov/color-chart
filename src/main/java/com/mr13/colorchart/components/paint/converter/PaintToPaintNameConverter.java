package com.mr13.colorchart.components.paint.converter;

import org.springframework.core.convert.converter.Converter;
import com.mr13.colorchart.components.paint.domain.Paint;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaintToPaintNameConverter implements Converter<List<Paint>, List<String>> {

  @Override
  public List<String> convert(List<Paint> paints) {

    return paints.stream()
        .map(Paint::getName)
        .collect(Collectors.toList());
  }
}
