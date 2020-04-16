package com.mr13.colorchart.components.producer.converter;

import com.mr13.colorchart.components.producer.domain.Producer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProducerToProducerNameConverter implements Converter<List<Producer>, List<String>> {

  @Override
  public List<String> convert(List<Producer> producers) {
    return producers.stream()
        .map(Producer::getProducerName)
        .collect(Collectors.toList());
  }
}
