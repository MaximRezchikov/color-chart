package com.mr13.colorchart.components.pigment.converter;

import com.mr13.colorchart.components.pigment.domain.Pigment;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PigmentToPigmentIndexConverter implements Converter<List<Pigment>, List<String>> {

  @Override
  public List<String> convert(List<Pigment> pigments) {
    return pigments.stream()
        .map(Pigment::getPigmentIndex)
        .collect(Collectors.toList());
  }
}
