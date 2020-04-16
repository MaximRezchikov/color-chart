package com.mr13.colorchart.components.producer.service;

import com.mr13.colorchart.components.producer.domain.Producer;
import com.mr13.colorchart.components.producer.dto.ProducerForm;
import com.mr13.colorchart.components.producer.repo.ProducerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {

  private final ProducerRepository producerRepository;

  @Override
  @Transactional
  public Producer save(ProducerForm producerForm) {

    String name = producerForm.getProducerName();
    String country = producerForm.getCountry();

    Producer producer = Producer.builder()
        .producerName(name)
        .country(country)
        .build();

    return producerRepository.save(producer);
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public Producer getOne(Long producerId) {
    return producerRepository.getOne(producerId);
  }

  @Override
  @Transactional
  public List<Producer> getAllProducer() {
    return producerRepository.findAll();
  }

  @Override
  @Transactional
  public Producer update(Long producerId, ProducerForm producerForm) {

    String producerName = producerForm.getProducerName();
    String country = producerForm.getCountry();

    Producer producerToChange = getOne(producerId);

    producerToChange.setProducerName(producerName);
    producerToChange.setCountry(country);

    return producerRepository.save(producerToChange);
  }

  @Override
  public void delete(Long producerId) {
    producerRepository.deleteById(producerId);
  }
}
