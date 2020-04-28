package com.mr13.colorchart.components.producer.service;

import com.mr13.colorchart.components.error.NotFoundException;
import com.mr13.colorchart.components.producer.domain.Producer;
import com.mr13.colorchart.components.producer.dto.ProducerForm;
import com.mr13.colorchart.components.producer.repo.ProducerRepository;
import com.mr13.colorchart.core.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl extends CommonService<Producer> implements ProducerService {

  private final ProducerRepository producerRepository;

  @Override
  @Transactional
  public Producer save(ProducerForm producerForm) {

    String nameToUpperCase = producerForm.getProducerName();
    String producerName = nameToUpperCase.toUpperCase();
    String countryToUpperCase = producerForm.getCountry();
    String country = countryToUpperCase.toUpperCase();

    Producer producer = Producer.builder()
        .producerName(producerName)
        .country(country)
        .build();

    return producerRepository.save(producer);
  }


  @Override
  @Transactional
  public Producer update(Long producerId, ProducerForm producerForm) {

    String producerName = producerForm.getProducerName();
    String country = producerForm.getCountry();

    if (exists(producerId)) {

      Producer producerToChange = getOne(producerId);

      producerToChange.setProducerName(producerName);
      producerToChange.setCountry(country);

      return producerRepository.save(producerToChange);
    }
    else {
      throw new NotFoundException();
    }
  }

  @Override
  @Transactional
  public Producer getOne(Long entityId) {
    return super.getOne(entityId);
  }

  @Override
  @Transactional
  public Producer getByName(String producerName) {
    return producerRepository.getByProducerName(producerName);
  }

  @Override
  @Transactional
  public List<Producer> getAll() {
    return super.getAll();
  }

  @Override
  @Transactional
  public Producer delete(Long entityId) {
    return super.delete(entityId);
  }

  @Override
  public JpaRepository<Producer, Long> getRepository() {
    return producerRepository;
  }
}
