package com.mr13.colorchart.components.producer.service;

import com.mr13.colorchart.components.producer.domain.Producer;
import com.mr13.colorchart.components.producer.dto.ProducerForm;

import java.util.List;

public interface ProducerService {

  Producer save(ProducerForm producerForm);

  Producer getOne(Long producerId);

  List<Producer> getAllProducer();

  Producer update(Long producerId, ProducerForm producerForm);

  void delete(Long producerId);
}
