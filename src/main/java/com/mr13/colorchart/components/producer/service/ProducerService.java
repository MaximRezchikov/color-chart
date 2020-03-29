package com.mr13.colorchart.components.producer.service;

import com.mr13.colorchart.components.producer.domain.Producer;
import com.mr13.colorchart.components.producer.dto.ProducerForm;

public interface ProducerService {

  Producer save(ProducerForm producerForm);

  Producer get(Long producerId);
}
