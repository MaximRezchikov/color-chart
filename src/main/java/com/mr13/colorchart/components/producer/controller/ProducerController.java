package com.mr13.colorchart.components.producer.controller;

import com.mr13.colorchart.components.producer.converter.ProducerToProducerNameConverter;
import com.mr13.colorchart.components.producer.domain.Producer;
import com.mr13.colorchart.components.producer.dto.ProducerForm;
import com.mr13.colorchart.components.producer.service.ProducerService;
import com.mr13.colorchart.components.producer.service.ProducerServiceImpl;
import com.mr13.colorchart.core.controller.CommonController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static com.mr13.colorchart.core.constants.URLConstant.NAMES_URL;
import static com.mr13.colorchart.core.constants.URLConstant.PRODUCER_BASE_URL;

@RestController
@RequestMapping(PRODUCER_BASE_URL)
@RequiredArgsConstructor
public class ProducerController extends CommonController<Producer> {

  private final ProducerService producerService;
  private final ProducerServiceImpl producerServiceImpl;
  private final ProducerToProducerNameConverter producerToProducerNameConverter;

  @GetMapping(NAMES_URL)
  public List<String> getProducerNames() {

    List<Producer> allProducers = producerServiceImpl.getAll();

    return producerToProducerNameConverter.convert(allProducers);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Producer saveProducer(@Valid @RequestBody ProducerForm producerForm) {
    return producerService.save(producerForm);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Producer updateProducer(@PathVariable("id") Long producerId, @Valid @RequestBody ProducerForm producerForm) {
    return producerService.update(producerId, producerForm);
  }
}
